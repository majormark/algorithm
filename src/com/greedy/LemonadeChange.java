package com.greedy;

// 860. Lemonade Change
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int[] money = new int[2];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                money[0]++;
            } else if (bills[i] == 10) {
                if (money[0] > 0) {
                    money[1]++;
                    money[0]--;
                } else {
                    return false;
                }
            } else {
                if (money[1] > 0 && money[0] > 0) {
                    money[1]--;
                    money[0]--;
                } else if (money[0] >= 3) {
                    money[0]-=3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
