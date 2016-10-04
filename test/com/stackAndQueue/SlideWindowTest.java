package com.stackAndQueue;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by major on 16/10/4.
 */
public class SlideWindowTest {
    SlideWindow slideWindow = new SlideWindow();
    @Test
    public void slide() throws Exception {
        int[] num = {4,3,5,4,3,3,6,7};
        System.out.println(Arrays.toString(slideWindow.slide(num, num.length, 3)));

    }

}