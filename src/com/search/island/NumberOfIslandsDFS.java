package com.search.island;

public class NumberOfIslandsDFS {
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
                    dfs(grid, i, j, m, n);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j, int m, int n) {
        for (int k = 0; k < 4; k++) {
            int tx = i + dx[k];
            int ty = j + dy[k];
            if (tx >= m || tx < 0 || ty >= n || ty < 0) continue;
            if (grid[tx][ty] == '0' || visit[tx][ty] == 1) continue;
            visit[tx][ty] = 1;
            dfs(grid, tx, ty, m, n);
        }
    }

}
