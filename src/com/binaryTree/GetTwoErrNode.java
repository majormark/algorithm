package com.binaryTree;

import java.util.Stack;

public class GetTwoErrNode {
    public TreeNode[] getTwoErrNodes(TreeNode head) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null;
        TreeNode[] errs = new TreeNode[2];
        while (!s.isEmpty() || head != null) {
            while (head != null) {
                s.push(head.left);
                head = head.left;
            }

            if (!s.isEmpty()) {
                head = s.pop();
                if (head != null && pre != null && pre.val > head.val) {
                    errs[0] = errs[0] == null ? pre : errs[0];
                    errs[1] = head;
                }
                pre = head;
                head = head.right;
            }
        }
        return errs;
    }

    public TreeNode[] getTwoErrParents(TreeNode head, TreeNode err1, TreeNode err2) {
        TreeNode[] parents = new TreeNode[2];
        Stack<TreeNode> s = new Stack<>();
        while (!s.isEmpty() || head != null) {
            if (head != null) {
                s.push(head);
                head = head.left;
            } else {
                head=s.pop();
                if (head.left == err1 || head.right == err1) {
                    parents[0] = head;
                }
                if (head.left == err2 || head.right == err2) {
                    parents[1] = head;
                }
                head = head.right;
            }
        }
        return parents;
    }

    public TreeNode recoverTree(TreeNode head) {
        TreeNode[] errs = getTwoErrNodes(head);
        TreeNode[] parents = getTwoErrParents(head, errs[0], errs[1]);
        TreeNode e1 = errs[0];
        TreeNode e2 = errs[1];
        TreeNode e1P = parents[0];
        TreeNode e2P = parents[1];
        TreeNode e1L = e1.left;
        TreeNode e1R = e1.right;
        TreeNode e2L = e2.left;
        TreeNode e2R = e2.right;
        if (e1  == head) {
            if (e1.right == e2) {

            } else if (e2P.left == e2) {

            } else if (e2P.right == e2) {

            }
            head = e2;
        } else if (e2 == head) {
            if (e2.left == e1) {

            } else if (e1P.left == e1) {

            } else if (e1P.right == e1) {

            }
            head = e1;
        } else {
            if (e1 == e2P) {
                if (e1 == e1P.left) {

                } else { //e1 == e1P.right

                }
            } else if (e2 == e1P) {
                if (e2 == e2P.left) {

                } else { // e2 == e2P.right

                }
            } else {
                if (e1 == e1P.left) {
                    if (e2 == e2P.left) {

                    } else { // e2 == e2P.right

                    }
                } else { // e1 == e1P.right
                    if (e2 == e2P.left) {

                    } else { // e2 == e2P.right

                    }
                }
            }
        }
        return head;
    }
}
