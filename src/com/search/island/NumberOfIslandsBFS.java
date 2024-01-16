package com.search.island;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsBFS {
    int[][] visit;
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        visit = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visit[i][j] == 0) {
                    visit[i][j] = 1;
                    bfs(grid, i, j, m, n);
                    res++;
                }
            }
        }
        return res;
    }

    public void bfs(char[][] grid, int i, int j, int m, int n) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i, j));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            for (int k = 0; k < 4; k++) {
                int tx = p.x + dx[k];
                int ty = p.y + dy[k];
                if (tx <0 || tx >= m || ty < 0 || ty >= n) continue;
                if (grid[tx][ty] == '0' || visit[tx][ty] == 1) continue;
                visit[tx][ty] = 1;
                queue.offer(new Pair(tx, ty));
            }
        }
    }

    class Pair {
        int x;
        int y;
        public Pair(int i, int j) {
            this.x = i;
            this.y = j;
        }
    }
}
