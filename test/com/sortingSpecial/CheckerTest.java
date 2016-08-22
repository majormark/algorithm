package com.sortingSpecial;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by major on 16/6/1.
 */
public class CheckerTest {
    Checker c;
    @Before
    public void setUp() throws Exception {
         c = new Checker();
    }

    @Test
    public void checkDuplicate() throws Exception {
        int[] a = {1, 2, 3, 4, 5, 5, 6};

        System.out.println(c.checkDuplicate(a, a.length));
    }

}