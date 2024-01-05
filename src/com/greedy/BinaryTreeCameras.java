package com.greedy;

import com.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//968. Binary Tree Cameras
public class BinaryTreeCameras {
    int result = 0;
    public int minCameraCover(TreeNode root) {
        if (postOrder(root) == 0) {
            return result + 1;
        }
        return result;
    }

    public int postOrder(TreeNode node) {
        if (node == null) return 2;
        int left = postOrder(node.left);
        int right = postOrder(node.right);
        if (left == 2 && right == 2) {
            return 0;
        }
        if (left == 0 || right == 0) {
            result++;
            return 1;
        }
        if (left == 1 || right == 1) return 2;
        return 0;
    }
}
