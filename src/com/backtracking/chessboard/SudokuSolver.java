package com.backtracking.chessboard;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {

        backtrack(board);
    }

    public boolean backtrack(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') continue;
                for (char k = '1'; k <= '9'; k++) {
                    if (!isValid(i, j, k, board)) continue;
                    board[i][j] = k;
                    if (backtrack(board)) return true;
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }

    public boolean isValid(int row, int col, char num, char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) return false;
            if (board[i][col] == num) return false;
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) return false;
            }
        }
        return true;
    }
}
