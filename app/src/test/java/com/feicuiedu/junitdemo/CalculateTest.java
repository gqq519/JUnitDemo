package com.feicuiedu.junitdemo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gqq on 2016/12/27.
 */

// 创建的用于测试计算类的测试类
public class CalculateTest {

    private Calculate mCalculate;

    /**
     * 1. @Before：在执行测试代码之前会被执行：一般会去做一些类的初始化的工作等
     * 2. @After：在执行测试方法之后会被执行：一般进行资源的释放：对象置为空
     * 3. @Test: 表明他是一个要被测试的方法：测试用例
     * 4. @BeforeClass：只会被执行一次：用static修饰
     * 5. @AfterClass：只会被执行一次：用static修饰
     * 6. @Ignore:忽略
     *
     * 执行次序：
     * @BeforeClass --> @Before --> @Test --> @After --> @AfterClass
     */

    @BeforeClass
    public static void setCalculate(){

    }


    @Before
    public void setUp() throws Exception {
        mCalculate = new Calculate();
    }

    @After
    public void tearDown() throws Exception {
        mCalculate=null;
    }

    /**
     * 错误：
     * 1. 代码出现的问题：***Error
     * 2. 测试的问题：测试失败
     *
     * 断言：写在测试的方法里面的：帮我们验证我们测试结果的正确性。
     * 测试不是验证你写的是对的，而是验证你写的没有错。
     * 1.assertEquals()
     * 2.assertNotNull()
     */

    @Test
    public void sum() throws Exception {
        int sum = mCalculate.sum(2, 3);
        assertEquals(5,sum);
    }

    @Test
    public void sub() throws Exception {
        int sub = mCalculate.sub(3, 1);
        assertEquals(2,sub);
    }

    @Test
    public void mult() throws Exception {
        int mult = mCalculate.mult(1, 2);
        assertEquals(2,mult);
    }

    @Test
    public void div() throws Exception {
        int div = mCalculate.div(2, 1);
        assertEquals(2,div);
    }
}