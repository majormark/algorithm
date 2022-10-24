package com.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求最短通路值
 */
public class MatrixMinPath {
    public int minPathValue(int[][] m) {
        Queue<Integer> rQ = new LinkedList<>();
        Queue<Integer> cQ = new LinkedList<>();
        int[][] map = new int[m.length][m[0].length];
        map[0][0] = 1;
        rQ.add(0);
        cQ.add(0);
        int r = 0;
        int c = 0;
        while (!rQ.isEmpty()) {
            r = rQ.poll();
            c = cQ.poll();
            if (r == m.length - 1 && c == m[0].length - 1) {
                return map[r][c];
            }
            walkTo(map[r][c], r - 1, c, m, map, rQ, cQ);
            walkTo(map[r][c], r + 1, c, m, map, rQ, cQ);
            walkTo(map[r][c], r, c - 1, m, map, rQ, cQ);
            walkTo(map[r][c], r, c + 1, m, map, rQ, cQ);
        }
        return 0;
    }

    public void walkTo(int pre, int toR, int toC, int[][] m, int[][] map, Queue<Integer> rQ, Queue<Integer> cQ) {
        if (toR < 0 || toC < 0 || toR == m.length || toC == m[0].length || m[toR][toC] != 1 || map[toR][toC] != 0) {
            return;
        }
        map[toR][toC] = pre + 1;
        rQ.add(toR);
        cQ.add(toC);
    }
}
