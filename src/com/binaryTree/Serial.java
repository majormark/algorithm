package com.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Serial {
    public String serialByPre(TreeNode head) {
        if (head == null) {
            return "#!";
        }
        String res = head.val + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    public TreeNode parseByPreString(String str) {
        String[] strList = str.split("!");
        TreeNode head;
        Queue<String> q = new LinkedList<>();
        for (int i=0;i<strList.length;i++) {
           q.offer(strList[i]);
        }
        return parseByPreOrder(q);
    }
    public TreeNode parseByPreOrder(Queue<String> q) {
        String val= q.poll();
        if (val.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = parseByPreOrder(q);
        node.right = parseByPreOrder(q);
        return node;
    }
}
