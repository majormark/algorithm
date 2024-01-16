package com.search.island;

public class MaxAreaOfIsland {
    boolean[][] visit;
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};
    int count ;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        visit = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visit[i][j]) {
                    visit[i][j] = true;
                    count = 1;
                    dfs(grid, i, j, m, n);
                    res = Math.max(res, count);
                }
            }
        }
        return res;
    }

    public void dfs(int[][] grid, int i, int j, int m, int n) {
        for (int k = 0; k < 4; k++) {
            int tx = i + dx[k];
            int ty = j + dy[k];
            if (tx < 0 || tx >= m || ty < 0 || ty >= n) continue;
            if (grid[tx][ty] == 0 || visit[tx][ty]) continue;
            visit[tx][ty] = true;
            count++;
            dfs(grid, tx, ty, m, n);
        }
    }

    public static void main(String[] args) {
        new MaxAreaOfIsland().maxAreaOfIsland(new int[][]{
                {0,0,1,0,0,0},
                {0,0,1,1,0,0},
                {0,0,1,0,0,0}
        });
    }
}
