package com.binaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * 统计和生成所有不同的二叉树 pg.176
 */
public class NumTrees {
    public int numTrees(int n) {
        if (n < 2) {
            return 1;
        }
        int[] num = new int[n + 1];
        num[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i + 1; j++) {
                num[i] = num[j - 1] * num[i - j];
            }
        }
        return num[n];
    }

    public List<TreeNode> generateTree(int n) {
        return generate(0, n);
    }

    public List<TreeNode> generate(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if (start > end) {
            return null;
        }
        for (int i = start; i < end + 1; i++) {
            TreeNode h = new TreeNode(i);
            List<TreeNode> lSubs = generate(start, i - 1);
            List<TreeNode> rSubs = generate(i+1,end);
            for (TreeNode l : lSubs) {
                for (TreeNode r : rSubs) {
                    h.left = l;
                    h.right = r;
                    res.add(cloneTree(h));
                }
            }
        }
        return res;
    }

    public TreeNode cloneTree(TreeNode h) {
        if (h == null) {
            return null;
        }
        TreeNode newH = new TreeNode(h.val);
        newH.left = cloneTree(h.left);
        newH.right = cloneTree(h.right);
        return newH;
    }

}
