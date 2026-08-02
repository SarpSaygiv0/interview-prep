package com.medium.bsttraversal;

import com.util.BinaryTree;

import java.util.List;

public class BstTraversal {

    public List<Integer> inOrderTraverse(BinaryTree tree, List<Integer> list) {
        inOrder(tree, list);
        return list;
    }

    public List<Integer> preOrderTraverse(BinaryTree tree, List<Integer> list) {
        preOrder(tree, list);
        return list;
    }

    public List<Integer> postOrderTraverse(BinaryTree tree, List<Integer> list) {
        postOrder(tree, list);
        return list;
    }

    private static void inOrder(BinaryTree tree, List<Integer> list) {
        if (tree == null) return;
        inOrder(tree.left, list);
        list.add(tree.value);
        inOrder(tree.right, list);
    }

    private static void preOrder(BinaryTree tree, List<Integer> list) {
        if (tree == null) return;
        list.add(tree.value);
        preOrder(tree.left, list);
        preOrder(tree.right, list);
    }

    private static void postOrder(BinaryTree tree, List<Integer> list) {
        if (tree == null) return;
        postOrder(tree.left, list);
        postOrder(tree.right, list);
        list.add(tree.value);
    }
}
