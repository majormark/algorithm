package com.sortingSpecial;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by major on 16/6/14.
 */
public class GapTest {
    Gap g;
    @Before
    public void setUp() throws Exception {
        g = new Gap();
    }

    @Test
    public void maxGap() throws Exception {
        int[] a = {1, 2, 5, 4, 6};
        int r = g.maxGap(a, a.length);
        System.out.println(r);
    }

}