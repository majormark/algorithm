package com.list;

/**
 * Created by major on 2017/7/18.
 */

/**
 *
 * 请编写一个函数，检查链表是否为回文。

 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。

 测试样例：
 {1,2,3,2,1}
 返回：true
 {1,2,3,2,3}
 返回：false

 解法一：栈，先把所有元素压入栈中，那栈的元素就代表链表逆序，边出栈边比较

 解法二：栈，有快慢两个指针，快指针每次走两步，慢指针每次走一步，并且把元素压入栈中，等快指针到达尾结点以后，如果总数是奇数，慢指针就不把
 中间元素压入栈里。此时栈的元素是前半部分元素的逆序，之后依次出栈，对比后半部分。

 解法三：利用快慢指针，找到中间结点，对后半部分逆序，从两头同时向中间进行遍历，最后再把后半部分调整回原来的样子。
 */

public class Palindrome {
    public boolean isPalindrome(ListNode pHead) {
        // write code here
        if (pHead == null || pHead.next == null) {
            return true;
        }
        ListNode slow = pHead;
        ListNode fast = pHead.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = slow;
        if (fast.next != null) {
            pre = pre.next;
        }
        ListNode rStartTmp = reverse(pre, pre.next);
        pre.next = null;
        ListNode rStart = rStartTmp;
        ListNode lStart = pHead;
        while (lStart != null) {
            if (lStart.val != rStart.val) {
                return false;
            }
            lStart = lStart.next;
            rStart = rStart.next;
        }
        reverse(null, rStartTmp);
        return true;
    }

    public ListNode reverse(ListNode pre, ListNode cur) {
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
