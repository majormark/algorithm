package com.list;

/**
 * 排序链表 lc 148
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode n = head;
        while (n.next != null) {
            n = n.next;
        }
        return merge(head, n);
    }

    public ListNode merge(ListNode start, ListNode end) {
        if (start == end) {
            return start;
        }
        ListNode slow = start;
        ListNode fast = start;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode endLeft = slow;
        ListNode endRight = fast.next == null ? fast : fast.next;
        ListNode startRight = slow.next;
        endLeft.next = null;
        ListNode ls = merge(start, endLeft);
        ListNode rs = merge(startRight, endRight);
        return mergeTwo(ls, rs);
    }

    public ListNode mergeTwo(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0);
        ListNode tail = h;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 != null ? l1 : l2;
        return h.next;
    }
}
