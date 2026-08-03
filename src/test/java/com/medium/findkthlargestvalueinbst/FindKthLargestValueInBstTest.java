package com.medium.findkthlargestvalueinbst;

import com.util.BinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FindKthLargestValueInBstTest {

    FindKthLargestValueInBst fKthLargest;

    @BeforeEach
    void setFklvibst() {
        fKthLargest = new FindKthLargestValueInBst();
    }

    @Test
    void findKthLargestValueInBstTest() {
        BinaryTree root = getSampleBinaryTree();
        int k = 3;
        int expected = 17;
        int actual = fKthLargest.findKthLargestValueInBst(root, k);
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void findKthLargestValueInBstWithTreeInfoTest() {
        BinaryTree root = getSampleBinaryTree();
        int k = 3;
        int expected = 17;
        int actual = fKthLargest.findKthLargestValueWithTreeInfo(root, k);
        assertThat(expected).isEqualTo(actual);
    }

    private static BinaryTree getSampleBinaryTree() {
        BinaryTree root = new BinaryTree(15);
        root.left = new BinaryTree(5);
        root.left.left = new BinaryTree(2);
        root.left.left.left = new BinaryTree(1);
        root.left.left.right = new BinaryTree(3);
        root.left.right = new BinaryTree(5);
        root.right = new BinaryTree(20);
        root.right.left = new BinaryTree(17);
        root.right.right = new BinaryTree(22);
        return root;
    }

}
