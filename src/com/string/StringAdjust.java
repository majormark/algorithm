package com.string;

public class StringAdjust {
    public void replace(char[] chas) {
        if (chas == null || chas.length == 0) {
            return;
        }
        int num = 0;
        int len = 0;
        for (len = 0; len < chas.length && chas[len] != 0; len++) {
            if (chas[len] == ' ') num++;
        }
        int n = len + num * 2 - 1;
        for (int i=len-1;i>=0;i--) {
            if (chas[i] != ' ') {
                chas[n--] = chas[i];
            } else {
                chas[n--] = '0';
                chas[n--] = '2';
                chas[n--] = '%';
            }
        }
    }

    public void modify(char[] chas) {
        if (chas == null || chas.length == 0) {
            return;
        }
        int j = chas.length - 1;
        for(int i=chas.length - 1;i >= 0;i--) {
            if (chas[i] != '*') {
                chas[j--] = chas[i];
            }
        }
        while (j >= 0) {
            chas[j--] = '*';
        }
    }
}
