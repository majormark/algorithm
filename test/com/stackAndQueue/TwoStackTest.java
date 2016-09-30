package com.stackAndQueue;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by major on 16/9/29.
 */
public class TwoStackTest {
    TwoStack twoStack = new TwoStack();
    @Test
    public void twoStack() throws Exception {
        int[] ope = {1,2,3,0,4,0};
        int[] result = twoStack.twoStack(ope, ope.length);
        System.out.println(Arrays.toString(result));
    }

}