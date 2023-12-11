package com.binaryTree;

import java.util.HashMap;

/**
 * 先序、中序和后序两两结合重构二叉树pg 171
 */
public class BuildTree {

    public ListNode preInToTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i <= in.length; i++) {
            m.put(in[i], i);
        }
        return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, m);
    }

    public ListNode preIn(int[] p, int pi, int pj, int[] n, int ni, int nj, HashMap<Integer, Integer> m) {

        if (pi > pj) {
            return null;
        }
        ListNode h = new ListNode(p[pi]);
        int idx = m.get(p[pi]);
        int l = idx - ni;
        h.left = preIn(p, pi + 1, pi + l, n, ni, idx - 1, m);
        h.right = preIn(p, pi + l + 1, pj, n, idx + 1, nj, m);
        return h;
    }

    public ListNode inPosToTree(int[] in, int[] pos) {
        if (pos == null || in == null) {
            return null;
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            m.put(in[i], i);
        }
        return inPos(in, 0, in.length - 1, pos, 0, pos.length - 1, m);
    }

    public ListNode inPos(int[] n, int ni, int nj, int[] pos, int pi, int pj, HashMap<Integer, Integer> m) {
        if (pi > pj) {
            return null;
        }
        ListNode h = new ListNode(pos[pj]);
        int idx = m.get(pos[pj]);
        int l = idx - ni;
        h.left = inPos(n, ni, idx - 1, pos, pi, pj + l - 1, m);
        h.right = inPos(n, idx + 1, nj, pos, pi + l, pj - 1, m);
        return h;
    }

    public ListNode prePosToTree(int[] pre, int[] pos) {
        if (pre == null || pos == null) {
            return null;
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < pos.length; i++) {
            m.put(pos[i], i);
        }
        return prePos(pre, 0, pre.length - 1, pos, 0, pos.length - 1, m);
    }

    public ListNode prePos(int[] pre, int pi, int pj, int[] pos, int si, int sj, HashMap<Integer, Integer> m) {
        ListNode h = new ListNode(pos[sj--]);
        if (pi == pj) {
            return h;
        }
        int idx = m.get(pre[++pi]);
        int l = idx - si;
        h.left = prePos(pre, pi, pi + l, pos, si, idx, m);
        h.right = prePos(pre, pi + l + 1, pj, pos, idx + 1, sj, m);
        return h;
    }
}
