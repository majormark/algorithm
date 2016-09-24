package com.string;

import java.util.Arrays;

/**
 * Created by major on 16/9/22.
 */
public class Replacement {
    public String replaceSpace(String iniString, int length) {
        char[] arr = iniString.toCharArray();
        int count = 0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == ' ') {
                count++;
            }
        }
        char[] newArr = new char[length + count * 2];
        int index = newArr.length - 1;
        for(int i=length-1;i>=0;i--) {
            if(arr[i] == ' ') {
                newArr[index--] = '0';
                newArr[index--] = '2';
                newArr[index--] = '%';
            } else {
                newArr[index--] = arr[i];
            }
        }
        return String.valueOf(newArr);
    }
}
