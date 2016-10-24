package com.list;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by major on 16/10/24.
 */
public class DivideTest {
    Divide d = new Divide();
    @Test
    public void listDivide() throws Exception {
        ListNode head = new ListNode(9);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(-1);
        print(d.listDivide(head, 3));

    }

    public void print(ListNode h) {
        ListNode node = h;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}