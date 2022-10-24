package com.array;

/**
 * 边界都是1的最大正方形大小
 */
public class SquareBorderOne {
    public void setBorder(int[][] m, int[][] right, int[][] down) {
        int row = m.length - 1;
        int col = m[0].length - 1;
        right[row][col] = m[row][col];
        down[row][col] = m[row][col];
        for (int i = row - 1; i >= 0; i--) {
            right[i][col] = m[i][col];
            if (m[i][col] == 1) {
                down[i][col] = down[i + 1][col] + 1;
            }
        }
        for (int j = col - 1; j >= 0; j--) {
            down[row][j] = m[row][j];
            if (m[row][j] == 1) {
                right[row][j] = right[row][j + 1] + 1;
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (m[i][j] == 1) {
                    right[i][j] = right[i][j + 1] + 1;
                    down[i][j] = down[i + 1][j] + 1;
                }
            }
        }
    }

    public int getMaxSize(int[][] m) {
        int[][] right = new int[m.length][m[0].length];
        int[][] down = new int[m.length][m[0].length];
        setBorder(m, right, down);
        for (int i = Math.min(m.length, m[0].length); i >= 0; i--) {
            if (hasSizeBorder(i, right, down)) {
                return i;
            }
        }
        return 0;
    }

    public boolean hasSizeBorder(int size, int[][] right, int[][] down) {
        for (int i = 0; i < right.length - size + 1; i++) {
            for (int j = 0; j < right[0].length - size + 1; j++) {
                if (right[i][j] >= size && down[i][j] >= size
                        && right[i + size - 1][j] >= size
                        && down[i][j + size - 1] >= size) {
                    return true;
                }
            }
        }
        return false;
    }
}
