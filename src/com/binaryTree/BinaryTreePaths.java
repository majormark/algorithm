package com.binaryTree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        preOrder(root, res, "");
        return res;
    }

    public void preOrder(TreeNode node, List<String> res, String pre) {
        if (node == null) return;
        String cur = pre.isEmpty() ? String.valueOf(node.val) : pre + "->" + node.val;
        if (node.left == null && node.right == null) {
            res.add(cur);
            return;
        }
        preOrder(node.left, res, cur);
        preOrder(node.right, res, cur);
    }
}
