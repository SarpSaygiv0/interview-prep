package com.medium.invertbinarytree;

import com.util.BinaryTree;

public class InvertBinaryTree {

    public void invertBinaryTree(BinaryTree tree) {
        invert(tree);
    }

    private static void invert(BinaryTree node) {
        if (node == null) return;

        invert(node.left);
        invert(node.right);
        BinaryTree temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

}