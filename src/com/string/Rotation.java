package com.string;

/**
 * Created by major on 16/5/4.
 */
public class Rotation {

    public boolean chkRotation(String A, int lena, String B, int lenb) {
        // write code here
        if(lena != lenb)
            return false;
        String str = A + A;
        int i=0, j=0;
        char[] aArray = str.toCharArray();
        char[] bArray = B.toCharArray();
        int[] next = getNext(B);

        while(i < aArray.length && j < lenb) {
            if(j == -1 || aArray[i] == bArray[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if(j == lenb)
            return true;
        else
            return false;
    }

    public int[] getNext(String p) {
        int[] next = new int[p.length()];
        char[] pArray = p.toCharArray();
        next[0] = -1;
        int pLen = p.length();
        int k = -1;
        int j = 0;
        while(j < pLen - 1) {
            if(k == -1 || pArray[k] == pArray[j]) {
                ++k;
                ++j;
                next[j] = k;
            } else {
                k = next[k];
            }
        }

        return next;
    }
}
