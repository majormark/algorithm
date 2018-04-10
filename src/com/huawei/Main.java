package com.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        StringBuilder builder = new StringBuilder();

        int last=-1;
        int len = arr.length;
        char temp = ' ';
        while (len > 0) {
            for (int i=0;i<arr.length;i++) {
                if (arr[i] != '-') {
                    last = i;
                    temp = arr[i];
                    builder.append(arr[i]);
                    arr[i] = '-';
                    len--;
                    break;
                }
            }
            for (int i = last + 1; i < arr.length; i++) {

                if (arr[i] != '-') {
                    if (arr[i] != temp) {
                        builder.append(arr[i]);
                        temp = arr[i];
                        arr[i] = '-';
                        len--;
                    }
                }
            }
        }

        System.out.println(builder.toString());
    }
}
