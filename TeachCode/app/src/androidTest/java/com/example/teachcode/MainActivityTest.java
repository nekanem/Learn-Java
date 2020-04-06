package com.example.teachcode;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);



    //tests basic functioning of buttons
    @Test
    public void test() {
        Espresso.onView(withId(R.id.logoutBtn)).perform(click());
        //assertEquals(, appContext.getPackageName());
    }

    @Test
    public void test1() {
        Espresso.onView(withId(R.id.lessonOne)).perform(click());
    }

    @Test
    public void test2() {
        Espresso.onView(withId(R.id.lessonTwo)).perform(click());
    }
    @Test
    public void test3() {
        Espresso.onView(withId(R.id.lessonThree)).perform(click());
    }

    @Test
    public void test4() {
        Espresso.onView(withId(R.id.lessonFour)).perform(click());
    }
    @Test
    public void test5() {
        Espresso.onView(withId(R.id.lessonFive)).perform(click());
    }
    @Test
    public void test6() {
        Espresso.onView(withId(R.id.Quiz)).perform(click());
    }



}
