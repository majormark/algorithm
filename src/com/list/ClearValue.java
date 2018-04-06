package com.list;

/**
 * Created by major on 2017/7/17.
 */

/**
 *
 * 现在有一个单链表。链表中每个节点保存一个整数，再给定一个值val，把所有等于val的节点删掉。

 给定一个单链表的头结点head，同时给定一个值val，请返回清除后的链表的头结点，保证链表中有不等于该值的其它值。请保证其他元素的相对顺序。

 测试样例：
 {1,2,3,4,3,2,1},2
 {1,3,4,3,1}
 */
public class ClearValue {

    public ListNode clear(ListNode head, int val) {
        // write code here
        //头结点是被删除
        //尾巴结点和普通结点被删除 情况一样
        while(head.val == val) {
            ListNode now = head.next;
            head.next = null;
            head = now;
        }
        ListNode now = head;
        while(now.next != null) {
            ListNode prev = now;
            now = now.next;
            if(now.val == val) {
                prev.next = now.next;
                now.next = null;
                now = prev;
            }
        }

        return head;
    }
}
