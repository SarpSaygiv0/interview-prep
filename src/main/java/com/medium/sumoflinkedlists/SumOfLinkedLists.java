package com.medium.sumoflinkedlists;

import com.util.LinkedList;

public class SumOfLinkedLists {

    public LinkedList sumOfLinkedLists(LinkedList l1, LinkedList l2) {

        LinkedList node1 = l1;
        LinkedList node2 = l2;
        LinkedList result = new LinkedList(0);
        LinkedList currNode = result;
        int carry = 0;

        while (node1 != null || node2 != null || carry != 0) {
            int val1 = node1 != null ? node1.value : 0;
            int val2 = node2 != null ? node2.value : 0;

            int sum = val1 + val2 + carry;
            LinkedList newNode = new LinkedList(sum % 10);
            currNode.next = newNode;
            currNode = newNode;
            carry = sum / 10;
            node1 = node1 != null ? node1.next : null;
            node2 = node2 != null ? node2.next : null;
        }

        return result.next;
    }
}
