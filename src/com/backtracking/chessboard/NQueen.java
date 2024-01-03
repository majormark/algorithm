package com.backtracking.chessboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueen {
    public List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new LinkedList<>();
        char[][] chessboard = new char[n][n];
        for (char[] row : chessboard) {
            Arrays.fill(row, '.');
        }
        backtrack(n, 0, chessboard);
        return res;
    }

    public void backtrack(int n, int row, char[][] chessboard) {
        if (row == n) {
            res.add(Array2List(chessboard));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isValid(n, row, i, chessboard)) continue;
            chessboard[row][i] = 'Q';
            backtrack(n, row + 1, chessboard);
            chessboard[row][i] = '.';
        }
    }

    public boolean isValid(int n, int row, int col, char[][] chessboard) {
        // 检查列
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') return false;
        }
        return true;
    }

    public List<String> Array2List(char[][] chessboard) {
        ArrayList<String> res = new ArrayList<>(chessboard.length);
        for (int i = 0; i < chessboard.length; i++) {
            res.add(String.valueOf(chessboard[i]));
        }
        return res;
    }

}
