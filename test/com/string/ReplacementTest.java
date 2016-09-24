package com.string;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by major on 16/9/22.
 */
public class ReplacementTest {
    Replacement r = new Replacement();
    @Test
    public void replaceSpace() throws Exception {
        String s = "Mr John Smith";
        Assert.assertEquals("Mr%20John%20Smith", r.replaceSpace(s, s.length()));
        s = "Hello  World";
        Assert.assertEquals("Hello%20%20World",r.replaceSpace(s, s.length()));
    }

}