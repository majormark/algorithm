package com.search.island;

//1020. Number of Enclaves
public class NumberOfEnclaves {
    boolean canCount;
    boolean[][] visit;
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};
    int count;

    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        visit = new boolean[m][n];
        int res = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && !visit[i][j]) {
                    count = 1;
                    visit[i][j] = true;
                    canCount = true;
                    dfs(grid, i, j, m, n);
                    if (canCount) res += count;
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
            if (tx == 0 || tx == m - 1 || ty == 0 || ty == n - 1) canCount = false;
            count++;
            visit[tx][ty] = true;
            dfs(grid, tx, ty, m, n);
        }
    }

    public static void main(String[] args) {
        new NumberOfEnclaves().numEnclaves(new int[][]{
                {0,0,0,0,0,0},
                {0,0,1,1,0,0},
                {0,0,1,0,0,0},
                {0,0,0,0,0,0}
        });
    }
}
