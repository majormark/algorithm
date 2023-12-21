package com.binaryTree.level;

import com.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        TreeNode last = root;
        TreeNode nLast = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode node;
        while (!q.isEmpty()) {
            node = q.poll();
            if (node.left != null) {
                q.offer(node.left);
                nLast = node.left;
            }
            if (node.right != null) {
                q.offer(node.right);
                nLast = node.right;
            }
            if (last == node) {
                res.add(last.val);
                last = nLast;
            }
        }
        return res;
    }
}
