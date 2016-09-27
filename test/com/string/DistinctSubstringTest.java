package com.string;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by major on 16/9/26.
 */
public class DistinctSubstringTest {
    DistinctSubstring ds = new DistinctSubstring();
    @Test
    public void longestSubstring() throws Exception {
        String str = "abcadeffghijkmnf";
        //Assert.assertEquals(7, ds.longestSubstring(str, str.length()));
        str = "kojypxtmcheuvhpkqapldlkxkdbbouclkqwpnivxquwimbexyuqlipqpn" +
                "laklsqjnhcqspegqswpwinmvaokwbzylyrctfiscjuweakmmiaqsuanrfxhaf" +
                "feuaauafqkeksjxgdpspkzzzsawuyvrdbgdqhrnkspldkkqfmlsofadojwfdikwpzs" +
                "afacxoktpxkzmzzihljiqlsnbygkstydeflbgjrzrtxryfcntduaadqyzxmsrrxqbgldcvmtmqwyqgjtda";
        Assert.assertEquals(13, ds.longestSubstring(str, str.length()));
    }

}