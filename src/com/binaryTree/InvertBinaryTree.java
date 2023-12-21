package com.binaryTree;

// 226. Invert Binary Tree
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        process(root);
        return root;
    }

    public void process(TreeNode node) {
        if (node == null) return;
        process(node.left);
        process(node.right);
        TreeNode left = node.left;
        node.left = node.right;
        node.right = left;
    }
}
