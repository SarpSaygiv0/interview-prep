package com.katas.ledger;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

class UnknownBuildingException extends RuntimeException {

    public UnknownBuildingException(String prn) {
        super(prn);
    }
}

public class Ledger {

    private final Map<String, Building> buildings;

    public Ledger() {
        buildings = new HashMap<>();
    }

    public void addBuilding(Building building) {
        buildings.put(building.getPrn(), building);
    }

    public Building getBuilding(String prn) {
        if (!buildings.containsKey(prn))
            throw new UnknownBuildingException(prn);

        return buildings.get(prn);
    }

}


record Transaction(LocalDate date, BigDecimal amount, String description) {
}

record StatementLine(Transaction transaction, BigDecimal runningBalance) {

}

class Building {

    private final String prn;
    private final List<Transaction> transactions;
    private String name;


    public Building(String prn, String name) {
        this.prn = prn;
        this.transactions = new ArrayList<>();
        this.name = name;
    }

    public void record(Transaction transaction) {
        transactions.add(transaction);
    }

    public String getPrn() {
        return prn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return transactions.stream()
                .map(Transaction::amount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<StatementLine> getStatement(LocalDate from, LocalDate to) {
        List<Transaction> transactionsBetween = transactionsBetween(from, to);
        BigDecimal runningBalance = getBalanceBefore(from);
        List<StatementLine> statementLines = new ArrayList<>();
        for (Transaction transaction : transactionsBetween) {
            runningBalance = runningBalance.add(transaction.amount());
            statementLines.add(new StatementLine(transaction, runningBalance));
        }
        return List.copyOf(statementLines);
    }

    private BigDecimal getBalanceBefore(LocalDate date) {
        return transactions.stream()
                .filter(transaction -> transaction.date().isBefore(date))
                .map(Transaction::amount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Transaction> transactionsBetween(LocalDate from, LocalDate to) {
        return transactions.stream()
                .filter(transaction -> !transaction.date().isBefore(from) && !transaction.date().isAfter(to))
                .sorted(Comparator.comparing(Transaction::date)).toList();
    }
}
