package com.string;

import com.binaryTree.TreeNode;

import java.util.Stack;

/**
 * Created by major on 16/8/22.
 */



public class IdenticalTree {
    public boolean chkIdentical(TreeNode A, TreeNode B) {
        // write code here
        if(A == null || B == null) {
            return  false;
        }

        String strA = serialize(A);
        String strB = serialize(B);

        return false;
    }

    public String serialize(TreeNode root) {
        if(root == null) {
            return null;
        }
        StringBuilder str = new StringBuilder("");
        Stack<TreeNode> stack = new Stack();
        TreeNode node = root;
        while(node != null || stack.size() > 0) {
            while(node != null) {
                str.append(node.val).append("!");
                stack.push(node);
                node = node.left;
            }
            str.append("#!");
            if(stack.size() > 0) {
                node = stack.pop();
                node = node.right;

            }
        }
        str.append("#!");
        return str.toString();
    }
}
