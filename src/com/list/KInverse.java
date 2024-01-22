package com.list;

/**
 * Created by major on 2017/7/3.
 */


import java.util.List;

/**
 * 有一个单链表，请设计一个算法，使得每K个节点之间逆序，如果最后不够K个节点一组，则不调整最后几个节点。
 * 例如链表1->2->3->4->5->6->7->8->null，K=3这个例子。调整后为，3->2->1->6->5->4->7->8->null。
 * 因为K==3，所以每三个节点之间逆序，但其中的7，8不调整，因为只有两个节点不够一组。
 * <p>
 * 给定一个单链表的头指针head,同时给定K值，返回逆序后的链表的头指针。
 */
public class KInverse {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        ListNode left = dummy;
        int count = 0;
        while (node != null) {
            if (count == k) {
                ListNode start = left.next;
                reverse(left, start, node, node.next);
                left = start;
                node = left;
                count = 0;
            }
            count++;
            node = node.next;
        }
        return dummy.next;
    }

    public void reverse(ListNode left, ListNode start, ListNode end, ListNode right) {
        ListNode pre = start;
        ListNode cur = start.next;
        ListNode next;
        start.next = right;
        left.next = end;
        while (cur != right) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

}
