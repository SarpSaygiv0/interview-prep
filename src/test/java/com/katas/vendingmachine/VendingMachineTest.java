package com.katas.vendingmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class VendingMachineTest {

    private VendingMachine vendingMachine;

    @BeforeEach
    void setVendingMachine() {
        vendingMachine = new VendingMachine();
    }

    @Test
    void customerShouldBeAbleToGetProduct() {
        loadCokesToMachine();
        vendingMachine.putMoney("1");
        vendingMachine.putMoney("0.2");
        Sale sale = vendingMachine.purchase("Coke");
        assertThat(sale.product().name()).isEqualTo("Coke");
    }

    @Test
    void customerHasInsufficientFunds() {
        loadCokesToMachine();
        vendingMachine.putMoney("0.5");
        assertThatThrownBy(() -> vendingMachine.purchase("Coke"))
                .isInstanceOf(InsufficientFundsException.class);
    }

    @Test
    void customerGetsChange() {
        loadOneWaterToMachine();
        vendingMachine.putMoney("0.5");
        Sale sale = vendingMachine.purchase("Water");
        assertThat(sale.product().name()).isEqualTo("Water");
        List<BigDecimal> coins = new ArrayList<>(
                List.of(new BigDecimal("0.2"), new BigDecimal("0.1"))
        );
        assertThat(sale.change()).isEqualTo(coins);
    }

    @Test
    void machineIsSoldOut() {
        loadOneWaterToMachine();
        vendingMachine.putMoney("1");
        vendingMachine.purchase("Water");
        assertThatThrownBy(() -> vendingMachine.purchase("Water"))
                .isInstanceOf(SoldOutException.class);
    }

    @Test
    void cancelRefundsEverything() {
        loadOneWaterToMachine();
        vendingMachine.putMoney("0.10");
        vendingMachine.putMoney("0.10");
        vendingMachine.putMoney("0.05");
        BigDecimal refund = vendingMachine.cancel();
        assertThat(refund).isEqualByComparingTo("0.25");
    }

    @Test
    void machineResetsBetweenCustomers() {
        loadCokesToMachine();
        vendingMachine.putMoney("1");
        vendingMachine.putMoney("0.2");
        vendingMachine.purchase("Coke");

        assertThatThrownBy(() -> vendingMachine.purchase("Coke"))
                .isInstanceOf(InsufficientFundsException.class);
    }

    @Test
    void onlyListedCoinsAccepted() {
        loadCokesToMachine();
        assertThatThrownBy(() -> vendingMachine.putMoney("0.15"))
                .isInstanceOf(CoinNotSupportedException.class);
    }

    @Test
    void getChangeAsCoins() {
        loadOneWaterToMachine();
        vendingMachine.putMoney("1.0");
        vendingMachine.putMoney("0.5");
        vendingMachine.putMoney("0.05");
        vendingMachine.putMoney("0.05");
        Sale sale = vendingMachine.purchase("Water");
        assertThat(sale.change())
                .usingElementComparator(BigDecimal::compareTo)
                .containsExactly(
                        new BigDecimal("1"),
                        new BigDecimal("0.2"),
                        new BigDecimal("0.2")
                );
    }

    private void loadCokesToMachine() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Coke", new BigDecimal("1.20"), 5));
        vendingMachine.loadProducts(products);
    }

    private void loadOneWaterToMachine() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Water", new BigDecimal("0.20"), 1));
        vendingMachine.loadProducts(products);
    }
}
