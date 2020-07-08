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
public class TeacherLoginTest {
    @Rule
    public ActivityTestRule<TeacherLogin> mActivityRule = new ActivityTestRule<>(TeacherLogin.class);


    //tests basic functioning of buttons
    @Test
    public void test() {
        Espresso.onView(withId(R.id.loginTeacherBtn)).perform(click());
        //Espresso.onView(withId(R.id.createUserLogText)).perform(click());
    }

    //tests create new account button
    @Test
    public void test1() {
        Espresso.onView(withId(R.id.createUserLogTeacherText)).perform(click());
        //Espresso.onView(withId(R.id.createUserLogText)).perform(click());
    }

    //tests create new account button
    @Test
    public void test2() {
        Espresso.onView(withId(R.id.forgetPasswordTeacher)).perform(click());
        //Espresso.onView(withId(R.id.createUserLogText)).perform(click());
    }

    //tests login as student student button
    @Test
    public void test3() {
        Espresso.onView(withId(R.id.studentLogSignIn)).perform(click());
        //Espresso.onView(withId(R.id.createUserLogText)).perform(click());
    }

    //testing unregistered teacher email
    @Test
    public void test4() throws InterruptedException {
        Espresso.onView(withId(R.id.emailLogTeacherText)).perform(typeText("donotregiesterme@gmail.com"));
        Espresso.onView(withId(R.id.passwordLogTeacherText)).perform(typeText("qwerty"));
        Espresso.onView(withId(R.id.passwordLogTeacherText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.loginTeacherBtn)).perform(click());
        Espresso.onView(withText("Error. Log in failed.There is no user record corresponding to this identifier. The user may have been deleted.")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

    //testing registered teacher email
    @Test
    public void test5() throws InterruptedException {
        Espresso.onView(withId(R.id.emailLogTeacherText)).perform(typeText("paulsing@gmail.com"));
        Espresso.onView(withId(R.id.passwordLogTeacherText)).perform(typeText("qwerty"));
        Espresso.onView(withId(R.id.passwordLogTeacherText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.loginTeacherBtn)).perform(click());
        Espresso.onView(withText("Log in successfully as a teacher.")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

    //testing empty val
    @Test
    public void test7() throws InterruptedException {
        Espresso.onView(withId(R.id.emailLogTeacherText)).perform(typeText(""));
        Espresso.onView(withId(R.id.passwordLogTeacherText)).perform(typeText(""));
        Espresso.onView(withId(R.id.passwordLogTeacherText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.loginTeacherBtn)).perform(click());
        //Espresso.onView(withText("Log in successfully as a teacher.")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

    //testing email with no password
    @Test
    public void test8() throws InterruptedException {
        Espresso.onView(withId(R.id.emailLogTeacherText)).perform(typeText("paulsing@gmail.com"));
        Espresso.onView(withId(R.id.passwordLogTeacherText)).perform(typeText(""));
    }

    //testing passowrd with no email
    @Test
    public void test9() throws InterruptedException {
        Espresso.onView(withId(R.id.emailLogTeacherText)).perform(typeText(""));
        Espresso.onView(withId(R.id.passwordLogTeacherText)).perform(typeText("qwerty"));
    }


    //testing registered teacher email with invalid password
    @Test
    public void test10() throws InterruptedException {
        Espresso.onView(withId(R.id.emailLogTeacherText)).perform(typeText("paulsing@gmail.com"));
        Espresso.onView(withId(R.id.passwordLogTeacherText)).perform(typeText("qwertyyyyyyy"));
        Espresso.onView(withId(R.id.passwordLogTeacherText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.loginTeacherBtn)).perform(click());
        Espresso.onView(withText("Error. Log in failed.The password is invalid or the user does not have a password.")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }







}