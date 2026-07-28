package com.easy.middlenode;

import com.util.LinkedList;

public class MiddleNode {


    // 2 -> 7 -> 3 -> 5 -> 1

    public  LinkedList middleNode(LinkedList linkedList) {
        int count = 0;
        LinkedList head = linkedList;
        while (linkedList != null) {
            linkedList = linkedList.next;
            count++;
        }
        for (int i = 0; i <count/2; i++) {
            head = head.next;
        }

        return head;
    }
}
