package com.medium.validatebst;

import com.util.BinaryTree;

public class ValidateBst {
    public boolean validateBst(BinaryTree bst) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return validate(bst, min, max);
    }

    // validate(node, min, max) returns true if and only if
    // every value in subtree lies within the range [min, max) AND subtree itself is BST

    private static boolean validate(BinaryTree node, int min, int max) {
        if (node == null)
            return true;

        boolean valid = min <= node.value && node.value < max;
        return valid
                && validate(node.left, min, node.value)
                && validate(node.right, node.value, max);
    }
}
