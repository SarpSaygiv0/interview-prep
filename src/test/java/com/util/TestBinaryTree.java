package com.util;

import java.util.ArrayList;
import java.util.List;

public class TestBinaryTree extends BinaryTree {
    public TestBinaryTree(int value) {
        super(value);
    }

    public TestBinaryTree insert(List<Integer> values) {
        return insert(values, 0);
    }

    TestBinaryTree insert(List<Integer> values, int i) {
        if (i >= values.size()) return null;

        List<TestBinaryTree> queue = new ArrayList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            TestBinaryTree current = queue.getFirst();
            queue.removeFirst();
            if (current.left == null) {
                current.left = new TestBinaryTree(values.get(i));
                break;
            }
            queue.add((TestBinaryTree) current.left);
            if (current.right == null) {
                current.right = new TestBinaryTree(values.get(i));
                break;
            }
            queue.add((TestBinaryTree) current.right);
        }
        insert(values, i + 1);
        return this;
    }
}