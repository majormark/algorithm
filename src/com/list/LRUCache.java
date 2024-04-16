package com.list;

import java.util.HashMap;

public class LRUCache {

    class Node {
        int key, val;
        Node next, pre;
        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }
    class DoubleList {
        Node head, tail;
        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
        }

        void addFirst(Node node) {
            Node next = head.next;
            head.next = node;
            node.next = next;
            node.pre = head;
            next.pre = node;
        }
        void remove(Node node) {
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;
        }
        Node removeLast() {
            Node res = tail.pre;
            remove(tail.pre);
            return res;
        }
    }

    public int cap;
    DoubleList cache;
    HashMap<Integer, Node> map;
    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new DoubleList();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        cache.remove(node);
        cache.addFirst(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
        } else if (map.size() == this.cap) {
            Node last = cache.removeLast();
            map.remove(last.key);
        }
        cache.addFirst(node);
        map.put(key, node);
    }
}
