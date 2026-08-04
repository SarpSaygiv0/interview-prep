package com.katas.ledger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LedgerTest {

    private static final String PRN = "34/1188";

    private static final LocalDate MAR_01 = LocalDate.of(2026, 3, 1);
    private static final LocalDate MAR_09 = LocalDate.of(2026, 3, 9);
    private static final LocalDate MAR_12 = LocalDate.of(2026, 3, 12);
    private static final LocalDate MAR_20 = LocalDate.of(2026, 3, 20);
    private static final LocalDate MAR_23 = LocalDate.of(2026, 3, 23);
    private static final LocalDate MAR_31 = LocalDate.of(2026, 3, 31);

    private Building building;

    @BeforeEach
    void setUp() {
        Ledger ledger = new Ledger();
        ledger.addBuilding(new Building(PRN, "Gül Apartmanı"));
        building = ledger.getBuilding(PRN);
    }

    @Test
    void balanceSumsEverythingRecorded() {
        record(MAR_01, "50000");
        record(MAR_12, "-20000");

        assertThat(building.getBalance()).isEqualByComparingTo("30000");
    }

    @Test
    void statementKeepsBothBoundaryDatesDropsTheRestAndOrdersByDate() {
        recordMarch();

        assertThat(building.getStatement(MAR_12, MAR_23))
                .extracting(line -> line.transaction().date())
                .containsExactly(MAR_12, MAR_20, MAR_23);
    }

    @Test
    void runningBalanceAccumulatesDownTheStatement() {
        recordMarch();

        assertThat(building.getStatement(MAR_12, MAR_23))
                .extracting(StatementLine::runningBalance)
                .usingElementComparator(BigDecimal::compareTo)
                .containsExactly(new BigDecimal("105000"),
                        new BigDecimal("135000"),
                        new BigDecimal("95000"));
    }

    @Test
    void runningBalanceOpensFromWhateverWasThereBeforeThePeriod() {
        record(MAR_01, "100000");
        record(MAR_20, "5000");

        assertThat(building.getStatement(MAR_12, MAR_23))
                .extracting(StatementLine::runningBalance)
                .usingElementComparator(BigDecimal::compareTo)
                .containsExactly(new BigDecimal("105000"));
    }

    @Test
    void askingForABuildingWeDoNotManageIsRejected() {
        assertThatThrownBy(() -> new Ledger().getBuilding("99/9999"))
                .isInstanceOf(UnknownBuildingException.class)
                .hasMessageContaining("99/9999");
    }

    private void recordMarch() {
        record(MAR_01, "100000");
        record(MAR_09, "20000");
        record(MAR_23, "-40000");
        record(MAR_12, "-15000");
        record(MAR_20, "30000");
        record(MAR_31, "10000");
    }

    private void record(LocalDate date, String amount) {
        building.record(new Transaction(date, new BigDecimal(amount), "a description"));
    }
}