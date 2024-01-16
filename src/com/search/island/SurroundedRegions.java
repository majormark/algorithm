package com.search.island;

public class SurroundedRegions {
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0, m, n);
            if (board[i][n - 1] == 'O') dfs(board, i, n - 1, m, n);
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') dfs(board, 0, i, m, n);
            if (board[m - 1][i] == 'O') dfs(board, m - 1, i, m, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'A') board[i][j] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int i, int j, int m, int n) {
        board[i][j] = 'A';
        for (int k = 0; k < 4; k++) {
            int tx = i + dx[k];
            int ty = j + dy[k];
            if (tx < 0 || tx >= m || ty < 0 || ty >= n) continue;
            if (board[tx][ty] == 'X' || board[tx][ty] == 'A') continue;
            dfs(board, tx, ty, m, n);
        }
    }
}
