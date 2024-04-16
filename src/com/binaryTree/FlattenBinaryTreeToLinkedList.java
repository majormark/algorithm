package com.binaryTree;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode right = root.right;
                root.right = root.left;
                TreeNode pre = root.left;
                root.left = null;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = right;
            }
            root = root.right;
        }
    }
}
