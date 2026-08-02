package com.medium.binarytreediameter;

import com.util.BinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryTreeDiameterTest {

    BinaryTreeDiameter btd;

    @BeforeEach
    void setBtd() {
        btd = new BinaryTreeDiameter();
    }

    @Test
    void binarTreeDiameterTest() {
        BinaryTree root = createBinaryTree();
        assertThat(btd.binaryTreeDiameter(root)).isEqualTo(6);
    }

    @Test
    void binarTreeDiameterTreeInfoTest() {
        BinaryTree root = createBinaryTree();
        assertThat(btd.binaryTreeDiameterTreeInfo(root)).isEqualTo(6);
    }

    private static BinaryTree createBinaryTree() {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(3);
        root.right = new BinaryTree(2);
        root.left.left = new BinaryTree(7);
        root.left.left.left = new BinaryTree(8);
        root.left.left.left.left = new BinaryTree(9);
        root.left.right = new BinaryTree(4);
        root.left.right.right = new BinaryTree(5);
        root.left.right.right.right = new BinaryTree(6);
        return root;
    }
}
