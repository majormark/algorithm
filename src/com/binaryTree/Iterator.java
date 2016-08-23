package com.binaryTree;

/**
 * Created by major on 16/8/22.
 */
public class Iterator {
    public void preOrderRecursion(TreeNode root) {
        if(root != null) {
            System.out.println(root.val);
            preOrderRecursion(root.left);
            preOrderRecursion(root.right);
        }
    }

    public void inOrderRecursion(TreeNode root) {
        if(root != null) {
            preOrderRecursion(root.left);
            System.out.println(root.val);
            preOrderRecursion(root.right);
        }
    }

    public void postOrderRecursion(TreeNode root) {
        if(root != null) {
            preOrderRecursion(root.left);
            preOrderRecursion(root.right);
            System.out.println(root.val);
        }
    }

    public void preOrderIteration(TreeNode root) {

    }
}
