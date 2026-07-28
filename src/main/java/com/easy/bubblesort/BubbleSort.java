package com.easy.bubblesort;

public class BubbleSort {


    // [8, 5, 2, 9, 5, 6, 3]
    // [5, 2, 8, 5, 6, 3, 9]

    public int[] bubbleSort(int[] arr) {
        int cap = arr.length - 1;
        boolean swapped = false;
        while (!swapped) {
            swapped = true;
            for (int i = 0; i < cap; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i);
                    swapped = false;
                }
            }
            cap--;
        }
        return arr;
    }

    public int[] swap(int[] arr, int i) {
        int temp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = temp;
        return arr;
    }

}
