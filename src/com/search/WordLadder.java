package com.search;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList.size());
        wordSet.addAll(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> visit = new HashSet<>();
        queue.offer(beginWord);
        visit.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (change(str, wordSet, visit, queue, endWord)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    public boolean change(String word, Set<String> wordSet, Set<String> visit, Queue<String> queue, String endWord) {
        char[] ch = word.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char tmp = ch[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (tmp == j) continue;
                ch[i] = j;
                String str = String.valueOf(ch);
                if (!wordSet.contains(str) || visit.contains(str)) continue;
                if (str.equals(endWord)) return true;
                queue.offer(str);
                visit.add(str);
            }
            ch[i] = tmp;
        }
        return false;
    }
}
