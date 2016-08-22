package com.sortingSpecial;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by major on 16/6/3.
 */
public class FinderTest {
    Finder f;
    @Before
    public void setUp() throws Exception {
        f = new Finder();
    }

    @Test
    public void findX() throws Exception {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        boolean re = f.findX(mat, mat.length, mat[0].length, 9);
        System.out.print(re);
    }

}