package com.binaryTree;

import java.util.HashMap;

/**
 * book pg.119
 * 找到二叉树中符合搜索二叉树条件的最大拓扑结构
 */
public class BSTTopoSize {

    // 遍历每个节点，以每个节点为头，统计最大搜索二叉树的数量
    public int bstTopoSize1(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int max = maxTopo(head, head);
        max = Math.max(bstTopoSize1(head.left), max);
        max = Math.max(bstTopoSize1(head.right), max);
        return max;
    }

    // 遍历h树，检查每个节点是否符合搜索二叉树，并统计数量
    public int maxTopo(TreeNode h, TreeNode n) {
        if (h != null && n != null && isBSTNode(h, n, n.val)) {
            return maxTopo(h, n.left) + maxTopo(h, n.right) + 1;
        }
        return 0;
    }

    // 检查节点n在h这棵树，是否符合搜索二叉树
    public boolean isBSTNode(TreeNode h, TreeNode n, int value) {
        if (h == null) {
            return false;
        }
        if (n == h) {
            return true;
        }
        return isBSTNode(h.val > value ? h.left : h.right, n, value);
    }

    public int bstTopoSize2(TreeNode head) {
        if (head == null) {
            return 0;
        }
        HashMap<TreeNode, Record> m = new HashMap<>();
        return postOrder(head, m);
    }

    public int postOrder(TreeNode h, HashMap<TreeNode, Record> m) {
        if (h == null) {
            return 0;
        }
        int ls = postOrder(h.left, m);
        int rs = postOrder(h.right, m);
        modifyMap(h.left, h.val, m, true);
        modifyMap(h.right, h.val, m, false);
        Record lr = m.get(h.left);
        Record rr = m.get(h.right);
        int lNum = lr == null ? 0 : lr.l + lr.r + 1;
        int rNum = rr == null ? 0 : rr.l + rr.r + 1;
        m.put(h, new Record(lNum, rNum));
        return Math.max(lNum + rNum + 1, Math.max(ls, rs));
    }
    public int modifyMap(TreeNode n, int v, HashMap<TreeNode, Record> m, boolean isLeft) {
        if (n == null || !m.containsKey(n)) {
            return 0;
        }
        Record r = m.get(n);
        if ((isLeft && n.val > v) || (!isLeft && n.val < v)) {
            m.remove(n);
            return r.l + r.r + 1;
        } else {
            int minus = modifyMap(isLeft ? n.right : n.left, v, m, isLeft);
            if (isLeft) {
                r.r -= minus;
            } else {
                r.l -=minus;
            }
            m.put(n, r);
            return minus;
        }
    }
}


class Record {
    int l;
    int r;

    public Record(int left, int right) {
        l = left;
        r = right;
    }
}