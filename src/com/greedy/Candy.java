package com.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Candy {
    public int candy(int[] ratings) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.num));
        for (int i = 0; i < ratings.length; i++) {
            pq.add(new Pair(ratings[i], i));
        }
        int[] res = new int[ratings.length];
        Arrays.fill(res, 1);
        while (!pq.isEmpty()) {
            Pair pa = pq.poll();
            if (pa.idx + 1 < ratings.length) {
                if (ratings[pa.idx + 1] < ratings[pa.idx]) {
                    res[pa.idx] = res[pa.idx + 1] + 1;
                }
            }
            if (pa.idx - 1 >= 0) {
                if (ratings[pa.idx - 1] < ratings[pa.idx]) {
                    res[pa.idx] = Math.max(res[pa.idx], res[pa.idx - 1] + 1);
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < res.length; i++) {
            sum += res[i];
        }
        return sum;
    }

    class Pair {
        int num;
        int idx;

        Pair(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        new Candy().candy(new int[]{1,0,2});
    }
}
