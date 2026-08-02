package com.medium.bsttraversal;

import com.util.BinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BstTraversalTest {

    BstTraversal bt;

    @BeforeEach
    void setBt() {
        bt = new BstTraversal();
    }

    @Test
    void bstTraversalTest() {
        BinaryTree root = new BinaryTree(10);
        root.left = new BinaryTree(5);
        root.left.left = new BinaryTree(2);
        root.left.left.left = new BinaryTree(1);
        root.left.right = new BinaryTree(5);
        root.right = new BinaryTree(15);
        root.right.right = new BinaryTree(22);

        List<Integer> inOrder = new ArrayList<>(List.of
                (1, 2, 5, 5, 10, 15, 22)
        );
        List<Integer> preOrder = new ArrayList<>(List.of
                (10, 5, 2, 1, 5, 15, 22)
        );
        List<Integer> postOrder = new ArrayList<>(List.of
                (1, 2, 5, 5, 22, 15, 10)
        );

        assertThat(bt.inOrderTraverse(root, new ArrayList<>()))
                .isEqualTo(inOrder);
        assertThat(bt.preOrderTraverse(root, new ArrayList<>()))
                .isEqualTo(preOrder);
        assertThat(bt.postOrderTraverse(root, new ArrayList<>()))
                .isEqualTo(postOrder);
    }
}
