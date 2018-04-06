package com.binarySearch;

/**
 * Created by major on 2017/11/17.
 */

/**
 定义局部最小的概念。arr长度为1时，arr[0]是局部最小。arr的长度为N(N>1)时，如果arr[0]<arr[1]，那么arr[0]是局部最小；
 如果arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小；如果0<i<N-1，既有arr[i]<arr[i-1]又有arr[i]<arr[i+1]，那么arr[i]是局部最小。
 给定无序数组arr，已知arr中任意两个相邻的数都不相等，写一个函数，只需返回arr中任意一个局部最小出现的位置即可。
 */
public class LocalMin {

    public int getLessIndex(int[] arr) {

        if(arr.length == 0)
            return -1;
        if(arr.length == 1)
            return arr[0];
        return binarySearch(arr, 0, arr.length - 1);
    }

    public int binarySearch(int[] arr, int left, int right) {
        int index;
        int mid = left + (right - left) / 2;

        if(mid == 0 && arr[mid] < arr[mid + 1]) {
            return mid;
        }
        else if(mid == arr.length - 1 && arr[mid - 1] > arr[mid])
            return mid;
        else if(arr[mid - 1] > arr[mid] && arr[mid] < arr[mid + 1])
            return mid;
        index = binarySearch(arr, left, mid);
        if(index >= 0)
            return index;
        index = binarySearch(arr, mid + 1, right);
        if(index >= 0)
            return index;
        return  -1;
    }
    public static void main(String[] args) {

        int[] arr = {3,5,1,5,9,4,6,5,3,0,8,4,5,8,7,1,4,5,2,3,0,5,0,4};
        LocalMin localMin = new LocalMin();
        System.out.println(localMin.getLessIndex(arr));
    }
}
