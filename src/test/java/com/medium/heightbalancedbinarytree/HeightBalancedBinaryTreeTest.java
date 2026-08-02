package com.medium.heightbalancedbinarytree;

import com.util.BinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeightBalancedBinaryTreeTest {

    HeightBalancedBinaryTree hbbt;

    @BeforeEach
    void setHbbt() {
        hbbt = new HeightBalancedBinaryTree();
    }

    @Test
    void heightBalancedBinaryTreeTest() {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.right = new BinaryTree(6);
        root.left.right.left = new BinaryTree(7);
        root.left.right.right = new BinaryTree(8);
        assertThat(hbbt.heightBalancedBinaryTree(root)).isEqualTo(true);
    }

    @Test
    void heightBalancedBinaryTreeNegativeTest() {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.left.left = new BinaryTree(6);
        root.right = new BinaryTree(3);
        root.right.right = new BinaryTree(5);
        root.right.right.right = new BinaryTree(7);

        assertThat(hbbt.heightBalancedBinaryTree(root)).isEqualTo(false);
    }
}
