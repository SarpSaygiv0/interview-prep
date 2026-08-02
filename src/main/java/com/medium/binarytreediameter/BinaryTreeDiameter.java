package com.medium.binarytreediameter;

import com.util.BinaryTree;

public class BinaryTreeDiameter {
    int maxDiameter = 0;

    public int binaryTreeDiameter(BinaryTree tree) {
        diameter(tree);
        return maxDiameter;
    }

    public int binaryTreeDiameterTreeInfo(BinaryTree tree) {
        TreeInfo result = diameterTreeInfo(tree);
        return result.diameter;
    }

    private int diameter(BinaryTree node) {
        if (node == null) return 0;
        int left = diameter(node.left);
        int right = diameter(node.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return 1 + Math.max(left, right);
    }

    private TreeInfo diameterTreeInfo(BinaryTree node) {
        if (node == null) return new TreeInfo(0, 0);

        TreeInfo left = diameterTreeInfo(node.left);
        TreeInfo right = diameterTreeInfo(node.right);

        int longestPath = left.height + right.height;
        int maxDiameter = Math.max(left.diameter, right.diameter);
        int currentDiameter = Math.max(longestPath, maxDiameter);
        int currentHeight = Math.max(left.height, right.height) + 1;

        return new TreeInfo(currentDiameter, currentHeight);
    }

    static class TreeInfo {
        int diameter;
        int height;

        TreeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }
}
