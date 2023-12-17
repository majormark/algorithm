package com.binaryTree;

/**
 * 二叉树节点间最大距离pg.170
 */
public class MaxDistance {
    public int maxDistance(TreeNode h) {
        if (h == null) {
            return 0;
        }
        return postOrder(h, new int[1]);
    }

    public int postOrder(TreeNode h, int[] record) {
        if (h == null) {
            record[0] = 0;
            return 0;
        }
        int lMax = postOrder(h.left, record);
        int maxFromLeft = record[0];
        int rMax = postOrder(h.right, record);
        int maxFromRight = record[0];
        int curNodeMax = maxFromLeft + maxFromRight + 1;
        record[0] = Math.max(maxFromLeft, maxFromRight) + 1;
        return Math.max(Math.max(lMax, rMax), curNodeMax);
    }
}
