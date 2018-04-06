package com.dp;

import java.util.Arrays;

/**
 * Created by major on 2018/3/22.
 */
public class CoinTest {


    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        int n = 11;
        int[] numOfCoin = new int[n];
        numOfCoin[0] = 0;
        for (int i=1;i<n;i++) {
            numOfCoin[i] = Integer.MAX_VALUE;
            for (int j=0;j<coins.length;j++) {
                if (coins[j] <= i && numOfCoin[i - coins[j]] + 1 < numOfCoin[i]) {
                    numOfCoin[i] = numOfCoin[i - coins[j]] + 1;
                }
            }
        }

        System.out.println(Arrays.toString(numOfCoin));
    }
}
