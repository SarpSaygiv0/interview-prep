package com.util;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {

    public int value;
    public LinkedList next;

    public LinkedList(int value) {
        this.value = value;
        this.next = null;
    }

    public LinkedList addMany(
            LinkedList ll, List<Integer> values
    ) {
        LinkedList current = ll;
        while (current.next != null) {
            current = current.next;
        }
        for (int value : values) {
            current.next = new LinkedList(value);
            current = current.next;
        }
        return ll;
    }

    public List<Integer> getNodesInArray(LinkedList ll) {
        List<Integer> nodes = new ArrayList<>();
        LinkedList current = ll;
        while (current != null) {
            nodes.add(current.value);
            current = current.next;
        }
        return nodes;
    }
}
