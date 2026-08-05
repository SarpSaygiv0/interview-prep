package com.medium.timebasedkeyvaluestore;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {

    private final Map<String, TreeMap<Integer, String>> store;

    public TimeMap() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> history = store.get(key);
        if (history == null)
            return "";

        Map.Entry<Integer, String> entry = history.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }

}
