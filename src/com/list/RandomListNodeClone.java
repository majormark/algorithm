package com.list;

/**
 * Created by major on 2017/9/10.
 */
public class RandomListNodeClone {
    public RandomListNode clone(RandomListNode pHead) {

        if (pHead == null)
            return null;
        RandomListNode curNode = pHead;

        while (curNode != null) {
            RandomListNode newNode = new RandomListNode(curNode.label);
            newNode.next = curNode.next;
            curNode.next = newNode;
            curNode = newNode.next;
        }

        curNode = pHead;
        RandomListNode curNodeNew = curNode.next;
        while (curNode != null) {
            curNodeNew.random = curNode.random != null ? curNode.random.next : null;
            curNode = curNode.next.next;
            if (curNode != null) {
                curNodeNew = curNodeNew.next.next;
            }

        }

        curNode = pHead;
        curNodeNew = curNode.next;
        RandomListNode pHeadNew = pHead.next;
        while (curNode != null) {
            curNode.next = curNodeNew.next;
            if (curNode.next != null) {
                curNodeNew.next = curNode.next.next;
                curNodeNew = curNodeNew.next;
            }
            curNode = curNode.next;
        }
        return pHeadNew;
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node node = head;
        while (node != null) {
            Node copy = new Node(node.val);
            Node next = node.next;
            node.next = copy;
            copy.next = next;
            node = next;
        }
        node = head;
        while (node != null) {
            Node next = node.next;
            if (node.random != null) {
                next.random = node.random.next;
            }
            node = node.next.next;
        }
        Node newHead = head.next;
        node = head;
        while (node != null) {
            Node node2 = node.next;
            Node next1 = node2.next;
            node.next = next1;
            if (next1 != null) {
                node2.next = next1.next;
            }
            node = next1;
        }
        return newHead;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
