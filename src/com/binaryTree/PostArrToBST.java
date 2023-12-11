package com.binaryTree;

/**
 * pg.145 根据后续数组重建搜索二叉树
 */
public class PostArrToBST {
    public boolean isPostArr(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return isPost(arr, 0, arr.length - 1);
    }

    public boolean isPost(int[] arr, int start, int end) {
        if (start == end) {
            return true;
        }
        int less = -1;
        int more = end;
        for (int i=0;i<end;i++) {
            if (arr[i] < arr[end]) {
                less = i;
            } else {
                more = more == end ? i : more;
            }
        }
        if (less == -1 || more == end) {
            return isPost(arr, start, end);
        }
        if (less != more - 1) {
            return false;
        }
        return isPost(arr, start, less) && isPost(arr, more, end - 1);

    }

    public ListNode postArrToBST(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        return post(arr, 0, arr.length - 1);
    }

    public ListNode post(int[] arr, int start, int end) {
        if (start == end) {
            return new ListNode(arr[start]);
        }
        int less = -1;
        int more = end;
        for (int i=0;i<arr.length;i++) {
            if (arr[i] < arr[end]) {
                less = i;
            } else {
                more = more == end ? i : more;
            }
        }
        ListNode n = new ListNode(arr[end]);
        n.left = post(arr, start, less);
        n.right = post(arr, more, end-1);
        return n;
    }

}
