package com.jingdong;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextLong();

        }


        for (int i=0;i<n;i++) {
            if (nums[i] % 2 == 1) {
                System.out.println("No");
            } else {
                for (long y = 2; y < nums[i]; y+=2) {
                    long x = nums[i] / y;
                    long remain = nums[i] % y;
                    if (remain == 0 && x % 2 == 1) {
                        System.out.println(x + " " + y);
                        break;
                    }
                }
            }


        }
    }
}
