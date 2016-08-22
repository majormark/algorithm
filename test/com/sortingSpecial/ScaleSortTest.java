package com.sortingSpecial;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by major on 16/6/1.
 */
public class ScaleSortTest {
    ScaleSort ss;
    @Before
    public void setUp() throws Exception {
        ss = new ScaleSort();

    }

    @Test
    public void sortElement() throws Exception {
        int[] a = {2,1,4,3,6,5,8,7,10,9};
        int[] result = ss.sortElement(a, a.length, 2);
        System.out.println(Arrays.toString(result));
    }

}