package com.feicuiedu.junitdemo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by gqq on 2016/12/28.
 */
@RunWith(AndroidJUnit4.class)
public class ListViewTestActivityInstrumentedTest {

    @Rule
    public ActivityTestRule<ListViewTestActivity> mActivityTestRule = new ActivityTestRule<ListViewTestActivity>(ListViewTestActivity.class);

    @Test
    public void onClick() throws Exception {
        /**
         * 1. 找到按钮，点击(代码里面处理的数据加载)
         * 2. 找到ListView，点击某一条
         */
        onView(withId(R.id.btnLoad)).perform(click());

        Thread.sleep(10*1000);

        // 在ListView里面找到以“日本”开头的数据，设置点击事件
        onData(Matchers.startsWith("日本")).inAdapterView(withId(R.id.lvNews)).perform(click());

        Thread.sleep(2000);
    }
}