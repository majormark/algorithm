package com.binaryTree;

import java.util.LinkedList;

public class PrintEdge {
    public LinkedList<Integer> printEdge1(TreeNode head) {
        LinkedList<Integer> res = new LinkedList<>();
        int height = getHeight(head, 0);
        TreeNode[][] nodeMap = new TreeNode[height][2];
        setEdgeMap(head, nodeMap, 0);
        for (int i=0;i< nodeMap.length;i++) {
            res.add(nodeMap[i][0].val);
        }
        printLeafNotInMap(head, 0, nodeMap, res);
        for (int i=nodeMap.length-1;i>=0;i--) {
            res.add(nodeMap[i][1].val);
        }
        return res;
    }

    public void printLeafNotInMap(TreeNode n, int l, TreeNode[][] nodeMap, LinkedList<Integer> res) {
        if (n == null) {
            return;
        }
        if (n.left == null && n.right == null && nodeMap[l][0] != n && nodeMap[l][1] != n) {
            res.add(n.val);
        }
        printLeafNotInMap(n.left, l + 1, nodeMap, res);
        printLeafNotInMap(n.right, l + 1, nodeMap, res);
    }
    public int getHeight(TreeNode node, int l) {
        if (node == null) {
            return l;
        }
        return Math.max(getHeight(node.left, l + 1), getHeight(node.right, l + 1));
    }

    public void setEdgeMap(TreeNode node, TreeNode[][] nodeMap, int l) {
        if (node == null) {
            return;
        }
        nodeMap[l][0] = nodeMap[l][0] == null ? node : nodeMap[l][0];
        nodeMap[l][1] = node;
        setEdgeMap(node.left, nodeMap, l + 1);
        setEdgeMap(node.right, nodeMap, l + 1);
    }

    public LinkedList<Integer> printEdge2(TreeNode head) {
        LinkedList<Integer> res = new LinkedList<>();
        if (head == null) {
            return res;
        }
        res.add(head.val);
        if (head.left != null && head.right != null) {
            printLeftEdge(head.left, true, res);
            printRightEdge(head.right, true, res);
        } else {
            printEdge2(head.left == null ? head.right : head.left);
        }
        return res;
    }

    void printLeftEdge(TreeNode node, boolean print, LinkedList<Integer> res) {
        if (node == null) {
            return;
        }
        if (print || node.left == null && node.right == null) {
            res.add(node.val);
        }
        printLeftEdge(node.left, print, res);
        printLeftEdge(node.right, print && node.left == null, res);
    }

    void printRightEdge(TreeNode node, boolean print, LinkedList<Integer> res) {
        if (node == null) {
            return;
        }
        printRightEdge(node.left, print && node.right == null, res);
        printRightEdge(node.right, print, res);
        if (print || node.left == null && node.right == null) {
            res.add(node.val);
        }
    }


}
