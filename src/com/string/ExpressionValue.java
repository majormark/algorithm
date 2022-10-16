package com.string;

import java.util.Deque;
import java.util.LinkedList;

public class ExpressionValue {
    public int getValue(String exp) {
        return value(exp.toCharArray(), 0)[0];
    }
    public int[] value(char[] ch, int i) {
        Deque<String> dq = new LinkedList<>();
        int pre = 0;
        while (i < ch.length && i != ')') {
            if (ch[i] >= '0' && ch[i] <= '9') {
                pre = pre * 10 + ch[i] - '0';
                i++;
            } else if (ch[i] != '(') {
                addNum(dq, pre);
                dq.addLast(String.valueOf(ch[i++]));
                pre = 0;
            } else {
                int[] res = value(ch, i + 1);
                pre = res[0];
                i = res[1] + 1;
            }
        }
        addNum(dq, pre);
        return new int[]{getNum(dq), i};
    }

    public void addNum(Deque<String> dq, int num) {
        if (!dq.isEmpty()) {
            int cur = 0;
            String s = dq.pollLast();
            if (s.equals("+")  || s.equals("-")) {
                dq.addLast(s);
            } else {
                cur = Integer.valueOf(dq.pollLast());
                num = s.equals("*") ? cur * num : cur / num;
            }
        }
        dq.addLast(String.valueOf(num));
    }

    public int getNum(Deque<String> dq) {
        String cur;
        int pre = 0;
        int num = 0;
        boolean add = true;
        while (!dq.isEmpty()) {
             cur = dq.pollFirst();
             if (cur.equals("+")) {
                 add = true;
             } else if (cur.equals("-")) {
                 add = false;
             } else {
                 num = Integer.valueOf(cur);
                 pre = add ? pre + num : pre - num;
             }
        }
        return pre;
    }
}
