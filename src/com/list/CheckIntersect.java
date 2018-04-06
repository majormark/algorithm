package com.list;

import java.util.List;

/**
 * Created by major on 2017/9/13.
 *
 *
 */
public class CheckIntersect {

    /**
     *
     * @param headA
     * @param headB
     * @return
     *
     * 现在有两个无环单链表，若两个链表的长度分别为m和n，请设计一个时间复杂度为O(n + m)，额外空间复杂度为O(1)的算法，判断这两个链表是否相交。

    给定两个链表的头结点headA和headB，请返回一个bool值，代表这两个链表是否相交。保证两个链表长度小于等于500。
     */
    public boolean chkIntersect(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return false;
        int n = 0;
        ListNode cur1 = headA;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        ListNode cur2 = headB;
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        return cur1 == cur2;
    }


    /**
     *
     * @param head1
     * @param head2
     * @param adjust0
     * @param adjust1
     * @return
     *
     * 如何判断两个有环单链表是否相交？相交的话返回第一个相交的节点，不想交的话返回空。如果两个链表长度分别为N和M，请做到时间复杂度O(N+M)，
     * 额外空间复杂度O(1)。
     *
     * 给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。请返回一个bool值代表它们是否相交。
     */
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        // write code here
        if (head1 == null || head2 == null)
            return false;


        ListNode node1 = find(head1);
        ListNode node2 = find(head2);

        if(node1 == null || node2 == null)
            return false;
        if(node1 == node2)
            return true;

        ListNode cur = node1.next;
        while (cur != node1) {
            if (cur == node2)
                return true;
            cur = cur.next;
        }
        return false;
    }

    public ListNode find(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow) break;
        }
        if(fast == null || fast.next == null) return null;
        fast = head;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
