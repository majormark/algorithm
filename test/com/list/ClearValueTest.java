package com.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by major on 2017/7/17.
 */
public class ClearValueTest {
    ListNode head = new ListNode(1);
    ClearValue cv;
    @Before
    public void setUp() {
        cv = new ClearValue();
        ListNode last = head;
        for(int i=2;i<=5;i++) {
            last.next = new ListNode(i);
            last = last.next;
        }
        for(int i=2;i<=5;i++) {
            last.next = new ListNode(i);
            last = last.next;
        }

    }

    @Test
    public void clear() throws Exception {
        ListNode headNew = cv.clear(head, 2);
        printList(headNew);
    }

    private void printList(ListNode head) {
        if(head == null) {
            System.out.print("null");
        } else {
            System.out.print(head.val + " -> ");
        }
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            System.out.print(cur.val + " -> ");
        }
    }
}