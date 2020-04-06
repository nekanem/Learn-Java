package com.example.teachcode;

import android.widget.Toast;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginTest {

    String registerToast =  "Verification link has been sent to your email.";



    @Rule
    public ActivityTestRule<Login> mActivityRule = new ActivityTestRule<>(Login.class);



    //tests basic functioning of buttons
    @Test
    public void test() {
        //Looper.prepare();
        // launchActivityWithIntent();
        Espresso.onView(withId(R.id.loginBtn)).perform(click());
        //Espresso.onView(withId(R.id.createUserLogText)).perform(click());
    }

    //testing unregistered student email
    @Test
    public void test1() throws InterruptedException {
        //Looper.prepare();
        // launchActivityWithIntent();
        Espresso.onView(withId(R.id.emailLogText)).perform(typeText("invalid@gmail.com"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(typeText("qwerty"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.loginBtn)).perform(click());

    }

    //testing unregistered teacher email
    @Test
    public void test2() {
        //Looper.prepare();
        // launchActivityWithIntent();
        Espresso.onView(withId(R.id.emailLogText)).perform(typeText("dummyemail@gmail.com"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(typeText("wwerftgy"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.loginBtn)).perform(click());


        //Assert.assertTrue();
    }



    //testing registered student email
    @Test
    public void test3() {
        //Looper.prepare();
        // launchActivityWithIntent();

        Espresso.onView(withId(R.id.emailLogText)).perform(typeText("paulsingh@gmail.com"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(typeText("qwerty"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.loginBtn)).perform(click());
    }


    //testing registered teacher email
    @Test
    public void test4() {
        //Looper.prepare();
        // launchActivityWithIntent();

        //  Espresso.onView(withId(R.id.emailLogText)).perform(typeText("dummyemail@gmail.com"));
        //  Espresso.onView(withId(R.id.passwordLogText)).perform(typeText("wwerftgy"))
        Espresso.onView(withId(R.id.passwordLogText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.loginBtn)).perform(click());
    }

    //testing email with invalid character(s)
    @Test
    public void test5() {
        //Looper.prepare();
        // launchActivityWithIntent();
        Espresso.onView(withId(R.id.emailLogText)).perform(typeText("dummyemail"));
        //  Espresso.onView(withId(R.id.passwordLogText)).perform(typeText("wwerftgy"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.loginBtn)).perform(click());
    }

    //testing password with invalid empty email credentials
    @Test
    public void test6() {
        //Looper.prepare();
        // launchActivityWithIntent();
        Espresso.onView(withId(R.id.emailLogText)).perform(typeText(""));
        // Espresso.onView(withId(R.id.passwordLogText)).perform(typeText(" "));
        Espresso.onView(withId(R.id.passwordLogText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.loginBtn)).perform(click());
    }

    //testing password with invalid password credentials
    @Test
    public void test7() {
        //Looper.prepare();
        // launchActivityWithIntent();
        //   Espresso.onView(withId(R.id.emailLogText)).perform(typeText("dummyemail@gmail.com"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(typeText("werdf"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.loginBtn)).perform(click());
    }

    //testing password with invalid password credentials
    @Test
    public void test8() {
        //Looper.prepare();
        // launchActivityWithIntent();
        //   Espresso.onView(withId(R.id.emailLogText)).perform(typeText("dummyemail@gmail.com"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(typeText("qazswedfrtgyhju"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.loginBtn)).perform(click());
    }

    //testing password with invalid password credentials
    @Test
    public void test9() {
        //Looper.prepare();
        // launchActivityWithIntent();
        //   Espresso.onView(withId(R.id.emailLogText)).perform(typeText("dummyemail@gmail.com"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(typeText(" "));
        Espresso.onView(withId(R.id.passwordLogText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.loginBtn)).perform(click());
    }

    //testing reset password button
    @Test
    public void test10() {

        Espresso.onView(withId(R.id.forgetPassword)).perform(click());
    }





}
