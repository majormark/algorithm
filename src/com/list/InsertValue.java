package com.list;

/**
 * Created by major on 16/10/12.
 *
 * 有一个整数val，如何在节点值有序的环形链表中插入一个节点值为val的节点，并且保证这个环形单链表依然有序。
 * 给定链表的信息，及元素的值A及对应的nxt指向的元素编号同时给定val，请构造出这个环形链表，并插入该值。
 * 测试样例：
 * [1,3,4,5,7],[1,2,3,4,0],2
 * 返回：{1,2,3,4,5,7}
 */
public class InsertValue {
    public ListNode insert(int[] A, int[] nxt, int val) {
        // write code here
        ListNode head = new ListNode(A[0]);
        ListNode node = new ListNode(val);
        ListNode r = head;
        for(int i=0;i<A.length - 1;i++) {
            ListNode nextNode = new ListNode(A[nxt[i]]);
            r.next = nextNode;
            r = nextNode;
        }

        if(val < head.val) {
            node.next = head;
            return node;
        }
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {
            if(pre.val <= val && val <= cur.val) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        if(cur != null) {
            pre.next = node;
            node.next = cur;

        } else {
            pre.next = node;

        }
        return head;
    }

}
