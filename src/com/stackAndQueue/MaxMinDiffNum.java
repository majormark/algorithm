package com.stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by major on 2017/12/18.
 */
public class MaxMinDiffNum {
    public int getNum(int[] arr, int num) {
        Deque<Integer> qmax = new LinkedList<>();
        Deque<Integer> qmin = new LinkedList<>();
        int j = 0;
        int res = 0;
        for (int i=0;i<arr.length;i++) {
            while (j < arr.length) {
                while (!qmax.isEmpty() && arr[qmax.peekLast()] >= arr[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);
                while (!qmin.isEmpty() && arr[qmin.peekLast()] <= arr[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);
                if ( (arr[qmax.peekFirst()] - arr[qmin.peekFirst()]) > num )
                    break;
                j++;
            }
            if(qmax.peekFirst() == j)
                qmax.pollFirst();
            if(qmin.peekFirst() == j)
                qmin.pollFirst();
            res += j - i;
        }
        return res;
    }

    public static void main(String[] args) {
        MaxMinDiffNum m = new MaxMinDiffNum();
        int[] arr = {3, 5, 4, 6, 2, 1};
        System.out.println(m.getNum(arr, 2));
    }
}
