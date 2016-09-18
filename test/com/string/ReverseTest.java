package com.string;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by major on 16/9/18.
 */
public class ReverseTest {
    Reverse reverse = new Reverse();

    @Test
    public void reverseSentence() throws Exception {
        String str = "dog loves  pig ";
        String result = reverse.reverseSentence(str, str.length());
        Assert.assertEquals(" pig  loves dog", result);
    }

}