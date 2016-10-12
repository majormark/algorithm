package com.stackAndQueue;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by major on 16/10/11.
 */
public class MaxTreeTest {
    MaxTree tree = new MaxTree();
    @Test
    public void buildMaxTree() throws Exception {
        int[] num = {3,1,4,2};
        System.out.println(Arrays.toString(tree.buildMaxTree(num, num.length)));

    }

}