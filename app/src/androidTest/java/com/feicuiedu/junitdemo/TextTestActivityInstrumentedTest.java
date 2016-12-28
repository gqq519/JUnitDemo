package com.feicuiedu.junitdemo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Created by gqq on 2016/12/28.
 */
@RunWith(AndroidJUnit4.class)
public class TextTestActivityInstrumentedTest {

    private String STRING_TO_BE_TYPED = "Android";

    @Rule
    public ActivityTestRule<TextTestActivity> mActivityTestRule = new ActivityTestRule<TextTestActivity>(TextTestActivity.class);

    @Test
    public void onClick() throws Exception {

        // 1. 通过ID找到控件,给EditText输入一个字符串
        onView(withId(R.id.etInput)).perform(typeText(STRING_TO_BE_TYPED));

        Thread.sleep(3000);

        // 2. 通过Text找到Button,给Button设置点击事件
        onView(withText("问好")).perform(click());

        Thread.sleep(3000);

        // 3. 检测TextView展示的文本是不是我们期望的，是不是匹配的：check()检测，matches(withText(text))是不是匹配这个文本
        // text是我们期望的文本结果
        String text = "Hello, "+STRING_TO_BE_TYPED+"!";
        onView(withId(R.id.tvShow)).check(matches(withText(text)));
    }
}