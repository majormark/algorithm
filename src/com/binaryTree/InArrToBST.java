package com.binaryTree;

/**
 * 通过有序数组生成平衡搜索二叉树
 */
public class InArrToBST {

    public ListNode generateTree(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        return generate(arr, 0, arr.length-1);
    }

    public ListNode generate(int[] arr, int start, int end) {
        if (start == end) {
            return new ListNode(arr[start]);
        }
        int mid = (start + end) / 2;
        ListNode n = new ListNode(mid);
        n.left = generate(arr, start, mid);
        n.right = generate(arr, mid + 1, end);
        return n;
    }
}
