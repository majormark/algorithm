package com.binaryTree;

import java.io.*;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return process(root, false);
    }

    public int process(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return isLeft ? root.val : 0;
        }
        int leftSum = process(root.left, true);
        int rightSum = process(root.right, false);
        return leftSum + rightSum;
    }

    public static String line;

}
