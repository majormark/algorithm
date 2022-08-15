package com.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeCheck {
    /**
     * 判断是否为搜索二叉树
     *
     * @param h
     * @return
     */
    public boolean isBST(TreeNode h) {
        return inOrderCheckBST(h);
    }

    public boolean inOrderCheckBST(TreeNode h) {
        if (h == null) {
            return false;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null;
        while (!s.isEmpty() || h != null) {
            if (h != null) {
                s.push(h);
                h = h.left;
            } else {
                h = s.pop();
                if (pre != null && pre.val > h.val) {
                    return false;
                }
                pre = h;
                h = h.right;
            }
        }
        return true;
    }

    public boolean morrisInOrderCheckBST(TreeNode h) {
        if (h == null) {
            return false;
        }
        TreeNode cur = null;
        TreeNode pre = null;
        boolean res = true;
        while (h != null) {
            cur = h.left;
            if (cur != null) {
                while (cur.right != null && cur.right != h) {
                    cur = cur.right;
                }
                if (cur.right == null) {
                    cur.right = h;
                    h = h.left;
                    continue;
                } else {
                    cur.right = null;
                }
            }
            if (res && pre != null && pre.val > h.val) {
                res = false;
            }
            pre = h;
            h = h.right;
        }
        return res;
    }

    /**
     * 判断是否为完全二叉树
     */
    public boolean isCBT(TreeNode h) {
        if (h == null) {
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(h);
        TreeNode n = null;
        boolean isLeaf = false;
        while (!q.isEmpty()) {
            n = q.poll();
            if (n.right != null && n.left == null) {
                return false;
            }
            if (isLeaf) {
                if (n.left != null || n.right != null) {
                    return false;
                }
            } else {
                if (n.left != null && n.right == null) {
                    isLeaf = true;
                }
                if (n.left == null && n.right == null) {
                    return false;
                }

            }
            if (n.left != null) {
                q.offer(n.left);
            }
            if (n.right != null) {
                q.offer(n.right);
            }
        }
        return true;
    }
}
