package com.binaryTree;

//513. Find Bottom Left Tree Value
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int h = getHeight(root);
        TreeNode node = findMostLeft(root, h, 1);
        return node.val;
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public TreeNode findMostLeft(TreeNode node, int h, int level) {
        if (node.left == null && node.right == null) {
            return h == level ? node : null;
        }
        if (node.left != null) {
            TreeNode left = findMostLeft(node.left, h, level + 1);
            if (left != null) {
                return left;
            }
        }
        if (node.right != null) {
            return findMostLeft(node.right, h, level + 1);
        }
        return null;
    }
}
