package com.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by major on 16/9/5.
 */
public class TransformTest {
    Transform transform = new Transform();

    @Test
    public void testChkTransform() {
        String a = "abc";
        String b = "bac";
        Assert.assertEquals(true, transform.chkTransform(a, a.length(), b, b.length()));
    }

    @Test
    public void testChkTransform2() {
        String a = "123";
        String b = "2113";
        Assert.assertEquals(false, transform.chkTransform(a, a.length(), b, b.length()));
    }
}
