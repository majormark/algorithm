package com.string;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        char[] ch = word.toCharArray();
        TrieNode n = root;
        int index;
        for (int i = 0; i < ch.length; i++) {
            index = ch[i] - 'a';
            if (n.map[index] == null) {
                n.map[index] = new TrieNode();
            }
            n = n.map[index];
            n.path++;
        }
        n.end++;
    }

    public boolean search(String word) {
        char[] ch = word.toCharArray();
        TrieNode n = root;
        int index;
        for (int i = 0; i < ch.length; i++) {
            index = ch[i] - 'a';
            if (n.map[index] == null) {
                return false;
            }
            n = n.map[index];
        }
        return n.end > 0;
    }

    public void delete(String word) {
        if (search(word)) {
            char[] ch = word.toCharArray();
            int index;
            TrieNode n = root;
            for (int i = 0; i < ch.length; i++) {
                index = ch[i] - 'a';
                if (n.map[index].path-- == 1) {
                    n.map[index] = null;
                    return;
                }
                n = n.map[index];
            }
            n.end--;
        }
    }

    public int prefixNumber(String pre) {
        char[] ch = pre.toCharArray();
        TrieNode n = root;
        int index;
        for (int i = 0; i < ch.length; i++) {
            index = ch[i] - 'a';
            if (n.map[index] == null) {
                return 0;
            }
            n = n.map[index];

        }
        return n.path;
    }
}

class TrieNode {
    int path;
    int end;
    TrieNode[] map;

    public TrieNode() {
        path = 0;
        end = 0;
        map = new TrieNode[26];
    }
}
