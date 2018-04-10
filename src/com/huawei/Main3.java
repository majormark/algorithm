package com.huawei;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1Str = sc.nextLine();
        String num2Str = sc.nextLine();

        char[] num1Arr = num1Str.toCharArray();
        char[] num2Arr = num2Str.toCharArray();
        int l = num1Arr.length;
        int r = num2Arr.length;
        num1Str = null;
        num2Str = null;
        int[] num = new int[l+r];
        for(int i=0;i<l;i++) {
            int n1=num1Arr[l-1-i]-'0';
            int cache=0;
            for(int j=0;j<r;j++) {
                int n2=num2Arr[r-1-j]-'0';
                cache=cache+num[i+j]+n1*n2;
                num[i+j]=cache%10;
                cache/=10;
            }

            num[i+r]=cache;
        }

        int i=l+r-1;
        while(i>0&&num[i]==0){
            i--;
        }
        StringBuilder result = new StringBuilder();
        while(i>=0) {
            result.append(num[i--]);
        }
        System.out.println(result.toString());
    }


}
