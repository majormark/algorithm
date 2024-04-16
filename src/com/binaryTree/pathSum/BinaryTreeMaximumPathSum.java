package com.binaryTree.pathSum;

import com.binaryTree.TreeNode;

public class BinaryTreeMaximumPathSum {
    public int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        process(root);
        return maxSum;
    }
    public int process(TreeNode node) {
        if (node == null) return 0;
        int leftVal = process(node.left);
        int rightVal = process(node.right);
        int innerMax = node.val + leftVal + rightVal;
        maxSum = Math.max(maxSum, innerMax);
        int outputMax = node.val + Math.max(leftVal, rightVal);
        return Math.max(outputMax, 0);
    }
}
