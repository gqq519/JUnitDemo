package com.feicuiedu.junitdemo;

import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by gqq on 2016/12/28.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {

    /**
     * 测试类里面需要处理的
     * 1. 创建的这个是做运行到设备上的测试，JUnit4的测试类，所以在测试运行时需要指明运行环境
     *      方式：测试类的上方，使用@RunWith(AndroidJunit4.class)
     * 2. 指明运行的Activity是谁？ @Rule
     *      ActivityTestRule<MainActivity>
     *      指定我们测试的是谁，规定测试的类
     */
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void onClick() throws Exception {
        /**
         * 测试登录页面功能
         * 1. 找到用户名的控件，给他输入用户名
         * 2. 找到密码的控件，给他输入密码
         * 3. 找到登录的按钮，给按钮设置一个点击事件
         */

        /**
         * Espresso：注意：我们有时候会给很长睡眠时间等待效果
         * 1. 匹配视图：onView()方法去找视图，通过什么条件找？
         *              withId(R.id.button):通过控件的Id去找到视图
         *              withText("登录"):通过控件的文本信息找到视图
         * 2. 设置操作：输入信息、点击事件、滑动等。。。。
         *        perform():通过perform()设置操作，在方法参数里面设置
         *           操作：
         *           typeText()：给控件输入文本信息
         *           click():给控件设置点击事件
         *           clearText():清空某一控件的文本
         *           closeSoftKeyboard():关闭软键盘
         *           longClick():长按
         *           pressBack():按下back键
         *           scrollTo()：滑动
         */

        Thread.sleep(3000);

        // 找到用户名的控件，给他输入用户名
        onView(withId(R.id.etUsername)).perform(typeText("123456"),closeSoftKeyboard());

        // 找到密码的控件，给他输入密码
        onView(withId(R.id.etPassword)).perform(typeText("123456"),closeSoftKeyboard());

        // 找到登录的按钮，给按钮设置一个点击事件
        onView(withId(R.id.btnLogin)).perform(click());

        Thread.sleep(3000);
    }
}