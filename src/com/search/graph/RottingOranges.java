package com.search.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) freshCount++;
                else if (grid[i][j] == 2) queue.offer(new int[]{i, j});
            }
        }
        if (queue.isEmpty()) {
            return freshCount == 0 ? 0 : -1;
        }
        int changeCount = 0;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] p = queue.poll();
                int x = p[0];
                int y = p[1];
                for (int j = 0; j < 4; j++) {
                    int tx = x + dx[j];
                    int ty = y + dy[j];
                    if (tx < 0 || tx >= m || ty < 0 || ty >= n) continue;
                    if (grid[tx][ty] == 1) {
                        grid[tx][ty] = 2;
                        changeCount++;
                        queue.offer(new int[]{tx, ty});
                    }
                }
            }
            if (!queue.isEmpty()) step++;
        }
        if (changeCount != freshCount) return -1;
        return step;
    }

    public static void main(String[] args) {
        new RottingOranges().orangesRotting(new int[][]{{0, 2}});
    }
}
