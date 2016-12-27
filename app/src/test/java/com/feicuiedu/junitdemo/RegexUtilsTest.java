package com.feicuiedu.junitdemo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gqq on 2016/12/27.
 */

// 测试正则表达式的一个测试类
public class RegexUtilsTest {

    private RegexUtils mRegexUtils;

    @Before
    public void setUp() throws Exception {
        mRegexUtils = new RegexUtils();
    }

    @Test
    public void verifyUsername() throws Exception {
        int verifyUsername = mRegexUtils.verifyUsername("123");
        assertEquals(1,verifyUsername);
    }

    @Test
    public void verifyUsernameUnUse() throws Exception {
        int verifyUsername = mRegexUtils.verifyUsername("123###");
        assertEquals(2,verifyUsername);
    }
    @Test
    public void verifyUsernameZh() throws Exception {
        int verifyUsername = mRegexUtils.verifyUsername("123ab哈哈");
        assertEquals(0,verifyUsername);
    }

    @Test
    public void verifyPassword() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

}