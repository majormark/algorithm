package com.string;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by major on 16/9/24.
 */
public class ParenthesisTest {
    Parenthesis p = new Parenthesis();
    @Test
    public void chkParenthesis() throws Exception {
        String s = "()a()()";
        Assert.assertEquals(false, p.chkParenthesis(s, s.length()));

        s = "(()())";
        Assert.assertEquals(true, p.chkParenthesis(s, s.length()));

        s = "()(()()";
        Assert.assertEquals(false, p.chkParenthesis(s, s.length()));
    }

}