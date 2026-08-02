package com.medium.validatebst;

import com.util.BinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidateBstTest {

    ValidateBst vBst;

    @BeforeEach
    void setVBst() {
        vBst = new ValidateBst();
    }

    @Test
    void validateBstTest() {
        BinaryTree root = new BinaryTree(10);
        root.left = new BinaryTree(5);
        root.left.left = new BinaryTree(2);
        root.left.left.left = new BinaryTree(1);
        root.left.right = new BinaryTree(5);
        root.right = new BinaryTree(15);
        root.right.left = new BinaryTree(13);
        root.right.left.right = new BinaryTree(14);
        root.right.right = new BinaryTree(22);
        assertThat(vBst.validateBst(root)).isEqualTo(true);

    }

    @Test
    void validateBstNegativeTest() {
        BinaryTree root = new BinaryTree(10);
        root.left = new BinaryTree(5);
        root.left.left = new BinaryTree(2);
        root.left.left.left = new BinaryTree(1);
        root.left.right = new BinaryTree(5);
        root.left.right.right = new BinaryTree(11);
        root.right = new BinaryTree(15);
        root.right.left = new BinaryTree(13);
        root.right.left.right = new BinaryTree(14);
        root.right.right = new BinaryTree(22);
        assertThat(vBst.validateBst(root)).isEqualTo(false);

    }

}
