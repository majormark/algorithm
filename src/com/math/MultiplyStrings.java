package com.math;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        if (ch1.length == 0 || ch2.length == 0) return "";
        int m = ch1.length, n = ch2.length;
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int a = ch1[i] - '0';
            for (int j = n - 1; j >= 0; j--) {
                int b = ch2[j] - '0';
                int sum = a * b + res[i + j + 1];
                res[i + j + 1] = sum % 10;
                res[i + j] = sum / 10 + res[i + j];
            }
        }
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (b.length() == 0 && res[i] == 0) continue;
            b.append(res[i]);
        }
        return b.toString();
    }
}
