package com.search.graph;

import java.util.*;

//207. Course Schedule
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            if (map.containsKey(prerequisites[i][1])) {
                List<Integer> list = map.get(prerequisites[i][1]);
                list.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], list);
            } else {
                List<Integer> list = new LinkedList<>();
                list.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], list);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                count++;
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                if (!map.containsKey(num)) continue;
                for (Integer pos : map.get(num)) {
                    inDegree[pos]--;
                    if (inDegree[pos] == 0) {
                        queue.offer(pos);
                        count++;
                    }
                }
            }
        }
        return count == numCourses;
    }
}
