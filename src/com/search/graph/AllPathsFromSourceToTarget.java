package com.search.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> res;
    public LinkedList<Integer> path;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        path.add(0);
        dfs(graph, 0);
        return res;
    }

    public void dfs(int[][] graph, int point) {
        if (point == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int p : graph[point]) {
            path.add(p);
            dfs(graph, p);
            path.removeLast();
        }
    }
}
