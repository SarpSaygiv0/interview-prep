package com.medium.findkthlargestvalueinbst;

import com.util.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class FindKthLargestValueInBst {

    public int findKthLargestValueInBst(BinaryTree tree, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        getKthLargetsValue(tree, arr);
        return arr.get(k - 1);
    }

    public void getKthLargetsValue(BinaryTree node, List<Integer> arr) {
        if (node == null) return;
        getKthLargetsValue(node.right, arr);
        arr.add(node.value);
        getKthLargetsValue(node.left, arr);
    }

    public int findKthLargestValueWithTreeInfo(BinaryTree tree, int k) {
        TreeInfo treeInfo = new TreeInfo(0, -1);
        reverseInOrderTraverse(tree, k, treeInfo);
        return treeInfo.latestVisitedNodeValue;
    }

    private void reverseInOrderTraverse(BinaryTree node, int k, TreeInfo treeInfo) {
        if (node == null || treeInfo.numberOfNodesVisited >= k) return;

        reverseInOrderTraverse(node.right, k, treeInfo);
        if (treeInfo.numberOfNodesVisited < k) {
            treeInfo.numberOfNodesVisited++;
            treeInfo.latestVisitedNodeValue = node.value;
            reverseInOrderTraverse(node.left, k, treeInfo);
        }
    }


    static class TreeInfo {
        int numberOfNodesVisited;
        int latestVisitedNodeValue;

        TreeInfo(int numOfNodes, int latestValue) {
            this.numberOfNodesVisited = numOfNodes;
            this.latestVisitedNodeValue = latestValue;
        }

    }
}
