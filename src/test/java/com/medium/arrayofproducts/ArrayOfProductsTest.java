package com.medium.arrayofproducts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayOfProductsTest {

    ArrayOfProducts aop;
    @BeforeEach
    void setAop() {
        aop = new ArrayOfProducts();
    }

    @Test
    void arrayOfProductsTest() {
        int[] input = {5, 1, 4, 2};
        int[] expected = {8, 40, 10, 20};
        int[] actual = aop.arrayOfProducts(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    void arrayOfProductsNaiveTest() {
        int[] input = {5, 1, 4, 2};
        int[] expected = {8, 40, 10, 20};
        int[] actual = aop.arrayOfProductsNaive(input);
        assertArrayEquals(expected, actual);
    }
}
