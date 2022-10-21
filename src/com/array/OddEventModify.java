package com.array;

/**
 * 奇数下标都是奇数或者偶数下标都是偶数
 */
public class OddEventModify {
    public void modify(int[] arr) {
        int even = 0;
        int odd = 1;
        int last = arr.length - 1;
        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[last] % 2 == 0) {
                tmp = arr[even];
                arr[even] = arr[last];
                arr[last] = tmp;
                even += 2;
            } else {
                tmp = arr[odd];
                arr[odd] = arr[last];
                arr[last] = tmp;
                odd += 2;
            }
        }
    }
}
