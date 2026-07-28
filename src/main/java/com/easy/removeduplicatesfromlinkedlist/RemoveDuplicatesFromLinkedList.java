package com.easy.removeduplicatesfromlinkedlist;

import com.util.LinkedList;



public class RemoveDuplicatesFromLinkedList {


    // 1 -> 1 -> 3 -> 4 -> 4 -> 4 -> 5 -> 6 -> 6 -> null

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList node = linkedList;
        while (node != null) {
            LinkedList nextDistinct = node;
            while (nextDistinct != null && nextDistinct.value == node.value)
                nextDistinct = nextDistinct.next;

            node.next = nextDistinct;
            node = node.next;
        }
        return linkedList;
    }


}
