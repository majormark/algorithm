package com.math;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 回文数 lc 9
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        Queue<Integer> q = new LinkedList<>();
        int c = x;
        while (c != 0) {
            int num = c % 10;
            q.offer(num);
            c /= 10;
        }
        int res = 0;
        while (!q.isEmpty()) {
            int num = q.poll();
            res = res * 10 + num;
        }
        return res == x;
    }
    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(123));
    }
}
