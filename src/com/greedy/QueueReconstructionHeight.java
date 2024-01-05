package com.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

// 406. Queue Reconstruction by Height
public class QueueReconstructionHeight {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, ((o1, o2) -> {
            if (o1[0] == o2[0])return o1[1]-o2[1];
            return o2[0]-o1[0];
        }));

        LinkedList<int[]> res = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            res.add(people[i][1], people[i]);

        }

        return res.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        new QueueReconstructionHeight().reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
    }
}
