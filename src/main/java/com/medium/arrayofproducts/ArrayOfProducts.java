package com.medium.arrayofproducts;

public class ArrayOfProducts {

    // [5, 1, 4, 2]
    public int[] arrayOfProducts(int[] arr) {
        int[] output = new int[arr.length];

        int leftRunningProduct = 1;
        for (int i = 0; i < arr.length; i++) {
            output[i] = leftRunningProduct;
            leftRunningProduct *= arr[i];
        }

        int rightRunningProduct = 1;
        for (int i = arr.length-1; i >= 0; i--) {
            output[i] *= rightRunningProduct;
            rightRunningProduct *= arr[i];
        }
        return output;
    }


    // naive
    public int[] arrayOfProductsNaive(int[] arr) {
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int multiplied = 1;
            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue;
                multiplied *= arr[j];
            }
            output[i] = multiplied;
        }
        return output;
    }


}












