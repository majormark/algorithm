package com.greedy;

import java.util.LinkedList;
//738. Monotone Increasing Digits
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int n) {
        LinkedList<Integer> tmp = new LinkedList<>();
        if (n < 10) {
            return n;
        }
        int num = n;
        while (num > 0) {
            tmp.add(0,num % 10);
            num /= 10;
        }
        LinkedList<Integer> res = new LinkedList<>();
        int carry = 0;
        for (int i = tmp.size() - 1; i>=0; i--) {
            if (i - 1 >= 0) {
                if (tmp.get(i - 1) <= tmp.get(i) - carry) {
                    res.add(0, tmp.get(i) - carry);
                    carry = 0;
                } else {
                    res.add(0, 9);
                    for (int j = 1; j < res.size(); j++) {
                        if (res.get(j) < 9) res.set(j, 9);
                        else break;
                    }
                    carry = 1;
                }
            } else {
                res.add(0, tmp.get(i) - carry);
            }
        }
        for (Integer a : res) {
            num = num * 10 + a;
        }
        return num;
    }
}
