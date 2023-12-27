package com.binaryTree;

import java.util.Arrays;
import java.util.Stack;

//654. Maximum Binary Tree
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return process(nums, 0, nums.length - 1);
    }

    public TreeNode process(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int max = nums[start];
        int maxi = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxi = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = process(nums, start, maxi - 1);
        node.right = process(nums, maxi + 1, end);
        return node;
    }

    // 单调栈
    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        TreeNode[] tree = new TreeNode[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        for (int i = 0; i < n; i++) {
            tree[i] = new TreeNode(nums[i]);
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                right[stack.pop()] = i;
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        TreeNode root = null;
        for (int i = 0; i < n; i++) {
            if (left[i] == -1 && right[i] == -1) {
                root = tree[i];
            } else if (right[i] == -1 || (left[i] != -1 && nums[left[i]] < nums[right[i]])) {
                tree[left[i]].right = tree[i];
            } else {
                tree[right[i]].left = tree[i];
            }
        }
        return root;
    }
}
