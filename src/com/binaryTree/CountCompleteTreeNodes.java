package com.binaryTree;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = mostLeftLevel(root, 1);
        return  process(root, height, 1);
    }
    public int process(TreeNode node, int height, int level) {
        if (height == level) {
            return 1;
        }
        if (mostLeftLevel(node.right, level + 1) == height) {
            return (1 << height - level) + process(node.right, height, level + 1);
        } else {
            return (1 << height - level - 1) + process(node.left, height, level + 1);
        }
    }

    public int mostLeftLevel(TreeNode node, int level) {
        while (node.left != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }
}
