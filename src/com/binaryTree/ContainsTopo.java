package com.binaryTree;

import com.string.KMP;

public class ContainsTopo {
    /**
     * 判断t1树是否包含t2树全部的拓扑结构 pg.140
     * @param head
     * @param t2
     * @return
     */
    public boolean contains(ListNode head, ListNode t2) {
        return check(head, t2) || contains(head.left, t2) || contains(head.right, t2);
    }

    public boolean check(ListNode t1, ListNode t2) {
        if (t2 == null) {
            return true;
        }
        if (t1 == null || t1.val != t2.val) {
            return false;
        }
        return check(t1.left, t2.left) && check(t1.right, t2.right);
    }

    public boolean containsTopoSubTree(ListNode head, ListNode t2) {
        String t1Str = serialByPre(head);
        String t2Str = serialByPre(t2);
        return new KMP().getIndexOf(t1Str, t2Str) != -1 ;
    }

    public String serialByPre(ListNode head) {
        if (head == null) {
            return "#!";
        }
        String res = head.val + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }
}
