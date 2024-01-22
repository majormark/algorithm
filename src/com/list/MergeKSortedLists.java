package com.list;

import java.util.PriorityQueue;

/**
 * 合并K个升序链表 lc 23
 */
public class MergeKSortedLists {
    // 分治法
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {

        if (l > r) {
            return null;
        }
        if (l == r) {
            return lists[l];
        }
        int mid = (l + r) / 2;
        return mergeTwoList(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode tail = head;
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

        tail.next = l1 == null ? l2 : l1;
        return head.next;
    }


    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        for (ListNode n : lists) {
            if (n != null) {
                pq.offer(n);
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!pq.isEmpty()) {
            ListNode s = pq.poll();
            tail.next = s;
            tail = tail.next;
            if (s.next != null) {
                pq.offer(s.next);
            }
        }

        return head.next;
    }
}
