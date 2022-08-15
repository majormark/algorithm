package com.binaryTree;

/**
 * pg.144 判断二叉树是否为平衡二叉树
 */
public class IsBalanceBT {
    public boolean isBalance(TreeNode head) {
        boolean[] res = new boolean[]{true};
        getHeight(head, 1, res);
        return res[0];
    }
    public int getHeight(TreeNode head, int level, boolean[] res) {
        if (head == null) {
            return level;
        }
        int lH = getHeight(head.left, level + 1, res);
        if (!res[0]) {
            return level;
        }
        int rH = getHeight(head.right, level + 1, res);
        if (!res[0]) {
            return level;
        }
        if (Math.abs(lH - rH) > 1) {
            res[0] = false;
            return level;
        }
        return Math.max(lH, rH);
    }
}
