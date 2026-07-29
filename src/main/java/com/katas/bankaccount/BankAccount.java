package com.katas.bankaccount;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Clock;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;

class NegativeAmountException extends RuntimeException {
    public NegativeAmountException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

record Transaction(BigDecimal amount, BigDecimal balance, LocalDate date) {
}

public class BankAccount {

    private BigDecimal balance = BigDecimal.ZERO;
    private final ArrayDeque<Transaction> transactions;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final Clock clock;

    public BankAccount(Clock clock) {
        this.clock = clock;
        this.transactions = new ArrayDeque<>();
    }

    public BigDecimal deposit(BigDecimal amount) {
        validateAmount(amount);
        balance = balance.add(amount);
        transactions.push(new Transaction(amount, balance, LocalDate.now(clock)));
        return balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal withdraw(BigDecimal amount) {
        validateAmount(amount);
        if (balance.compareTo(amount) < 0) {
            throw new InsufficientFundsException("The balance is lower than withdraw amount");
        }
        balance = balance.subtract(amount);
        transactions.push(new Transaction(amount.negate(), balance, LocalDate.now(clock)));
        return balance;
    }

    private static void validateAmount(BigDecimal amount) {
        if (amount.signum() == -1)
            throw new NegativeAmountException("Negative deposit amount is not allowed.");
        if (amount.signum() == 0)
            throw new NegativeAmountException("Zero deposit amount is not allowed.");
    }

    public String statement() {
        StringBuilder transactionsInfo = new StringBuilder();
        transactionsInfo.append("DATE").append("\t\tAMOUNT").append("\tBALANCE").append("\n");
        for (Transaction trn : transactions) {
            transactionsInfo.append(formatter.format(trn.date())).append("\t")
                    .append(money(trn.amount()))
                    .append("\t")
                    .append(money(trn.balance()))
                    .append("\n");
        }
        return transactionsInfo.toString();
    }

    private BigDecimal money(BigDecimal amount) {
        return amount.setScale(2, RoundingMode.HALF_UP);
    }

}
