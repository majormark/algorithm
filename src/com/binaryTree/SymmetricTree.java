package com.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * 101
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }
    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    public boolean check2(TreeNode p, TreeNode q) {
        Stack<TreeNode> sp = new Stack<>();
        Stack<TreeNode> sq = new Stack<>();

        while ((!sp.isEmpty() || p != null) && (!sq.isEmpty() || q != null)) {
            while (p != null && q != null) {
                if (p.val != q.val) {
                    return false;
                }
                sp.push(p);
                p = p.left;
                sq.push(q);
                q = q.right;
            }
            if ((p == null && q!= null || p != null && q == null)) {
                return false;
            }
            if (sp.isEmpty() && !sq.isEmpty() || !sp.isEmpty() && sq.isEmpty()) {
                return false;
            }
            if (!sp.isEmpty() && !sq.isEmpty()) {
                p = sp.pop();
                q = sq.pop();
                p = p.right;
                q = q.left;
            }
        }
        return true;
    }

    public boolean check3(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}
