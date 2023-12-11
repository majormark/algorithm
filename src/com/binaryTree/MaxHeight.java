package com.binaryTree;

public class MaxHeight {
    public int maxDepth(ListNode root) {
        if (root == null) {
            return 0;
        }
        return posOrder(root, 1);
    }

    public int posOrder(ListNode h, int level) {
        if (h == null) {
            return level - 1;
        }
        int leftH = posOrder(h.left, level + 1);
        int rightH = posOrder(h.right, level + 1);
        return Math.max(leftH, rightH);
    }
}
