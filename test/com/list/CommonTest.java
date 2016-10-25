package com.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by major on 16/10/25.
 */
public class CommonTest {
    Common common = new Common();


    @Test
    public void findCommonParts() throws Exception {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(3);
        headA.next.next = new ListNode(4);
        headA.next.next.next = new ListNode(6);
        headA.next.next.next.next = new ListNode(20);

        ListNode headB = new ListNode(2);
        headB.next = new ListNode(3);
        headB.next.next = new ListNode(4);
        headB.next.next.next = new ListNode(5);
        int[] results = common.findCommonParts(headA, headB);
        System.out.println(Arrays.toString(results));
    }

}