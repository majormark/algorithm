package com.dp.bagProblem.complete;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int j = 1; j < dp.length; j++) {
            for (int i = 0; i < j; i++) {
                String sub = s.substring(i, j);
                if (set.contains(sub) && dp[i]) {
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
