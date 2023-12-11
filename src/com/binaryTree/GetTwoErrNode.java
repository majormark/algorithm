package com.binaryTree;

import java.util.Stack;

public class GetTwoErrNode {
    public ListNode[] getTwoErrNodes(ListNode head) {
        Stack<ListNode> s = new Stack<>();
        ListNode pre = null;
        ListNode[] errs = new ListNode[2];
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

    public ListNode[] getTwoErrParents(ListNode head, ListNode err1, ListNode err2) {
        ListNode[] parents = new ListNode[2];
        Stack<ListNode> s = new Stack<>();
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

    public ListNode recoverTree(ListNode head) {
        ListNode[] errs = getTwoErrNodes(head);
        ListNode[] parents = getTwoErrParents(head, errs[0], errs[1]);
        ListNode e1 = errs[0];
        ListNode e2 = errs[1];
        ListNode e1P = parents[0];
        ListNode e2P = parents[1];
        ListNode e1L = e1.left;
        ListNode e1R = e1.right;
        ListNode e2L = e2.left;
        ListNode e2R = e2.right;
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
