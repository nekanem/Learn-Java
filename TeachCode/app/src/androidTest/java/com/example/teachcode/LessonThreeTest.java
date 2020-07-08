package com.example.teachcode;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LessonThreeTest {

    @Rule
    public ActivityTestRule<LessonThree> mActivityRule = new ActivityTestRule<>(LessonThree.class);



    //tests basic functioning of buttons
    @Test
    public void test() {
        Espresso.onView(withId(R.id.btnSub)).perform(click());

    }

    //tests toast message of blank answer
    @Test
    public void test1() {
        Espresso.onView(withId(R.id.btnSub)).perform(click());
        Espresso.onView(withText("Incorrect, Try Again")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

    //tests toast message of incorrect answer
    @Test
    public void test2() {
        Espresso.onView(withId(R.id.editText1)).perform(typeText("incorrect answer"));
        Espresso.onView(withId(R.id.editText1)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.btnSub)).perform(click());
        Espresso.onView(withText("Incorrect, Try Again")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

    //tests toast message of empty val
    @Test
    public void test3() {
        Espresso.onView(withId(R.id.editText1)).perform(typeText(" "));
        Espresso.onView(withId(R.id.editText1)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.btnSub)).perform(click());
        Espresso.onView(withText("Incorrect, Try Again")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }



    //tests toast message of correct answer
    @Test
    public void test4() {
        Espresso.onView(withId(R.id.editText1)).perform(typeText("System.out.println(x == 10);"));
        Espresso.onView(withId(R.id.editText1)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.btnSub)).perform(click());
        Espresso.onView(withText("Correct!")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }




    @Test
    public void onCreate() {
    }

    @Test
    public void onCreateOptionsMenu() {
    }

    @Test
    public void onOptionsItemSelected() {
    }
}