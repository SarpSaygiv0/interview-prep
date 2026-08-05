package com.hard;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    int maxSize;
    private final Map<String, Node> cache = new HashMap<>();
    private final Node head = new Node(null, 0);
    private final Node tail = new Node(null, 0);

    public LRUCache(int maxSize) {
        this.maxSize = Math.max(maxSize, 1);
        head.next = tail;
        tail.prev = head;
    }

    public void insertKeyValuePair(String key, int value) {
        Node existing = cache.get(key);
        if (existing != null) {
            existing.value = value;
            promote(existing);
            return;
        }
        if (cache.size() == maxSize)
            evictLastRecent();
        Node node = new Node(key, value);
        cache.put(key, node);
        linkFront(node);
    }

    private void promote(Node node) {
        unlink(node);
        linkFront(node);
    }

    private void evictLastRecent() {
        Node lastRecent = tail.prev;
        unlink(lastRecent);
        cache.remove(lastRecent.key);
    }

    public LRUResult getValueFromKey(String key) {
        Node node = cache.get(key);
        if (node == null) return null;
        promote(node);
        return new LRUResult(true, node.value);
    }

    public String getMostRecentKey() {
        return head.next == tail ? null : head.next.key;
    }

    private void unlink(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void linkFront(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    static class Node {
        String key;
        int value;
        Node prev = null;
        Node next = null;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    public static class LRUResult {
        public boolean found;
        public int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }

    }
}
