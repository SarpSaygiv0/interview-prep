package com.medium.invertbinarytree;

import com.util.BinaryTree;
import com.util.TestBinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InvertBinaryTreeTest {

    InvertBinaryTree ibt;

    @BeforeEach
    void setIbt() {
        ibt = new InvertBinaryTree();
    }

    @Test
    void invertBinaryTree() {
        TestBinaryTree tree = new TestBinaryTree(1);
        tree.insert(List.of(2, 3, 4, 5, 6, 7, 8, 9));
        ibt.invertBinaryTree(tree);
        assertThat(levelOrder(tree)).containsExactly(1, 3, 2, 7, 6, 5, 4, 9, 8);
    }

    private List<Integer> levelOrder(BinaryTree root) {
        List<Integer> values = new ArrayList<>();
        Deque<BinaryTree> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTree node = queue.poll();
            values.add(node.value);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);

        }
        return values;
    }

}
