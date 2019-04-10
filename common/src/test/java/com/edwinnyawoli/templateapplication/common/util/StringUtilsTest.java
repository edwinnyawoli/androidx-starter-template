package com.edwinnyawoli.templateapplication.common.util;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class StringUtilsTest {

    @Test
    public void testSingleCharacterWordCapitalization() {
        String m = StringUtils.capitalize("m");
        Assert.assertEquals("M", m);
    }

    @Test
    public void testMultiCharacterWordCapitalization() {
        String m = StringUtils.capitalize("me");
        Assert.assertEquals("Me", m);
    }

}