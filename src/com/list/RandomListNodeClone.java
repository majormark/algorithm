package com.list;

/**
 * Created by major on 2017/9/10.
 */
public class RandomListNodeClone {
    public RandomListNode clone(RandomListNode pHead) {

        if(pHead == null)
            return null;
        RandomListNode curNode = pHead;

        while(curNode != null) {
            RandomListNode newNode = new RandomListNode(curNode.label);
            newNode.next = curNode.next;
            curNode.next = newNode;
            curNode = newNode.next;
        }

        curNode = pHead;
        RandomListNode curNodeNew = curNode.next;
        while(curNode != null) {
            curNodeNew.random = curNode.random != null ? curNode.random.next : null;
            curNode = curNode.next.next;
            if(curNode != null) {
                curNodeNew = curNodeNew.next.next;
            }

        }

        curNode = pHead;
        curNodeNew = curNode.next;
        RandomListNode pHeadNew = pHead.next;
        while (curNode != null) {
            curNode.next = curNodeNew.next;
            if(curNode.next != null) {
                curNodeNew.next = curNode.next.next;
                curNodeNew = curNodeNew.next;
            }
            curNode = curNode.next;
        }
        return pHeadNew;
    }
}
