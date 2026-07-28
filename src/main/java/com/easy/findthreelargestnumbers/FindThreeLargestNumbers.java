package com.easy.findthreelargestnumbers;

import java.util.ArrayList;
import java.util.Comparator;

public class FindThreeLargestNumbers {

    public int[] findThreeLargestNumbers(int[] array) {

        // add three numbers
        // compare the triplet's smallest with the next
        // if bigger than smallest, switch numbers and update smallest (sort)

        ArrayList<Integer> triplet = new ArrayList<>();
        triplet.add(array[0]);
        triplet.add(array[1]);
        triplet.add(array[2]);
        sortTriplet(triplet);

        for (int i = 3; i<array.length; i++) {
            if (triplet.get(0) < array[i]) {
                triplet.set(0, array[i]);
                sortTriplet(triplet);
            }
        }

        return triplet.stream().mapToInt(Integer::intValue).toArray();
    }

    public void sortTriplet(ArrayList<Integer> triplet) {
        triplet.sort(Comparator.comparingInt(o -> o));
    }
}
