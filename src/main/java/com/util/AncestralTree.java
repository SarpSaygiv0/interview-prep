package com.util;

public class AncestralTree {
    public char name;
    public AncestralTree ancestor;

    public AncestralTree(char name) {
        this.name = name;
        this.ancestor = null;
    }

    public void addAsAncestor(AncestralTree[] descendants) {
        for (AncestralTree descendant : descendants) {
            descendant.ancestor = this;
        }
    }
}