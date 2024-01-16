package com.search.island;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//827. Making A Large Island
public class MakingALargeIsland {
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};
    boolean[][] visit;
    int count;
    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        visit = new boolean[m][n];
        int mark = 2;
        Map<Integer, Integer> countMap = new HashMap<>();
        boolean isAllGrid = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) isAllGrid = false;
                if (grid[i][j] == 1 && !visit[i][j]) {
                    visit[i][j] = true;
                    count = 1;
                    grid[i][j] = mark;
                    dfs(grid, i, j, m, n, mark);
                    countMap.put(mark++, count);
                }
            }
        }
        if (isAllGrid) return m * n;
        HashSet<Integer> markSet = new HashSet<>();
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    markSet.clear();
                    count = 1;
                    for (int k = 0; k < 4; k++) {
                        int tx = i + dx[k];
                        int ty = j + dy[k];
                        if (tx < 0 || tx >= m || ty < 0 || ty >= n) continue;
                        if (grid[tx][ty] == 0 || markSet.contains(grid[tx][ty])) continue;
                        count += countMap.getOrDefault(grid[tx][ty], 0);
                        markSet.add(grid[tx][ty]);
                    }
                    res = Math.max(res, count);
                }
            }
        }
        return res;
    }

    public void dfs(int[][] grid, int i, int j, int m, int n, int mark) {
        for (int k = 0; k < 4; k++) {
            int tx = i + dx[k];
            int ty = j + dy[k];
            if (tx < 0 || tx >= m || ty < 0 || ty >= n) continue;
            if (grid[tx][ty] == 0 || visit[tx][ty]) continue;
            visit[tx][ty] = true;
            grid[tx][ty] = mark;
            count++;
            dfs(grid, tx, ty, m, n, mark);
        }
    }

    public static void main(String[] args) {
        new MakingALargeIsland().largestIsland(new int[][]{
                {0, 0},
                {1, 1}
        });
    }
}
