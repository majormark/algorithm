package com.string;

/**
 * 翻转字符串 pg 262
 * 逆序单词
 */
public class RotationWord {
    public void rotateWord(char[] chas) {

        reverse(chas, 0, chas.length - 1);
        int l = 0;
        int r = 0;
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] == ' ' || i == chas.length - 1) {
                if (i == chas.length - 1) r = i;
                reverse(chas, l, r);
                l = i + 1;
            } else {
                r = i;
            }
        }
    }

    public void reverse(char[] chas, int i, int j) {
        if (i > j) {
            return;
        }
        while (i <= j) {
            char tmp = chas[i];
            chas[i] = chas[j];
            chas[j] = tmp;
            i++;
            j--;
        }
    }
}
