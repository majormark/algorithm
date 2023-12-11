package com.binaryTree;

public class NodeNum {
    public int nodeNum(ListNode h) {
        if (h == null) {
            return 0;
        }
        return bs(h, 1, mostLeftLevel(h, 1));
    }

    public int bs(ListNode n, int l, int h) {
        if (n == null) {
            return 0;
        }
        if (mostLeftLevel(n.right, l + 1) == h) {
            return (1 << (h - 1)) + bs(n.right, l + 1, h);
        } else {
            return (1 << (h - l - 1)) + bs(n.left, l + 1, h);
        }
    }

    public int mostLeftLevel(ListNode h, int level) {
        while (h != null) {
            h = h.left;
            level++;
        }
        return level - 1;
    }
}
