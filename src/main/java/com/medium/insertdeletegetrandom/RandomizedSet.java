package com.medium.insertdeletegetrandom;

import java.util.*;

public class RandomizedSet {

    private final Map<Integer, Integer> indexOf;
    private final List<Integer> values;
    private final Random random;

    public RandomizedSet() {
        indexOf = new HashMap<>();
        values = new ArrayList<>();
        random = new Random();
    }

    // returns true if insert happens, otherwise false
    public boolean insert(int val) {
        if (indexOf.containsKey(val)) {
            return false;
        }

        values.add(val);
        indexOf.put(val, values.size() - 1);
        return true;
    }

    // returns true if remove happens, otherwise false
    public boolean remove(int val) {
        if (!indexOf.containsKey(val)) {
            return false;
        }

        int removedIndex = indexOf.get(val);
        int lastValue = values.getLast();
        values.set(removedIndex, lastValue);
        values.removeLast();
        indexOf.put(lastValue, removedIndex);
        indexOf.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(0, values.size());
        return values.get(randomIndex);
    }
    
}
