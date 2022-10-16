package com.string;

/**
 * 添加最少字符使字符串变成回文字符串 pg.269
 */
public class AddCharacterToPalindrome {

    public int[][] getDp(char[] ch) {
        int[][] dp = new int[ch.length][ch.length];
        for (int j = 1; j < ch.length; j++) {
            dp[j-1][j] = ch[j-1] == ch[j] ? 0 : 1;
            for (int i = j - 2; i >= 0; i--) {
                if (ch[i] == ch[j]){
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) + 1;
                }
            }
        }
        return dp;
    }

    public String getPalindrome1(String str) {
        char[] ch = str.toCharArray();
        int[][] dp = getDp(ch);
        char[] res = new char[ch.length + dp[0][ch.length-1]];
        int i = 0;
        int j = ch.length - 1;
        int idx = 0;
        int last = res.length - 1;
        while (i <= j) {
            if (ch[i] == ch[j]) {
                res[last - idx] = ch[i];
                res[idx--] = ch[i];
                i++;
                j--;
            } else {
                if (dp[i+1][j] < dp[i][j-1]) {
                    res[last - idx] = ch[i];
                    res[idx++] = ch[i];
                    i++;
                } else {
                    res[last - idx] = ch[j];
                    res[idx++] = ch[j];
                    j--;
                }
            }
        }
        return String.valueOf(res);
    }

    public String getPalindrome2(String str, String strlps) {

        char[] ch = str.toCharArray();
        char[] chLps = strlps.toCharArray();
        int n = ch.length;
        int m = chLps.length;
        char[] res = new char[2 * n - m];
        int lStart = -1;
        int rEnd = -1;
        int lPos = 0;
        int rPos = ch.length - 1;
        int left = 0;
        int right = chLps.length - 1;
        int resl = 0;
        int resr = res.length - 1;
        while (left <= right) {
            lStart = lPos;
            rEnd = rPos;
            while (ch[lPos] != chLps[left]) lPos++;
            while (ch[rPos] != chLps[left]) rPos--;

            set(res, resl, resr, ch, lStart, lPos, rPos, rEnd);
            resl += lPos - lStart + rEnd - rPos;
            resr -= lPos - lStart + rEnd - rPos;
            res[resl++] = ch[left++];
            res[resr--] = ch[right--];
        }
        return String.valueOf(res);
    }

    public void set(char[] res, int resl, int resr, char[] ch, int ls, int le, int rs, int re) {
        for (int i = ls;i<le;i++) {
            res[resl++] = ch[i];
            res[resr--] = ch[i];
        }
        for (int i = re;i>rs;i--) {
            res[resr--] = ch[i];
            res[resl++] = ch[i];
        }
    }
}
