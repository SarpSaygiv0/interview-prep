package com.medium.nextgreaterelement;


import java.util.ArrayDeque;
import java.util.Arrays;

public class NextGreaterElement {


    public int[] nextGreaterElement(int[] array) {
        //  0  1   2   3  4  5  6
        // [2, 5, -3, -4, 6, 7, 2]      [1, 2, 3]
        // [5, 6, 6, 6, 7, -1, -1]
        int[] output = new int[array.length];
        Arrays.fill(output, -1);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < array.length * 2; i++) {
            int circularIdx = i % array.length;
            while (!stack.isEmpty() && array[stack.peek()] < array[circularIdx]) {
                output[stack.pop()] = array[circularIdx];
            }
            stack.push(circularIdx);
        }
        return output;
    }
}
