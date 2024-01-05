package com.map.array;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowMap = new boolean[9][10];
        boolean[][] colMap = new boolean[9][10];
        boolean[][] areaMap = new boolean[9][10];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                int areaNum = i/3 * 3 + j / 3;
                if (rowMap[i][num] || colMap[j][num] || areaMap[areaNum][num]) return false;
                rowMap[i][num] = true;
                colMap[j][num] = true;
                areaMap[areaNum][num] = true;
            }
        }
        return true;
    }
}
