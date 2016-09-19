package com.string;

/**
 * Created by major on 16/9/19.
 */

/**
 * 对于一个字符串，请设计一个算法，将字符串的长度为len的前缀平移到字符串的最后。
 * 给定一个字符串A和它的长度，同时给定len，请返回平移后的字符串。
 *
 * 要求 时间复杂度为O(N) 空间复杂度为O(1)
 * 测试样例：
 *
 * "ABCDE",5,3
 *
 * 返回："DEABC"
 *
 */

public class Translation {
    public String stringTranslation(String A, int n, int len) {

        if(len >= n)
            return A;
        char[] arr = A.toCharArray();
        reverse(arr, 0, len - 1);
        reverse(arr, len, n - 1);
        reverse(arr, 0, n - 1);
        return String.valueOf(arr);
    }

    public void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
