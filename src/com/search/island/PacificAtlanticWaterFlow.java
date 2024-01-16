package com.search.island;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new LinkedList<>();
        int m = heights.length, n = heights[0].length;
        boolean[][] leftTopVisit = new boolean[m][n];
        boolean[][] rightDownVisit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights, leftTopVisit, i, 0, m, n);
            dfs(heights, rightDownVisit, i, n - 1, m, n);
        }
        for (int i = 0; i < n; i++) {
            dfs(heights, leftTopVisit, 0, i, m, n);
            dfs(heights, rightDownVisit, m - 1, i, m, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (leftTopVisit[i][j] && rightDownVisit[i][j]) {
                    List<Integer> p = new ArrayList<Integer>(2);
                    p.add(i);
                    p.add(j);
                    res.add(p);
                }
            }
        }
        return res;
    }

    public void dfs(int[][] heights, boolean[][] visit, int i, int j, int m, int n) {
        visit[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int tx = i + dx[k];
            int ty = j + dy[k];
            if (tx < 0 || tx >= m || ty < 0 || ty >= n) continue;
            if (heights[tx][ty] < heights[i][j] || visit[tx][ty]) continue;
            dfs(heights, visit, tx, ty, m, n);
        }
    }
}
