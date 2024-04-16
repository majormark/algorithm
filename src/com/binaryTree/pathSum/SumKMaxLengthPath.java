package com.binaryTree.pathSum;

import com.binaryTree.TreeNode;

import java.util.HashMap;

/**
 * book pg.115
 * 在二叉树中找到累加和未指定值的最长路径长度
 */
public class SumKMaxLengthPath {
    public int maxLength(TreeNode head, int k) {
        int len = 0;
        HashMap<Integer, Integer> m = new HashMap<>();
        m.put(0, 0);
        return preOrder(head, 1, head.val, k, 0, m);
    }

    public int preOrder(TreeNode node, int level, int preSum, int k, int max, HashMap<Integer, Integer> m) {
        if (node == null) {
            return max;
        }
        int curSum = preSum + node.val;
        if (m.containsKey(curSum - k)) {
            int preLevel =m.get(curSum - k);
            max = Math.max( level - preLevel, max);
        }
        if (!m.containsKey(curSum)) {
            m.put(curSum, level);
        }
        max = preOrder(node.left, level + 1, curSum, k, max, m);
        max = preOrder(node.right, level + 1, curSum, k, max, m);
        if (m.containsKey(curSum) && m.get(curSum) == level) {
            m.remove(curSum);
        }
        return max;
    }
}
