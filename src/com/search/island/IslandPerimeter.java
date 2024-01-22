package com.search.island;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                for (int k = 0; k < 4; k++) {
                    int tx = i + dx[k];
                    int ty = j + dy[k];
                    if (tx < 0 || tx >= m || ty < 0 || ty >= n) count++;
                    else if (grid[tx][ty] == 0) count++;
                }
            }
        }
        return count;
    }
}
