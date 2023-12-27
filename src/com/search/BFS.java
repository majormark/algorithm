package com.search;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    class Point {
        int x;
        int y;
        int step;

        public Point(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
    public int[] dx = new int[]{0, 1, 0, -1};
    public int[] dy = new int[]{1, 0, -1, 0};
    public int[][] v;
    public int[][] map;
    public int minStep(int startX, int startY, int endX, int endY) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(startX, startY, 0));

        while (!q.isEmpty()) {
            Point point = q.poll();
            if (point.x == endX && point.y == endY) { // BFS最先到达终点的就是最短路径
                return point.step;
            }
            for (int i = 0; i < dx.length; i++) {
                int tx = point.x + dx[i];
                int ty = point.y + dy[i];
                if (map[tx][ty] == 1 && v[tx][ty] == 0) {
                    v[tx][ty]=1;
                    q.offer(new Point(tx, ty, point.step + 1));
                }
            }
        }
        return 0;
    }


}
