package com.stackAndQueue;

import java.util.List;
import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        int size = stack.size();
        int[] res = new int[stack.size()];
        for (int i=0;i<size;i++) {
            res[i] = stack.pop().val;
        }
        return res;
    }
}
