package com.list;

/**
 * Created by major on 2017/9/12.
 *
 * 如何判断一个单链表是否有环？有环的话返回进入环的第一个节点的值，无环的话返回-1。如果链表的长度为N，请做到时间复杂度O(N)，额外空间复杂度O(1)。
 * 给定一个单链表的头结点head（注意另一个参数adjust为加密后的数据调整参数，方便数据设置，与本题求解无关)，请返回所求值。
 *
 *
 */
public class ChkLoop {

    public int chkLoop(ListNode head, int adjust) {

        if (head == null) {
            return -1;
        }
        if(head.next != null && head.next.next == null) {
            return -1;
        }
        ListNode fast = head;
        ListNode slow = head;
        fast = fast.next.next;
        slow = slow.next;
        while (fast != slow) {
            if(fast != null && fast.next != null) {
                fast = fast.next.next;
            } else {
                return -1;
            }
            slow = slow.next;
        }
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast.val;
    }
}
