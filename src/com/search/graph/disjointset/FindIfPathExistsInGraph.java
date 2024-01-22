package com.search.graph.disjointset;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//1971. Find if Path Exists in Graph
public class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DisjointSet s = new DisjointSet(n);

        for (int i = 0; i < edges.length; i++) {
            s.join(edges[i][0], edges[i][1]);
        }
        return s.isSame(source, destination);
    }

    class DisjointSet {
        int[] fatherMap;

        public DisjointSet(int n) {
            fatherMap = new int[n];
            for (int i = 0; i < n; i++) {
                fatherMap[i] = i;
            }
        }

        public int findFather(int a) {
            if (a == fatherMap[a]) return a;
            fatherMap[a] = findFather(fatherMap[a]);
            return fatherMap[a];
        }

        public void join(int a, int b) {
            int fa = findFather(a);
            int fb = findFather(b);
            if (fa == fb) return;
            fatherMap[fb] = fa;
        }

        public boolean isSame(int a, int b) {
            int fa = findFather(a);
            int fb = findFather(b);
            return fa == fb;
        }
    }
}


