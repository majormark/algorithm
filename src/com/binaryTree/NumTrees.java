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


    public List<TreeNode> generateTrees(int n) {
        return generate2(1, n);
    }

    public List<TreeNode> generate2(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if (start > end) {
            res.add(null);
        };
        for (int i = start; i <= end; i++) {
            List<TreeNode> lSubs = generate2(start, i- 1);
            List<TreeNode> rSubs = generate2(i+1, end);
            for(TreeNode lSub : lSubs) {
                for (TreeNode rSub : rSubs) {
                    TreeNode h = new TreeNode(i);
                    h.left = lSub;
                    h.right = rSub;
                    res.add(h);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<TreeNode> res = new NumTrees().generateTrees(3);
        System.out.println(res);
    }
}
