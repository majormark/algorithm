package com.string;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by major on 16/9/19.
 */
public class TranslationTest {
    Translation t = new Translation();

    @Test
    public void stringTranslation() throws Exception {
        String str = "ABCDE";
        String result = t.stringTranslation(str, str.length(), 3);
        Assert.assertEquals("DEABC", result);
    }

}