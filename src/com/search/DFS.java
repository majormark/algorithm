package com.search;

public class DFS {
    public int[][] v;
    public int[][] map;
    public int m, n;
    public int p, q;
    public int min;
    public int[] dx = new int[]{0, 1, 0, -1};
    public int[] dy = new int[]{1, 0, -1, 0};

    public void dfs(int x, int y, int step) {
        if (x == p && y == q) {
            min = Math.min(step, min);
            return;
        }
        for (int i = 0; i < dx.length; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (map[tx][ty] == 1 && v[tx][ty] == 0) {
                v[tx][ty] = 1;
                dfs(x, y + 1, step + 1);
                v[tx][ty] = 0;
            }
        }

    }

    public int minStep(int startX, int startY, int m, int n) {
        v[0][0] = 0;
        dfs(startX,startY,0);
        return min;
    }

}
