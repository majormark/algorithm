package com.stackAndQueue;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by major on 16/9/27.
 */
public class StackWithMinTest {
    StackWithMin stack = new StackWithMin();
    @Test
    public void test() throws Exception {
        stack.push(3);
        stack.push(4);
        stack.push(1);
        stack.push(2);
        stack.push(0);
        stack.push(6);

        Assert.assertEquals(0, stack.min());
        stack.pop();
        stack.pop();
        Assert.assertEquals(1, stack.min());
    }

}