package com.easy.nodedepth;

import com.util.BinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NodeDepthTest {

    NodeDepth nd;

    @BeforeEach
    void setNodeDepth() {
        nd = new NodeDepth();
    }

    @Test
    public void TestCase1() {
        var root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);
        root.left.right = new BinaryTree(5);
        root.right = new BinaryTree(3);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        int actual = nd.nodeDepths(root);
        assertEquals(16, actual);
    }

}
