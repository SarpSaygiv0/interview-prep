package com.medium.removekthnodefromend;

import com.util.LinkedList;

public class RemoveKthNodeFromEnd {

    public void removeKthNodeFromEnd(LinkedList head, int k) {
        LinkedList node = head;
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        node = head;
        int kthElement = length - k;
        if (kthElement == 0) {
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }
        for (int i = 0; i < kthElement - 1; i++) {
            node = node.next;
        }

        LinkedList kThNode = node.next;
        node.next = kThNode.next;

    }
}
