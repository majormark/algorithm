package com.array;

import java.util.LinkedList;
import java.util.List;

/**
 * 转圈打印矩阵 pg
 */
public class SpiralOrderPrint {

    public List<Integer> spiralOrderPrint(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return null;
        }
        int tR = 0;
        int tC = 0;
        int dR = m.length - 1;
        int dC = m[0].length - 1;
        List<Integer> res = new LinkedList<>();
        while (tR <= dR && tC <= dC) {
            printEdge(m, tR++, tC++, dR--, dC--, res);
        }
        return res;
    }

    public void printEdge(int[][] m, int tR, int tC, int dR, int dC, List<Integer> res) {
        int j = tC;
        int i = tR;
        while (j <= dC) {
            res.add(m[i][j++]);
        }
        i = tR + 1;
        j = dC;
        while (i <= dR) {
            res.add(m[i++][j]);
        }
        i = dR;
        j = dC - 1;
        while (j >= tC) {
            res.add(m[i][j--]);
        }
        i = dR - 1;
        j = tC;
        while (i > tR) {
            res.add(m[i--][j]);
        }
    }

}
