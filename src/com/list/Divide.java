package com.list;

/**
 * Created by major on 16/10/24.
 */

/**
 * 对于一个链表，我们需要用一个特定阈值完成对它的分化，使得小于等于这个值的结点移到前面，大于该值的结点在后面，同时保证两类结点内部的位置关系不变。
 * 给定一个链表的头结点head，同时给定阈值val，请返回一个链表，使小于等于它的结点在前，大于等于它的在后，保证结点值不重复。
 * 测试样例：
 *
 * {1,4,2,5},3
 *
 * {1,2,4,5}
 */

public class Divide {
    public ListNode listDivide(ListNode head, int val) {
        // write code here
        if(head == null || head.next == null)
            return null;
        ListNode fakeHead = new ListNode(val - 1);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        ListNode cur = fakeHead.next;

        while (cur != null) {
            if(cur.val <= val) {
                prev = prev.next;
                cur = cur.next;
            } else if(cur.val > val && cur.next != null && cur.next.val <= val) {
                ListNode node = prev.next;
                prev.next = cur.next;
                cur.next = cur.next.next;
                prev.next.next = node;
                prev = prev.next;
            } else {
                cur = cur.next;
            }

        }
        head = fakeHead.next;
        fakeHead = null;
        return head;
    }

    /**
     *
     * @param head
     * @param pivot
     * @return
     *
     * 官方解答
     */
    public ListNode listDivide2(ListNode head, int pivot) {
        ListNode sH = null; // small head
        ListNode sT = null; // small tail
        ListNode bH = null; // big head
        ListNode bT = null; // big tail
        ListNode next = null; // save next node
        // every node distributed to three lists
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val <= pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            }else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        if (sT != null) {
            sT.next = bH;
        }
        return sH != null ? sH : bH;
    }
}
