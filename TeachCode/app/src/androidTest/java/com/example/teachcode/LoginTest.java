package com.example.teachcode;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginTest {
    @Rule
    public ActivityTestRule<Login> mActivityRule = new ActivityTestRule<>(Login.class);


    //tests basic functioning of buttons
    @Test
    public void test() {
        Espresso.onView(withId(R.id.loginBtn)).perform(click());
        //Espresso.onView(withId(R.id.createUserLogText)).perform(click());
    }


    //testing unregistered student email
    @Test
    public void test1() throws InterruptedException {
        Espresso.onView(withId(R.id.emailLogText)).perform(typeText("invalid@gmail.com"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(typeText("qwerty"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.loginBtn)).perform(click());
    }


    //testing unregistered teacher email
    @Test
    public void test2() {
        Espresso.onView(withId(R.id.emailLogText)).perform(typeText("dummyemail@gmail.com"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(typeText("wwerftgy"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.loginBtn)).perform(click());
    }


    //testing registered student email
    @Test
    public void test3() {
        Espresso.onView(withId(R.id.emailLogText)).perform(typeText("paulsingh@gmail.com"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(typeText("qwerty"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.loginBtn)).perform(click());
    }


    //testing registered teacher email
    @Test
    public void test4() {
        Espresso.onView(withId(R.id.emailLogText)).perform(typeText("dummyemail@gmail.com"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(typeText("wwerftgy"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.loginBtn)).perform(click());
    }


    //testing email with invalid character(s)
    @Test
    public void test5() {
        Espresso.onView(withId(R.id.emailLogText)).perform(typeText("dummyemail"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(typeText("wwerftgy"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.loginBtn)).perform(click());
    }


    //testing password with invalid empty email credentials
    @Test
    public void test6() {
        Espresso.onView(withId(R.id.emailLogText)).perform(typeText(""));
        Espresso.onView(withId(R.id.passwordLogText)).perform(typeText(" "));
        Espresso.onView(withId(R.id.passwordLogText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.loginBtn)).perform(click());
    }


    //testing password with invalid password credentials
    @Test
    public void test7() {
        Espresso.onView(withId(R.id.emailLogText)).perform(typeText("dummyemail@gmail.com"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(typeText("werdf"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.loginBtn)).perform(click());
    }


    //testing password with invalid password credentials
    @Test
    public void test8() {
        Espresso.onView(withId(R.id.emailLogText)).perform(typeText("dummyemail@gmail.com"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(typeText("qazswedfrtgyhju"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.loginBtn)).perform(click());
    }


    //testing password with invalid password credentials
    @Test
    public void test9() {
        Espresso.onView(withId(R.id.emailLogText)).perform(typeText("dummyemail@gmail.com"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(typeText(" "));
        Espresso.onView(withId(R.id.passwordLogText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.loginBtn)).perform(click());
    }


    //testing reset password button
    @Test
    public void test10() {
        Espresso.onView(withId(R.id.forgetPassword)).perform(click());
    }


    //testing login with teacher
    @Test
    public void test11() {
        Espresso.onView(withId(R.id.emailLogText)).perform(typeText("dummyemail@gmail.com"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(typeText("qazswedfrtgyhju"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.teacherLogSignIn)).perform(click());
        // Espresso.onView(withId(R.id.)).perform(click());
    }


    //testing invalid login with teacher
    @Test
    public void test12() {
        Espresso.onView(withId(R.id.emailLogText)).perform(typeText("dummyema@gmail.com"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(typeText("qazswrtgyhju"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.teacherLogSignIn)).perform(click());
        // Espresso.onView(withId(R.id.)).perform(click());
    }


    //testing teacher login with student information
    @Test
    public void test13() {
        Espresso.onView(withId(R.id.emailLogText)).perform(typeText("paulsingh4118@gmail.com"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(typeText("qwerty"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.teacherLogSignIn)).perform(click());
        // Espresso.onView(withId(R.id.)).perform(click());
    }


    //testing student login with teacher information
    @Test
    public void test14() {
        Espresso.onView(withId(R.id.emailLogText)).perform(typeText("paulsingh4118@gmail.com"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(typeText("qwerty"));
        Espresso.onView(withId(R.id.passwordLogText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.loginBtn)).perform(click());
        // Espresso.onView(withId(R.id.)).perform(click());
    }
}
