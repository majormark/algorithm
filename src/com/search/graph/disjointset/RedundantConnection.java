package com.search.graph.disjointset;

import java.util.LinkedList;

//684. Redundant Connection
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet set = new DisjointSet(n);
        for (int i = 0; i < edges.length; i++) {
            if (set.isSame(edges[i][0] - 1,edges[i][1] - 1)) return edges[i];
            set.union(edges[i][0] - 1, edges[i][1] - 1);
        }
        return new int[]{};
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
            int f = fatherMap[a];
            if (a == f) return a;
            fatherMap[a] = findFather(f);
            return fatherMap[a];
        }

        public void union(int a, int b) {
            int fa = findFather(a);
            int fb = findFather(b);
            if (fa == fb) return;
            fatherMap[fa] = fb;
        }

        public boolean isSame(int a, int b) {
            return findFather(a) == findFather(b);
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            inDegree[edge[1] - 1]++;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (inDegree[edges[i][1] - 1] == 2) {
                list.add(i);
            }
        }
        if (list.isEmpty()) {
            return getRemoveEdge(edges);
        } else {
            if (isTreeAfterRemoveEdge(edges, list.get(0))) return edges[list.get(0)];
             else return edges[list.get(1)];
        }
    }

    public boolean isTreeAfterRemoveEdge(int[][] edge, int i) {
        DisjointSet set = new DisjointSet(edge.length);
        for (int j = 0; j < edge.length; j++) {
            if (j == i) continue;
            if (set.isSame(edge[j][0] - 1, edge[j][1] - 1)) return false;
            set.union(edge[j][0] - 1, edge[j][1] - 1);
        }
        return true;
    }

    public int[] getRemoveEdge(int[][] edge) {
        DisjointSet set = new DisjointSet(edge.length);
        for (int j = 0; j < edge.length; j++) {
            if (set.isSame(edge[j][0] - 1, edge[j][1] - 1)) return edge[j];
            set.union(edge[j][0] - 1, edge[j][1] - 1);
        }
        return new int[]{};
    }
}
