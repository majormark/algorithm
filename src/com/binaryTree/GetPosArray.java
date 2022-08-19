package com.binaryTree;

import java.util.HashMap;

public class GetPosArray {
    public int[] getPosArray(int[] pre, int[] in) {

        if (pre == null || in == null) {
            return null;
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i=0;i<in.length;i++) {
            m.put(in[i], i);
        }
        int[] pos = new int[pre.length];
        setPos(pre, 0, pre.length - 1, in, 0, in.length-1, pos, pos.length-1, m);
        return pos;
    }

    public int setPos(int[] p, int pi, int pj, int[] n, int ni, int nj, int[] s, int si, HashMap<Integer, Integer> m) {
        if (pi > pj) {
            return si;
        }
        s[si--] = p[pi];
        int idx = m.get(p[pi]);
        int l = idx - ni;
        si = setPos(p, pi + l + 1, pj, n, idx + 1, nj, s, si, m);
        return setPos(p, pi+1, pi + l, n, ni, idx - 1, s, si, m);
    }
}
