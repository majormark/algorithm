package com.stackAndQueue;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

import static org.junit.Assert.*;

/**
 * Created by major on 16/10/2.
 */
public class StackReverseTest {
    StackReverse reverse = new StackReverse();
    @Test
    public void reverseStack() throws Exception {
        int[] a = {4, 3, 2, 1};
        System.out.println(Arrays.toString(reverse.reverseStack(a, a.length)));
    }

    @Test
    public void get() throws Exception {
        Stack<Integer> stack = new Stack();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        Assert.assertEquals(3, reverse.get(stack));
    }

}