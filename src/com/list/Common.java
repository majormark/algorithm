package com.list;

import java.util.ArrayList;

/**
 * Created by major on 16/10/25.
 */
public class Common {

    public int[] findCommonParts(ListNode headA, ListNode headB) {

        if(headA == null || headB == null)
            return null;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        ArrayList<Integer> results = new ArrayList<>();
        while (nodeA != null && nodeB !=null) {
            if(nodeA.val < nodeB.val) {
                nodeA = nodeA.next;
            } else if(nodeB.val < nodeA.val) {
                nodeB = nodeB.next;
            } else {
                results.add(nodeA.val);
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }
        }

        int[] nums = new int[results.size()];
        for(int i=0;i<results.size();i++) {
            nums[i] = results.get(i);
        }
        return nums;
    }
}
