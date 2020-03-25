package com.example.teachcode;

import android.content.Intent;
import android.os.Looper;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RegisterTest extends Register {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    private String userName = "test@gmail.com";
    private String passWord = "abcd";
    private String phoneNum = "7571234565";


    @Before
    public void setUp() throws Exception {
        Looper.prepare();
    }


    private void launchActivityWithIntent() {
        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);
    }


    @Test
    public void test() {
        Looper.prepare();
        launchActivityWithIntent();
        Espresso.onView(withId(R.id.registerBtn)).perform(click());
    }


    @Test
    public void test2() {
        Looper.prepare();
        launchActivityWithIntent();
        Espresso.onView(withId(R.id.fullNameRegEditText)).perform(typeText("Jimmy Johnson"));
        //test 2 - Empty String Val
        Espresso.onView(withId(R.id.fullNameRegEditText)).perform(typeText(" "));
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(typeText(" "));
        Espresso.onView(withId(R.id.phoneRegEditText)).perform(typeText(" "));
    }


    @Test
    public void test3() {
        Looper.prepare();
        launchActivityWithIntent();
        //test 3 - correct Val
        Espresso.onView(withId(R.id.fullNameRegEditText)).perform(typeText("Jimmy Johnson"));
        Espresso.onView(withId(R.id.emailRegEditText)).perform(typeText("jimmyjohnson@gmail.com"));
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(typeText("jimmyjohnjohnson"));
        Espresso.onView(withId(R.id.phoneRegEditText)).perform(typeText("7571234565"));
    }


    @Test
    public void test4() {
        Looper.prepare();
        launchActivityWithIntent();
        //test 4 - invalid email input
        Espresso.onView(withId(R.id.emailRegEditText)).perform(typeText("jimmyjohnsongmail.com"));
        Espresso.onView(withId(R.id.emailRegEditText)).perform(typeText("jimmyjohnson@gmailcom"));
        Espresso.onView(withId(R.id.emailRegEditText)).perform(typeText("jimmyjohnson@com"));
        Espresso.onView(withId(R.id.emailRegEditText)).perform(typeText("gmail.com"));
        Espresso.onView(withId(R.id.emailRegEditText)).perform(typeText("jimmyjohnson@gmail"));
        Espresso.onView(withId(R.id.emailRegEditText)).perform(typeText("@gmail.com"));
    }


    @Test
    public void test5() {
        Looper.prepare();
        launchActivityWithIntent();
        Espresso.onView(withId(R.id.registerBtn)).perform(click());

    }


    @Test
    public void test6() {
        Looper.prepare();
        launchActivityWithIntent();

        //test 6 - valid email
        Espresso.onView(withId(R.id.emailRegEditText)).perform(typeText("jimmyjohnsongmail.com"));
        Espresso.onView(withId(R.id.emailRegEditText)).perform(typeText("jimmyjohnson@gmailcom"));
    }


    @Test
    public void test7() {
        Looper.prepare();
        launchActivityWithIntent();

        //test 7 - existing email
        Espresso.onView(withId(R.id.emailRegEditText)).perform(typeText("teachcode.team@gmail.com"));
    }


    @Test
    public void test8() {
        Looper.prepare();
        launchActivityWithIntent();

        //test 8 - phone number - non numerical vals
        Espresso.onView(withId(R.id.phoneRegEditText)).perform(typeText("dflsgkjjh4"));


    }


    @Test
    public void test9() {
        Looper.prepare();
        launchActivityWithIntent();
        //test 9 - correct phone number
        Espresso.onView(withId(R.id.phoneRegEditText)).perform(typeText("7571234565"));
    }


    @Test
    public void test10() {
        Looper.prepare();
        launchActivityWithIntent();
        //test 10 - phone number with area code
        Espresso.onView(withId(R.id.phoneRegEditText)).perform(typeText("17571234567"));
    }


    @Test
    public void test11() {
        Looper.prepare();
        launchActivityWithIntent();
        //test 11 - too long password
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(typeText("ljkafdhlsdkjhalsdkfhlkfjdhlkjhlskdjhflakjfhladsoriwueghlkfjglksjehglkfjhldg"));
    }


    @Test
    public void test12() {
        //test 12 - short password
        Looper.prepare();
        launchActivityWithIntent();
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(typeText("n"));
    }


    @Test
    public void test13() {
        Looper.prepare();
        launchActivityWithIntent();
        //test 13 - without numbers
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(typeText("jimmyjohnjohnson"));
    }


    @Test
    public void test14() {
        Looper.prepare();
        launchActivityWithIntent();
        //test 14 - without special characters
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(typeText("jimmyjohnjohnson"));
    }


    @Test
    public void test15() {
        Looper.prepare();
        launchActivityWithIntent();
        //test 15 - entering alphanumerica char betwwen 8 - 16 char and special char
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(typeText("jimmyjoh@njohnson"));
    }


    @Test
    public void test16() {
        Looper.prepare();
        launchActivityWithIntent();
        //test 16 - test tab button - should be able to hit tab to skip between lines
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(typeText("jimmyjoh@njohnson"));
    }


    @Test
    public void test17() {
        Looper.prepare();
        launchActivityWithIntent();
        //test 17 - test enter button
        Espresso.onView(withId(R.id.registerBtn)).perform(click());
    }


    @After
    public void tearDown() throws Exception {
    }
}