package com.string;

/**
 * Created by major on 16/9/20.
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * 对于一个给定的字符串数组，请找到一种拼接顺序，使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。
 * 给定一个字符串数组strs，同时给定它的大小，请返回拼接成的串。
 * 测试样例：
 * ["abc","de"],2
 *
 * "abcde"
 *
 */
public class Prior {
    public String findSmallest(String[] strs, int n) {
        // write code here
        //process(strs, 0, n - 1);
        Arrays.sort(strs, new MyComparator());
        StringBuilder builder = new StringBuilder();
        for(String s : strs) {
            builder.append(s);
        }

        return builder.toString();
    }

    public void process(String[] strs, int left, int right) {
        if(left < right) {
            int mid = partial(strs, left, right);
            process(strs, left, mid);
            process(strs, mid + 1, right);
        }
    }

    public int partial(String[] strs, int left, int right) {
        String prior = strs[left];
        while(left < right) {
            while(left < right && (prior + strs[right]).compareTo((strs[right] + prior)) == -1 ) right--;
            swap(strs, left, right);
            while(left < right && (strs[left] + prior).compareTo((prior + strs[left])) == -1 ) left++;
            swap(strs, left, right);
        }
        return left;

    }

    public void swap(String[] strs, int i, int j) {
        String temp = strs[i];
        strs[i] = strs[j];
        strs[j] = temp;
    }

    class MyComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return(o1 + o2).compareTo((o2 + o1));
        }
    }
}
