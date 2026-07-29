package com.katas.bankaccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BankAccountTest {

    static class MutableClock extends Clock {
        private Instant instant;

        MutableClock(String isoDate) {
            setDate(isoDate);
        }

        void setDate(String isoDate) {
            this.instant = Instant.parse(isoDate + "T00:00:00Z");
        }

        @Override
        public Instant instant() {
            return instant;
        }

        @Override
        public ZoneId getZone() {
            return ZoneOffset.UTC;
        }

        @Override
        public Clock withZone(ZoneId zone) {
            return this;
        }
    }

    BankAccount ba;
    MutableClock clock;

    @BeforeEach
    void setBa() {
        clock = new MutableClock("2012-01-10");
        ba = new BankAccount(clock);
    }

    @Test
    void bankAccountShouldDeposit() {
        BigDecimal amount = new BigDecimal(20);
        assertThat(ba.deposit(amount)).isEqualByComparingTo(amount);
    }

    @Test
    void bankAccountShouldGetBalance() {
        BigDecimal amount = new BigDecimal(20);
        ba.deposit(amount);
        assertThat(ba.getBalance()).isEqualByComparingTo(amount);
    }

    @Test
    void bankAccountShouldWithdraw() {
        BigDecimal amount = new BigDecimal(20);
        ba.deposit(amount);
        ba.withdraw(amount);
        assertThat(ba.getBalance()).isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    void bankAccountShouldNotWithdrawForInsufficientFunds() {
        BigDecimal amount = new BigDecimal(20);
        ba.deposit(amount);
        assertThatThrownBy(() -> ba.withdraw(new BigDecimal(30)))
                .isInstanceOf(InsufficientFundsException.class);
    }


    @Test
    void bankAccountShouldNotAllowNegativeDeposit() {
        BigDecimal negativeAmount = new BigDecimal(-20);
        assertThatThrownBy(() -> ba.deposit(negativeAmount))
                .isInstanceOf(NegativeAmountException.class);
    }

    @Test
    void bankAccountShouldNotAllowZeroDeposit() {
        BigDecimal negativeAmount = new BigDecimal(0);
        assertThatThrownBy(() -> ba.deposit(negativeAmount))
                .isInstanceOf(NegativeAmountException.class);
    }

    @Test
    void bankAccountShouldNotAllowNegativeWithdraw() {
        BigDecimal negativeAmount = new BigDecimal(-20);
        assertThatThrownBy(() -> ba.withdraw(negativeAmount))
                .isInstanceOf(NegativeAmountException.class);
    }

    @Test
    void statementShowsTransactionsNewestFirst() {
        ba.deposit(new BigDecimal("1000"));
        clock.setDate("2012-01-13");
        ba.deposit(new BigDecimal("2000"));
        clock.setDate("2012-01-14");
        ba.withdraw(new BigDecimal("500"));

        assertThat(ba.statement()).isEqualTo("""
                DATE\t\tAMOUNT\tBALANCE
                14/01/2012\t-500.00\t2500.00
                13/01/2012\t2000.00\t3000.00
                10/01/2012\t1000.00\t1000.00
                """);
    }
}
