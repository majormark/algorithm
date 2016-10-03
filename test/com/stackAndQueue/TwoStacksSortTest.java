package com.stackAndQueue;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by major on 16/10/3.
 */
public class TwoStacksSortTest {
    TwoStacksSort twoStacksSort = new TwoStacksSort();
    @Test
    public void test() {
        int[] numbers = {1, 2, 3, 4, 5};
        ArrayList<Integer> result = twoStacksSort.twoStacksSort(numbers);
        System.out.println(result.toString());
    }

}