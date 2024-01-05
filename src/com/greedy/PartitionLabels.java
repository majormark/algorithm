package com.greedy;

import java.util.*;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] hash = new int[26];
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            hash[ch[i] - 'a'] = i;
        }
        List<Integer> res = new LinkedList<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < ch.length; i++) {
            right = Math.max(right, hash[ch[i] - 'a']);
            if (i == right) {
                res.add(right - left + 1);
                left = i + 1;
            }
        }
        return res;
    }

    public List<Integer> partitionLabels2(String s) {
        if (s.length() <= 1) {
            List<Integer> r = new LinkedList<Integer>();
            r.add(s.length());
            return r;
        }
        Map<Character, Range> map = new HashMap<>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            Range range = map.getOrDefault(ch[i], new Range(Integer.MAX_VALUE, Integer.MIN_VALUE));
            range.left = Math.min(range.left, i);
            range.right = Math.max(range.right, i);
            map.put(ch[i], range);
        }

        Range[] list = new Range[map.size()];
        int idx = 0;
        for (Map.Entry<Character, Range> entry : map.entrySet()) {
            list[idx++] = entry.getValue();
        }

        Arrays.sort(list, Comparator.comparingInt(a -> a.left));
        LinkedList<Integer> res = new LinkedList<>();
        int right = list[0].right;
        int left = list[0].left;
        for (int i = 1; i < list.length; i++) {
            if (list[i].left < right) {
                right = Math.max(right, list[i].right);
            } else {
                res.add(right - left + 1);
                left = list[i].left;
                right = list[i].right;
            }

        }
        res.add(right - left + 1);
        return res;
    }

    class Range {
        int left;
        int right;

        Range(int l, int r) {
            this.left = l;
            this.right = r;
        }
    }
}
