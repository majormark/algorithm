package com.string;

/**
 * Z字形变换 lc 6
 */
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int group = numRows + (numRows - 2);
        char[] ch = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int mid = numRows - 1;
            int d = mid - i;
            while (mid - d < ch.length) {
                res.append(ch[mid - d]);
                if (mid + d >= ch.length) {
                    break;
                }
                if (mid + d != (mid - d + group) && d != 0) {
                    res.append(ch[mid + d]);
                }
                mid += group;
            }
        }
        return res.toString();
    }
    public static void main(String[] args) {
        System.out.println(new ZigzagConversion().convert("PAYPALISHIRING", 4));
    }
}
