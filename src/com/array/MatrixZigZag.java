package com.array;

import java.util.LinkedList;
import java.util.List;

/**
 * 之字打印矩阵 pg 335
 */
public class MatrixZigZag {
    public List<Integer> printMatrixZigZag(int[][] m) {
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = m.length - 1;
        int endC = m[0].length - 1;
        boolean fromUp = false;
        List<Integer> res = new LinkedList<>();
        while (tR < m.length) {
            printLevel(m, tR, tC, dR, dC, fromUp, res);
            tC = tC == endC ? endC : tC + 1;
            tR = tC == endC ? tR : tR + 1;
            dR = dR == endR ? endR : dR + 1;
            dC = dR == endR ? dC : dC + 1;
            fromUp = !fromUp;
        }
        return res;
    }

    public void printLevel(int[][] m, int tR, int tC, int dR, int dC, boolean fromUp, List<Integer> res) {
        if (fromUp) {
            while (tR != dR + 1) {
                res.add(m[tR++][tC--]);
            }
        } else {
            while (dR !=tR - 1) {
                res.add(m[dR--][dC++]);
            }
        }
    }
}
