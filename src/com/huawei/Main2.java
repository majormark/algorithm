package com.huawei;

        import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = sc.nextInt();
        }

        int[] d = new int[n];
        for (int i=1;i<n;i++) {
            d[i] = Integer.MAX_VALUE;
            for (int j=0;j<i;j++) {
                if (j + num[j] >= i && d[j] + 1 < d[i]) {
                    d[i] = d[j] + 1;
                }
            }
        }
        System.out.println(d[n-1]);
    }
}
