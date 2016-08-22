package com.sortingSpecial;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by major on 16/6/3.
 */
public class SubsequenceTest {
    Subsequence s;
    @Before
    public void setUp() throws Exception {
        s = new Subsequence();
    }

    @Test
    public void shortestSubsequence() {
        int[] a1 = {1, 4, 6, 5, 9, 10};
        int[] a2 = {1, 3 ,4, 5};
        int[] a3 = {4, 3, 2, 1};
        int[] a4 = {1, 2, 10, 1, 8, 9};
       // System.out.println(s.shortestSubsequence(a1, a1.length));
        //System.out.println(s.shortestSubsequence(a2, a2.length));
        System.out.println(s.shortestSubsequence(a2, a2.length));

    }
}