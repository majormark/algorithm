package com.sortingSpecial;

/**
 * 有两个从小到大排序以后的数组A和B，其中A的末端有足够的缓冲空容纳B。请编写一个方法，将B合并入A并排序。
 * 给定两个有序int数组A和B，A中的缓冲空用0填充，同时给定A和B的真实大小int n和int m，请返回合并后的数组。
 */
public class Merge {
    public int[] mergeAB(int[] A, int[] B, int n, int m) {
        int index1 = n - 1;
        int index2 = m - 1;
        int pos = n + m - 1;
        while (index2 >= 0) {
            if(index1 < 0) {
                A[pos--] = B[index2--];
            }
            else if(B[index2] >= A[index1]) {
                A[pos--] = B[index2--];
            } else {
                A[pos--] = A[index1--];
            }
        }
        return A;
    }

}
