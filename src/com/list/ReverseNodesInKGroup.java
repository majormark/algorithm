package com.list;

/**
 * K个一组翻转链表 lc 25
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode s = head;
        ListNode e = s;
        while (e != null) {
            int c = k;
            while (c != 1) {
                e = e.next;
                if (e == null) {
                    break;
                }
                c--;
            }
            if (e == null) {
                break;
            }
            reverse(s, e);
            pre.next = e;
            pre = s;
            s = s.next;
            e = s;
        }
        return dummy.next;
    }

    public void reverse(ListNode start, ListNode end) {
        ListNode next = end.next;
        end.next = null;
        ListNode pre = start;
        ListNode cur = start.next;
        while (cur != null) {
            ListNode n = cur.next;
            cur.next = pre;
            pre = cur;
            cur = n;
        }
        start.next = next;
    }
}
