package com.string;

import java.util.*;
/**
 * Created by major on 16/9/18.
 */

/**
 * 对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
 * 给定一个原字符串A和他的长度，请返回逆序后的字符串。
 *
 * 测试样例：
 *
 * "dog loves pig",13
 *
 * 返回："pig loves dog"
 *
 * 思路:设计一个让一个字符串所有字符逆序的函数
 * 先把整个字符串逆序,再把单个单词区域逆序回来
 *
 * 特殊情况,多个空格
 */

public class Reverse {
    public String reverseSentence(String A, int n) {
        char[] arr = A.toCharArray();
        reverse(arr, 0, arr.length - 1);

        int l = -1;
        int r = -1;
        for (int i=0;i<arr.length;i++) {

            if(arr[i] != ' ') {

                if(i == 0 || arr[i - 1] == ' ') {
                    l = i;
                }
                if(i == arr.length - 1 || arr[i + 1] == ' ') {
                    r = i;
                }

            }

            if(l != -1 && r != -1) {
                reverse(arr, l, r);
                l = -1;
                r = -1;
            }

        }
        return String.valueOf(arr);
    }

    public void reverse(char[] arr, int l, int r) {

        while (l < r) {
            swap(arr, l++, r--);
        }
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
