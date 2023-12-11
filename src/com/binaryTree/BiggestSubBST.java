package com.binaryTree;

public class BiggestSubBST {
    public ListNode biggestSubBST(ListNode head) {

        if (head == null) {
            return null;
        }
        return postOrder(head, new int[3]);
    }

    public ListNode postOrder(ListNode head, int[] record) {
        if (head == null) {
            record[0] = 0;
            record[1] = Integer.MAX_VALUE;
            record[2] = Integer.MIN_VALUE;
        }
        ListNode left = head.left;
        ListNode right = head.right;
        ListNode lBST = postOrder(left, record);
        int lSize = record[0];
        int lMin = record[1];
        int lMax = record[2];
        ListNode rBST = postOrder(right, record);
        int rSize = record[0];
        int rMin = record[1];
        int rMax = record[2];
        record[1] = Math.min(lMin, head.val);
        record[2] = Math.max(rMax, head.val);
        if (left == lBST && right == rBST && lMax < head.val && rMin > head.val) {
            record[0] = lSize + rSize + 1;
            return head;
        }
        record[0] = Math.max(lSize ,rSize);
        return lSize > rSize ? lBST : rBST;
    }
}
