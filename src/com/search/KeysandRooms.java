package com.search;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysandRooms {
    public boolean[] visit;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        visit = new boolean[n];
        bfs(rooms);
        for (boolean v : visit) {
            if (!v) return false;
        }
        return true;
    }

    public void bfs(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visit[0] = true;
        while (!queue.isEmpty()) {
            int r = queue.poll();
            for (Integer nr : rooms.get(r)) {
                if (visit[nr]) continue;
                visit[nr] = true;
                queue.offer(nr);
            }
        }
    }
}
