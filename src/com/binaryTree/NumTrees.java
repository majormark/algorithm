package com.binaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * 统计和生成所有不同的二叉树 pg.176
 */
public class NumTrees {
    public int numTrees(int n) {
        if (n < 2) {
            return 1;
        }
        int[] num = new int[n + 1];
        num[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i + 1; j++) {
                num[i] = num[j - 1] * num[i - j];
            }
        }
        return num[n];
    }

    public List<ListNode> generateTree(int n) {
        return generate(0, n);
    }

    public List<ListNode> generate(int start, int end) {
        List<ListNode> res = new LinkedList<>();
        if (start > end) {
            return null;
        }
        for (int i = start; i < end + 1; i++) {
            ListNode h = new ListNode(i);
            List<ListNode> lSubs = generate(start, i - 1);
            List<ListNode> rSubs = generate(i+1,end);
            for (ListNode l : lSubs) {
                for (ListNode r : rSubs) {
                    h.left = l;
                    h.right = r;
                    res.add(cloneTree(h));
                }
            }
        }
        return res;
    }

    public ListNode cloneTree(ListNode h) {
        if (h == null) {
            return null;
        }
        ListNode newH = new ListNode(h.val);
        newH.left = cloneTree(h.left);
        newH.right = cloneTree(h.right);
        return newH;
    }

}
