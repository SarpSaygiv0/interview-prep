package com.medium.minheap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MinHeapTest {

    MinHeap minHeap;

    @BeforeEach
    void setMinHeap() {
        minHeap = new MinHeap(array());
    }

    @Test
    void testMinHeap() {
        minHeap.insert(6);
        assertTrue(isMinHeapSatisfied(minHeap.heap));
        assertEquals(-5, minHeap.peek());
        assertEquals(-5, minHeap.remove());
        assertTrue(isMinHeapSatisfied(minHeap.heap));
        assertEquals(2, minHeap.peek());
        assertEquals(2, minHeap.remove());
        assertTrue(isMinHeapSatisfied(minHeap.heap));
        assertEquals(6, minHeap.peek());
        minHeap.insert(87);
        assertTrue(isMinHeapSatisfied(minHeap.heap));
    }

    private static List<Integer> array() {
        return new ArrayList<>(List.of(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41));
    }

    boolean isMinHeapSatisfied(List<Integer> array) {
        for (int currentIdx = 1; currentIdx < array.size(); currentIdx++) {
            int parentIdx = (currentIdx - 1) / 2;
            if (array.get(parentIdx) > array.get(currentIdx)) {
                return false;
            }
        }

        return true;
    }
}
