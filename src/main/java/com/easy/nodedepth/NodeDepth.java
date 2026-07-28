package com.easy.nodedepth;

import com.util.BinaryTree;

public class NodeDepth {

    public int nodeDepths(BinaryTree root) {
        return nodeDepthsHelper(root, 0);
    }

    public int nodeDepthsHelper(BinaryTree node, int depth) {
        if (node == null)
            return 0;

        return depth + nodeDepthsHelper(node.left, depth + 1) + nodeDepthsHelper(node.right, depth + 1);
    }
}
