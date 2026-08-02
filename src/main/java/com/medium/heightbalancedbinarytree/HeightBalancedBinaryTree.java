package com.medium.heightbalancedbinarytree;

import com.util.BinaryTree;

public class HeightBalancedBinaryTree {


    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        TreeInfo result = isHeightBalancedBT(tree);
        return result.diff <= 1;
    }

    private TreeInfo isHeightBalancedBT(BinaryTree node) {
        if (node == null) return new TreeInfo(0, 0);
        TreeInfo left = isHeightBalancedBT(node.left);
        TreeInfo right = isHeightBalancedBT(node.right);

        int maxDiffSoFar = Math.max(left.diff, right.diff);
        int diffThroughThisNode = Math.abs(left.height - right.height);
        int currentHeight = Math.max(left.height, right.height) + 1;
        int currentDiff = Math.max(maxDiffSoFar, diffThroughThisNode);

        return new TreeInfo(currentDiff, currentHeight);
    }

    static class TreeInfo {
        private int diff;
        private int height;

        TreeInfo(int diff, int height) {
            this.height = height;
            this.diff = diff;
        }
    }
}
