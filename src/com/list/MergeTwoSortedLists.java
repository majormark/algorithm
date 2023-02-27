package com.list;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list2.val < list1.val) {
            ListNode t = list1;
            list1 = list2;
            list2 = t;
        }
        ListNode h = list1;
        ListNode pre = h;
        list1 = list1.next;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                pre = list1;
                list1 = list1.next;
            } else {
                ListNode next = list2.next;
                list2.next = pre.next;
                pre.next = list2;
                list2 = next;
                pre = pre.next;
            }
        }
        if (list2 != null) {
            pre.next = list2;
        }
        return h;
    }
}
