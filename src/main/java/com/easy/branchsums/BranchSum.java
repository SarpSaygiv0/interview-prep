package com.easy.branchsums;

import com.util.BinaryTree;

import java.util.ArrayList;

public class BranchSum {

    public ArrayList<Integer> branchSums(BinaryTree root) {
        ArrayList<Integer> branchSums = new ArrayList<>();
        calculateBranchSum(root, 0, branchSums);
        return branchSums;
    }

    public void calculateBranchSum(BinaryTree node, int currentSum, ArrayList<Integer> branchSums) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            branchSums.add(currentSum + node.value);
        }

        calculateBranchSum(node.left, currentSum + node.value, branchSums);
        calculateBranchSum(node.right, currentSum + node.value, branchSums);

    }

}
