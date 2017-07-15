package com.list;

/**
 * Created by major on 2017/7/3.
 */

/**
 * 有一个单链表，请设计一个算法，使得每K个节点之间逆序，如果最后不够K个节点一组，则不调整最后几个节点。
 * 例如链表1->2->3->4->5->6->7->8->null，K=3这个例子。调整后为，3->2->1->6->5->4->7->8->null。
 * 因为K==3，所以每三个节点之间逆序，但其中的7，8不调整，因为只有两个节点不够一组。
 *
 * 给定一个单链表的头指针head,同时给定K值，返回逆序后的链表的头指针。
 */
public class KInverse {

    public ListNode inverse(ListNode head, int k) {
        // write code here
        if(head == null)
            return null;
        ListNode now = head.next;
        ListNode tail = head;
        ListNode curHead = head;
        ListNode nextHead = head;
        int count = 0;
        boolean first = true;
        while(nextHead != null) {
            count = 0;
            curHead = nextHead;
            tail = curHead;
            now = curHead.next;
            //check
            for (int i = 0; i < k; i++) {
                if (nextHead != null) {
                    nextHead = nextHead.next;
                } else {
                    return head;
                }
            }

            while(count < k - 1) {
                ListNode node = now.next;
                now.next = curHead;
                curHead = now;
                now = node;

                count++;
            }
            if(first) {
                first = false;
                head = curHead;
            }
            ListNode nextTail = nextHead;
            for(int i=0;i<k-1;i++) {
               if(nextTail != null) {
                   nextTail = nextTail.next;
               }
            }
            if(nextTail != null) {
                tail.next = nextTail;
            } else {
                tail.next = nextHead;
            }
        }

        return head;
    }

    public ListNode inverse(ListNode head) {
        if(head == null) return null;
        ListNode now = head.next;
        head.next = null;
        while (now != null) {

            ListNode node = now.next;
            now.next = head;
            head = now;
            now = node;
        }
        return head;
    }
}
