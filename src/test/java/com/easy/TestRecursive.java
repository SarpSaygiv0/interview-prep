package com.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestRecursive {

    public static class ListNode {
        int val; ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode buildList(int... vals) {
        ListNode dummy = new ListNode(0), curr = dummy;
        for (int v : vals) { curr.next = new ListNode(v); curr = curr.next; }
        return dummy.next;
    }

    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static int length(ListNode node) {
        if (node == null)
            return 0;

        return 1 + length(node.next);
    }
    TreeNode root;
    @BeforeEach
    void setTreeNode() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
    }

    @Test
    void testListNode() {
        assertThat(length(buildList(1, 2, 3, 4))).isEqualTo(4);
        assertThat(length(buildList(9))).isEqualTo(1);
        assertThat(length(null)).isEqualTo(0);
    }

    @Test
    void coundNodesAndMaxDepth() {
        assertThat(countNodes(root)).isEqualTo(7);
        assertThat(countNodes(null)).isEqualTo(0);
        assertThat(maxDepth(root)).isEqualTo(4);   // 1 -> 2 -> 4 -> 7
        assertThat(maxDepth(null)).isEqualTo(0);
        assertThat(maxDepth(new TreeNode(42))).isEqualTo(1);
    }


    static int countNodes(TreeNode node) {
        if (node == null)
            return 0;

        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    static int maxDepth(TreeNode node) {
        if (node == null)
            return 0;

        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));

    }

}
