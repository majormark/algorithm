package com.dp.rob;

import com.binaryTree.TreeNode;

public class HouseRobberTree {
    public int rob(TreeNode root) {
        int[] res = process(root);
        return Math.max(res[0], res[1]);
    }

    public int[] process(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] leftdp = process(root.left);
        int[] rightdp = process(root.right);
        int[] dp = new int[2];
        // 0 不偷当前， 1偷当前
        dp[1] = root.val + leftdp[0] + rightdp[0];
        dp[0] = Math.max(leftdp[0], leftdp[1]) + Math.max(rightdp[0], rightdp[1]);
        return dp;
    }
}
