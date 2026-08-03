package com.medium.youngestcommonancestor;

import com.util.AncestralTree;

import java.util.HashSet;
import java.util.Set;

public class YoungestCommonAncestor {

    public AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor,
            AncestralTree descendantOne,
            AncestralTree descendantTwo
    ) {
        Set<AncestralTree> visited = new HashSet<>();

        while (descendantOne != null) {
            visited.add(descendantOne);
            descendantOne = descendantOne.ancestor;
        }
        while (descendantTwo != null) {
            if (visited.contains(descendantTwo)) {
                return descendantTwo;
            }
            descendantTwo = descendantTwo.ancestor;
        }
        return topAncestor;
    }

    public AncestralTree getYoungestCommonAncestorUsingDepth(
            AncestralTree topAncestor,
            AncestralTree descendantOne,
            AncestralTree descendantTwo
    ) {
        int depthOne = getDepth(descendantOne);
        int depthTwo = getDepth(descendantTwo);
        if (depthOne > depthTwo) {
            return trackAncestralTree(descendantOne, descendantTwo, depthOne - depthTwo);
        } else {
            return trackAncestralTree(descendantTwo, descendantOne, depthTwo - depthOne);
        }
    }

    private AncestralTree trackAncestralTree(AncestralTree lower, AncestralTree higher, int diff) {
        for (int i = 0; i < diff; i++) {
            lower = lower.ancestor;
        }
        while (lower != higher) {
            lower = lower.ancestor;
            higher = higher.ancestor;
        }
        return lower;
    }

    private int getDepth(AncestralTree descendant) {
        int depth = 0;
        while (descendant != null) {
            depth++;
            descendant = descendant.ancestor;
        }
        return depth;
    }


}
