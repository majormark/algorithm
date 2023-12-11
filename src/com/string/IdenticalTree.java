package com.string;

import com.binaryTree.ListNode;

import java.util.Stack;

/**
 * Created by major on 16/8/22.
 *
 * 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
 * 给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。
 *
 * 思路:最优解 使用二叉树序列化的方式,将两棵二叉树序列化为字符串,然后使用kmp算法验证是否包含那棵二叉树
 * 复杂度 O()
 */



public class IdenticalTree {
    public boolean chkIdentical(ListNode A, ListNode B) {
        // write code here
        if(A == null || B == null) {
            return  false;
        }

        String strA = serialize(A);
        String strB = serialize(B);
        int[] next = getNext(strB);
        char[] strAArray = strA.toCharArray();
        char[] strBArray = strB.toCharArray();
        int j = 0;
        int i = 0;
        while (i < strAArray.length && j < strBArray.length) {
            if(j == -1 || strAArray[i] == strBArray[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if(j == strBArray.length) {
            return true;
        } else {
            return false;
        }
    }

    //二叉树的
    public String serialize(ListNode root) {
        if(root == null) {
            return null;
        }
        StringBuilder str = new StringBuilder("");
        Stack<ListNode> stack = new Stack();
        ListNode node = root;
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

    public int[] getNext(String str) {
        int[] next = new int[str.length()];
        char[] strArray = str.toCharArray();
        int k = -1;
        int j = 0;
        next[0] = -1;
        while(j < strArray.length - 1) {
            if(k == -1 || strArray[k] == strArray[j]) {
                k++;
                j++;
                if(strArray[k] != strArray[j]) {
                    next[j] = k;
                } else {
                    next[j] = next[k];
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
