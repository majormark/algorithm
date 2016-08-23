package com.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by major on 16/8/22.
 *
 * 二叉树的几种遍历方式
 */
public class Iterator {

    //递归 先序遍历
    public void preOrderRecursion(TreeNode root) {
        if(root != null) {
            System.out.println(root.val);
            preOrderRecursion(root.left);
            preOrderRecursion(root.right);
        }
    }

    //递归 中序遍历
    public void inOrderRecursion(TreeNode root) {
        if(root != null) {
            preOrderRecursion(root.left);
            System.out.println(root.val);
            preOrderRecursion(root.right);
        }
    }

    //递归 后序遍历
    public void postOrderRecursion(TreeNode root) {
        if(root != null) {
            preOrderRecursion(root.left);
            preOrderRecursion(root.right);
            System.out.println(root.val);
        }
    }

    /**
     *
     * @param root
     *
     * 非递归 先序遍历
     * 先遍历左子树,先读取值然后后压栈,直到遇到null以后,出栈,得到右子树,继续之前的遍历
     */
    public void preOrderIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null || stack.size() > 0) {
            while(node != null) {
                System.out.println(node.val);
                stack.push(node);
                node = node.left;
            }

            if(stack.size() > 0) {
                node = stack.pop();
                node = node.right;
            }

        }
    }

    /**
     *
     * @param root
     *
     * 非递归 中序遍历
     * 类似于先序遍历,调整压栈和打印的位置
     * 先遍历左子树,然后遇到null,出栈,打印值,得到右子树,重复之前的步骤
     */
    public void inOrderIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            if(stack.size() > 0) {
                node = stack.pop();
                System.out.println(node.val);
                node = node.right;
            }
        }
    }

    /**
     *
     * @param root
     *
     * 非递归 后序遍历
     * 使用一个结点记录前一个输出
     * 同样先遍历左子树,直到遇到null,打印该结点,取栈顶元素的右节点但该元素不出栈,只有当右节点为空或等于前一个输出时,才打印该节点
     */
    public void postOrderIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode prev = node;
        while(node != null || stack.size() > 0) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if(stack.size() > 0) {
                node = stack.peek().right;
                if(node == null || node == prev) {
                    node = stack.pop();
                    System.out.println(node.val);
                    prev = node;
                    node = stack.peek().right;
                }
            }
        }
    }

    public void levelIteration(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        node = root;
        queue.add(node);
        while(queue.size() > 0) {
            node = queue.poll();
            System.out.println(node.val);
            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
    }

}
