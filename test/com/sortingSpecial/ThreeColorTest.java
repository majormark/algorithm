package com.sortingSpecial;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by major on 16/6/3.
 */
public class ThreeColorTest {
    ThreeColor tc;
    @Before
    public void setUp() throws Exception {
        tc = new ThreeColor();
    }

    @Test
    public void sortThreeColor() throws Exception {
        int[] a = {0, 1, 1, 0, 2, 2};
        int[] re = tc.sortThreeColor(a, a.length);
        System.out.println(Arrays.toString(re));
    }

}