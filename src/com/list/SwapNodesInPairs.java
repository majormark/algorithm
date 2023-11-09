package com.list;

/**
 * 两两交换链表中的结点 lc 24
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode d = new ListNode(0);
        d.next = head;
        ListNode pre = d;
        while (pre.next != null && pre.next.next != null) {
            ListNode a = pre.next;
            ListNode b = pre.next.next;
            pre.next = b;
            a.next = b.next;
            b.next = a;
            pre = pre.next.next;
        }
        return d.next;
    }
}
