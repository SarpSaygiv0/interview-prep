package com.medium.cplistwithrandompointer;

import java.util.HashMap;

public class CopyListWithRandomNumber {

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node, Node> ogToCopy = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            ogToCopy.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            ogToCopy.get(curr).next = ogToCopy.get(curr.next);
            ogToCopy.get(curr).random = ogToCopy.get(curr.random);
            curr = curr.next;
        }

        return ogToCopy.get(head);
    }

}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}