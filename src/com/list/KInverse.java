package com.list;

/**
 * Created by major on 2017/7/3.
 */


import java.util.List;

/**
 * 有一个单链表，请设计一个算法，使得每K个节点之间逆序，如果最后不够K个节点一组，则不调整最后几个节点。
 * 例如链表1->2->3->4->5->6->7->8->null，K=3这个例子。调整后为，3->2->1->6->5->4->7->8->null。
 * 因为K==3，所以每三个节点之间逆序，但其中的7，8不调整，因为只有两个节点不够一组。
 *
 * 给定一个单链表的头指针head,同时给定K值，返回逆序后的链表的头指针。
 */
public class KInverse {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2 || head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode start = head;
        ListNode cur = head;
        ListNode next = null;
        int count = 1;
        while (cur != null) {
            if (count == k) {
                next = cur.next;
                reverse(pre, start, cur, next);
                pre = start;
                cur = start;
                start = next;
                count = 0;
            }
            cur = cur.next;
            count++;
        }
        return dummy.next;
    }

    public void reverse(ListNode left, ListNode start, ListNode end, ListNode right) {
        ListNode node = start.next;
        ListNode pre = start;
        ListNode next = null;
        start.next = right;
        left.next = end;
        while (node != right) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
    }
}
