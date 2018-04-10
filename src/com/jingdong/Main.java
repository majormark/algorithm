package com.jingdong;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);


        String str = in.nextLine();
        String strRev = new StringBuilder(str).reverse().toString();

        int len=str.length();
        int[][] temp = new int[len][len];
        char[] strArr = str.toCharArray();
        char[] strRevArr = strRev.toCharArray();
        strRev = null;
        str = null;
        for(int i=0;i<len;++i)
        {
            for(int j=0;j<len;++j)
            {
                if(strArr[i]==strRevArr[j])
                    temp[i+1][j+1]=temp[i][j]+1;
                else temp[i+1][j+1]=temp[i][j+1] > temp[i+1][j] ? temp[i][j+1] : temp[i+1][j];
            }
        }

    }


}
