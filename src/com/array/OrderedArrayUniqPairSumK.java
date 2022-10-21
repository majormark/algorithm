package com.array;

/**
 * 不重复打印排序数组中相加和未给定值的所有二元组和三元组
 */
public class OrderedArrayUniqPairSumK {
    public void printUniqPair(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {

            if (arr[l] + arr[r] == k) {
                if (l == 0 || arr[l - 1] != arr[l]) {
                    System.out.println(arr[l++] + "," + arr[r--]);
                }
            } else if (arr[l] + arr[r] > k) {
                r--;
            } else {
                l++;
            }

        }
    }

    public void printUniqTriad(int[] arr, int k) {
        for (int i = 0; i < arr.length - 2; i++) {
            if (i == 0 || arr[i - 1] != arr[i]) {
                printRest(arr, i, i + 1, arr.length - 1, k);
            }
        }
    }

    public void printRest(int[] arr, int s, int l, int r, int k) {
        while (l < r) {
            if (arr[l] + arr[r] == k) {
                if (l == s + 1 || arr[l - 1] != arr[l]) {
                    System.out.println(arr[s] + "," + arr[l++] + "," + arr[r--]);
                }
            } else if (arr[l] + arr[r] > k) {
                r--;
            } else {
                l++;
            }

        }
    }
}
