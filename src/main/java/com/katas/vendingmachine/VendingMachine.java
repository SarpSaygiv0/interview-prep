package com.katas.vendingmachine;

import java.math.BigDecimal;
import java.util.*;

record Product(String name, BigDecimal price, int unitSize) {
}

record Sale(Product product, List<BigDecimal> change) {

}


class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException() {
        super("You don't have sufficient money");
    }
}

class SoldOutException extends RuntimeException {
    public SoldOutException() {
        super("Machine is sold out");
    }
}

class CoinNotSupportedException extends RuntimeException {
    public CoinNotSupportedException() {
        super("This coin is not supported");
    }
}

public class VendingMachine {

    private final Map<String, Product> products;
    private BigDecimal currentAmount = new BigDecimal("0");

    private static final List<BigDecimal> coins = new ArrayList<>(
            List.of(
                    new BigDecimal("0.05"),
                    new BigDecimal("0.1"),
                    new BigDecimal("0.2"),
                    new BigDecimal("0.5"),
                    new BigDecimal("1"),
                    new BigDecimal("2")
            )
    );
    private static final Set<BigDecimal> ALLOWED_COINS = new TreeSet<>(coins);

    public VendingMachine() {
        products = new HashMap<>();
    }

    public void loadProducts(List<Product> newProducts) {
        for (Product p : newProducts) {
            if (products.containsKey(p.name())) {
                int existingProduct = products.get(p.name()).unitSize();
                Product replacedProduct = new Product(
                        p.name(), p.price(), p.unitSize() + existingProduct
                );
                products.put(p.name(), replacedProduct);
            } else
                products.put(p.name(), p);
        }
    }

    public void putMoney(String amount) {
        BigDecimal newAmount = new BigDecimal(amount);
        if (!isValidAmount(newAmount)) {
            throw new CoinNotSupportedException();
        }
        currentAmount = currentAmount.add(newAmount);
    }

    private boolean isValidAmount(BigDecimal currentAmount) {
        return ALLOWED_COINS.contains(currentAmount);
    }

    public Sale purchase(String productName) {
        if (!products.containsKey(productName))
            throw new RuntimeException("Product doesn't exist");

        Product p = products.get(productName);
        if (p.unitSize() <= 0)
            throw new SoldOutException();

        BigDecimal change = currentAmount.subtract(p.price());
        if (change.compareTo(BigDecimal.ZERO) < 0)
            throw new InsufficientFundsException();

        products.put(p.name(), new Product(p.name(), p.price(), p.unitSize() - 1));
        currentAmount = BigDecimal.ZERO;
        return new Sale(p, calculateCoins(change));
    }

    public BigDecimal cancel() {
        BigDecimal refund = currentAmount;
        this.currentAmount = BigDecimal.ZERO;
        return refund;
    }

    private List<BigDecimal> calculateCoins(BigDecimal change) {
        List<BigDecimal> returnedCoins = new ArrayList<>();
        BigDecimal remaining = change;
        int coinIndex = coins.size() - 1;
        while (remaining.signum() >= 0 && coinIndex >= 0) {
            BigDecimal coin = coins.get(coinIndex);
            if (remaining.compareTo(coin) >= 0) {
                returnedCoins.add(coin);
                remaining = remaining.subtract(coin);
            } else {
                coinIndex--;
            }
        }
        return returnedCoins;
    }
}
