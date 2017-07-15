package com.list;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by major on 2017/7/4.
 */
public class KInverseTest {
    ListNode head = new ListNode(1);
    KInverse kInverse = new KInverse();
    @Before
    public void setUp() {
        ListNode last = head;
        for(int i=2;i<=8;i++) {
            last.next = new ListNode(i);
            last = last.next;
        }

    }
    @Test
    public void inverse() throws Exception {
        System.out.println("-----before");
        printList(head);
        System.out.println();
        System.out.println("-----after");
        head = kInverse.inverse(head, 3);
        printList(head);
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