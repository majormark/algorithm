package com.list;

/**
 * Created by major on 16/10/20.
 */

/**
 * 给定一个链表中的结点node,但不给定头结点,要求删除链表的node结点,要求时间复杂度为O(1)
 *
 * 拷贝下个结点到当前结点,然后删掉下个结点,但这种方式无法删除最后一个结点
 */
public class Remove {
    public boolean removeNode(ListNode pNode) {
        // write code here
        if(pNode == null) {
            return false;
        }

        ListNode next = pNode.next;

        if(next == null) {
            return false;
        }

        pNode.val = next.val;
        pNode.next = next.next;
        return true;
    }

}
