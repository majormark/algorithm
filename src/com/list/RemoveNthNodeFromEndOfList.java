package com.list;

import java.util.List;

/**
 * 删除链表的倒数第N个结点 lc 19
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode h = head;
        int count = 1;
        while (h != null) {
            h = h.next;
            count++;
        }
        if (n > count) {
            return head;
        }
        ListNode reHead = reverse(head);
        if (n == 1) {
            ListNode next = reHead.next;
            reHead.next = null;
            reHead = next;
        } else {
            ListNode pre = reHead;
            ListNode node = reHead.next;
            while (n > 2) {
                pre = node;
                node = node.next;
                n--;
            }
            ListNode next = node.next;
            node.next = null;
            pre.next = next;
        }
        return reverse(reHead);

    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
