package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by major on 16/5/2.
 */
public class TreePrinter {
    public int[][] printTree(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        int now=1, next=0,i=0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        list.add(new ArrayList<Integer>());
        while(queue.size() != 0) {
            TreeNode temp = queue.remove();
            if(temp.left != null) {
                queue.add(temp.left);
                next++;

            }
            if(temp.right != null) {
                queue.add(temp.right);
                next++;
            }

            list.get(i).add(temp.val);
            now--;
            if(now == 0) {
                now = next;
                next = 0;
                i++;
                list.add(new ArrayList<Integer>());
            }

        }

        int[][] result = new int[list.size()-1][];
        for(int j=0;j<result.length;j++) {
            result[j] = new int[list.get(j).size()];
            for(int k=0;k<result[j].length;k++) {
                result[j][k] = list.get(j).get(k);
            }
        }
        return result;
    }

    public int[][] printTree2(TreeNode root) {
        int i=0;
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode last = root, nlast = root;
        queue.add(root);
        list.add(new ArrayList<Integer>());
        while(queue.size() != 0) {
            TreeNode temp = queue.remove();
            if(temp.left != null) {
                queue.add(temp.left);
                nlast = temp.left;

            }
            if(temp.right != null) {
                queue.add(temp.right);
                nlast = temp.right;
            }
            list.get(i).add(temp.val);
            if(temp.val == last.val) {
                last = nlast;
                i++;
                list.add(new ArrayList<Integer>());
            }
        }
        int[][] result = new int[list.size()-1][];
        for(int j=0;j<result.length;j++) {
            result[j] = new int[list.get(j).size()];
            for(int k=0;k<result[j].length;k++) {
                result[j][k] = list.get(j).get(k);
            }
        }
        return result;
    }
}
