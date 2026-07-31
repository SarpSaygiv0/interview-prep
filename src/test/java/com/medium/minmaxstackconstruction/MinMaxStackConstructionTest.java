package com.medium.minmaxstackconstruction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinMaxStackConstructionTest {

    MinMaxStack stack;

    @BeforeEach
    void setMmsc() {
        stack = new MinMaxStack();
    }

    @Test
    void minMaxStackConstructionTests() {
        stack.push(5);
        testMinMaxPeek(5, 5, 5, stack);
        stack.push(7);
        testMinMaxPeek(5, 7, 7, stack);
        stack.push(2);
        testMinMaxPeek(2, 7, 2, stack);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(7);
        testMinMaxPeek(5, 5, 5, stack);
    }

    void testMinMaxPeek(int min, int max, int peek, MinMaxStack stack) {
        assertEquals(stack.getMin(), min);
        assertEquals(stack.getMax(), max);
        assertEquals(stack.peek(), peek);
    }
}
