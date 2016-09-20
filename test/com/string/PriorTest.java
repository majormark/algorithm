package com.string;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by major on 16/9/20.
 */
public class PriorTest {
    Prior p = new Prior();

    @Test
    public void findSmallest() throws Exception {
        String[] strs = {"b","ba"};
        String result = p.findSmallest(strs, strs.length);
        System.out.println(result);
    }

}