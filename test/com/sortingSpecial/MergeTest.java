package com.sortingSpecial;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by major on 16/6/2.
 */
public class MergeTest {
    Merge m;
    @Before
    public void setUp() throws Exception {
        m = new Merge();
    }

    @Test
    public void mergeAB() throws Exception {
        int[] a = {2, 4, 6, 0, 0, 0};
        int[] b = {1, 3, 5};
        int[] result = m.mergeAB(a, b, a.length - b.length, b.length);
        System.out.println(Arrays.toString(result));
    }

}