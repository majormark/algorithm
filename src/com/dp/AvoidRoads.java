package com.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * question: https://community.topcoder.com/stat?c=problem_statement&pm=1889&rd=4709
 *
 *
 */
public class AvoidRoads {

    Set<String> badSet = new HashSet<>();
    public long numWays(int width, int height, String[] bad) {
        long[][] pathNum = new long[width + 1][height + 1];

        for (String b : bad) {
            badSet.add(b);
        }
        pathNum[0][0] = 1;
        for (int i=0;i<=width;i++) {


            for (int j=0;j<=height;j++) {

                if (i > 0 && !isBad(i-1, j, i, j) && !isBad(i, j, i-1, j)) {
                    pathNum[i][j] += pathNum[i-1][j];
                }
                if (j > 0 && !isBad(i, j-1, i, j) && !isBad(i, j, i, j-1)) {
                    pathNum[i][j] += pathNum[i][j-1];
                }
            }
        }
        return pathNum[width][height];
    }

    public boolean isBad(int x1, int y1, int x2, int y2) {
        StringBuilder builder = new StringBuilder();
        builder.append(x1).append(" ").append(y1).append(" ").append(x2).append(" ").append(y2);
        return badSet.contains(builder.toString());
    }

    public static void main(String[] args) {
        AvoidRoads avoidRoads = new AvoidRoads();
        String[] bad = {"0 0 0 1","6 6 5 6"};
        System.out.println(avoidRoads.numWays(6, 6, bad));
    }
}
