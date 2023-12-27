package com.binaryTree.binarySearchTree;

import com.binaryTree.TreeNode;

import java.util.ArrayList;

//501. Find Mode in Binary Search Tree
public class FindModeInBinarySearchTree {
    TreeNode pre = null;
    ArrayList<Integer> res = null;
    int count = 0;
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        res = new ArrayList<>();
        process(root);
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    public void process(TreeNode node) {
        if (node == null) return;
        process(node.left);
        if (pre != null && pre.val == node.val) {
            count++;
        } else {
            count = 1;
        }
        if (count > maxCount) {
            res.clear();
            maxCount = count;
        }
        if (count >= maxCount) {
            res.add(node.val);
        }
        pre = node;
        process(node.right);
    }
}
