package com.easy.middlenode;

import com.util.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MiddleNodeTest {

    MiddleNode md;

    @BeforeEach
    void setMd() {
        md = new MiddleNode();
    }

    @Test
    public void TestCase1() {
        LinkedList linkedList = new LinkedList(0);
        linkedList.next = new LinkedList(1);
        LinkedList expected = new LinkedList(2);
        linkedList.next.next = expected;
        expected.next = new LinkedList(3);
        var actual= md.middleNode(linkedList);
        assertTrue(expected.equals(actual));
    }
}
