package com.dp.match;

/**
 * 通配符匹配 lc 44
 */
public class WildcardMatching {
    // DP
    public boolean isMatch(String s, String p) {
        char[] chs = s.toCharArray();
        char[] chp = p.toCharArray();
        int row = chs.length;
        int col = chp.length;
        boolean[][] m = new boolean[row + 1][col + 1];
        m[0][0] = true;
        for (int j = 1; j <= col; j++) {
            if (chp[j - 1] != '*') break;
            m[0][j] = true;
        }
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                if (chp[j - 1] == '*') {
                    m[i][j] = m[i - 1][j] || m[i][j - 1];
                } else if (chp[j - 1] == chs[i - 1] || chp[j - 1] == '?') {
                    m[i][j] = m[i - 1][j - 1];
                }
            }
        }
        return m[row][col];
    }
    public static void main(String[] args) {
        System.out.println(new WildcardMatching().isMatch("cccaaa", "**"));
    }


}
