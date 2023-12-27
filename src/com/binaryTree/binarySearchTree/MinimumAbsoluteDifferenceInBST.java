package com.binaryTree.binarySearchTree;

import com.binaryTree.TreeNode;

import java.util.Stack;

// 530. Minimum Absolute Difference in BST
public class MinimumAbsoluteDifferenceInBST {
    public int getMinimumDifference(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        int min = Integer.MAX_VALUE;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                TreeNode tmp = stack.pop();
                if (pre != null) {
                    int diff = Math.abs(pre.val - tmp.val);
                    min = Math.min(diff, min);
                }
                pre = tmp;
                node = tmp.right;
            }
        }
        return min;
    }
}
