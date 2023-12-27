package com.binaryTree.buildTree;

import com.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBSTFromInorderAndPreOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return process(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    public TreeNode process(int[] pre, int pi, int pj, int[] mid, int mi, int mj, Map<Integer, Integer> map) {
        if (pi > pj) {
            return null;
        }
        int idx = map.get(pre[pi]);
        int leftLen = idx - mi;
        TreeNode node = new TreeNode(pre[pi]);

        node.left = process(pre, pi + 1, pi + leftLen, mid, mi, idx - 1, map);
        node.right = process(pre, pi + leftLen + 1, pj, mid, idx + 1, mj, map);
        return node;
    }
}
