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
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RegisterTest{

    @Rule
    public ActivityTestRule<Register> mActivityRule = new ActivityTestRule<>(Register.class);

    private String userName = "test@gmail.com";
    private String passWord = "abcd";
    private String phoneNum = "7571234565";

    String registerToast =  "Verification link has been sent to your email.";
    @Test
    public void test() {
        Espresso.onView(withId(R.id.registerBtn)).perform(click());
    }


    @Test
    public void test2() {
        //test 2 - Empty String Val
        Espresso.onView(withId(R.id.fullNameRegEditText)).perform(typeText(""));
        Espresso.onView(withId(R.id.fullNameRegEditText)).perform(typeText(" "));
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(typeText(" "));
        // Espresso.onView(withId(R.id.phoneRegEditText)).perform(typeText(""));
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.registerBtn)).perform(click());
    }


    @Test
    public void test3() {
        //test 3 - correct Val
        Espresso.onView(withId(R.id.fullNameRegEditText)).perform(typeText("Jimmy Johnson"));
        Espresso.onView(withId(R.id.emailRegEditText)).perform(typeText("jimmyjohnson@gmail.com"));
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(typeText("jimyjohnjohnson"));
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.phoneRegEditText)).perform(typeText("7577895415"));
        Espresso.onView(withId(R.id.phoneRegEditText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.registerBtn)).perform(click());
        //Espresso.onView(withText(registerToast)).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }


    @Test
    public void test4() {
        //test 4 - invalid email input
        Espresso.onView(withId(R.id.fullNameRegEditText)).perform(typeText("Jimmy Johnson"));
        Espresso.onView(withId(R.id.emailRegEditText)).perform(typeText("jimmyjohnson@gmail"));
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(typeText("jimmyjohnjohnson"));
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.registerBtn)).perform(click());
        //Espresso.onView(withText(registerToast)).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }


    @Test
    public void test5() {
        Espresso.onView(withId(R.id.registerBtn)).perform(click());
    }


    @Test
    public void test6() {
        //test 6 - valid email
        Espresso.onView(withId(R.id.emailRegEditText)).perform(typeText("jimmjohnsongmail.com"));
        // Espresso.onView(withId(R.id.emailRegEditText)).perform(typeText("jimmyjohnson@gmailcom"));
        Espresso.onView(withId(R.id.emailRegEditText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.registerBtn)).perform(click());
    }


//    @Test
//    public void test7() {
//        //test 7 - existing email
//        Espresso.onView(withId(R.id.fullNameRegEditText)).perform(typeText("Jimmy Johnson"));
//        Espresso.onView(withId(R.id.emailRegEditText)).perform(typeText("jimmyjohnson@gmail.com"));
//        Espresso.onView(withId(R.id.passwordRegEditText)).perform(typeText("jimmyjohnjohnson"));
//        Espresso.onView(withId(R.id.passwordRegEditText)).perform(closeSoftKeyboard());
//        Espresso.onView(withId(R.id.phoneRegEditText)).perform(typeText("7577895415"));
//        Espresso.onView(withId(R.id.phoneRegEditText)).perform(closeSoftKeyboard());
//        Espresso.onView(withId(R.id.registerBtn)).perform(click());
//        Espresso.onView(withText("Error. Register new user failed due to duplicate registration ")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
//    }


    @Test
    public void test8() {
        //test 8 - phone number - non numerical vals
        Espresso.onView(withId(R.id.phoneRegEditText)).perform(typeText("dflsgkjjh4"));
        Espresso.onView(withId(R.id.phoneRegEditText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.registerBtn)).perform(click());
    }


    @Test
    public void test9() {
        //test 9 - correct phone number
        Espresso.onView(withId(R.id.phoneRegEditText)).perform(typeText("7571234565"));
        Espresso.onView(withId(R.id.phoneRegEditText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.registerBtn)).perform(click());
    }


    @Test
    public void test10() {
        //test 10 - phone number with area code
        Espresso.onView(withId(R.id.phoneRegEditText)).perform(typeText("17571234567"));
        Espresso.onView(withId(R.id.phoneRegEditText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.registerBtn)).perform(click());
    }


    @Test
    public void test11() {
        //test 11 - too long password
        Espresso.onView(withId(R.id.fullNameRegEditText)).perform(typeText("Jimmy Johnson"));
        Espresso.onView(withId(R.id.emailRegEditText)).perform(typeText("jimmyjohnson@gmail.com"));
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(typeText("ljkafdhlsdkjhalsdkfhlkfjdhlkjhlskdjhflakjfhladsoriwueghlkfjglksjehglkfjhldg"));
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.phoneRegEditText)).perform(typeText("7577895415"));
        Espresso.onView(withId(R.id.phoneRegEditText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.registerBtn)).perform(click());
        // Espresso.onView(withText("Error. Register new user failed due to duplicate registration ")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

//    @Test
//    public void test12() {
//        //test 12 - short password
//        Espresso.onView(withId(R.id.fullNameRegEditText)).perform(typeText("Jimy Johnson"));
//        Espresso.onView(withId(R.id.emailRegEditText)).perform(typeText("jimmmmmmmyjohnson@gmail.com"));
//        Espresso.onView(withId(R.id.passwordRegEditText)).perform(typeText("n"));
//        Espresso.onView(withId(R.id.passwordRegEditText)).perform(closeSoftKeyboard());
//        Espresso.onView(withId(R.id.phoneRegEditText)).perform(typeText("7577895415"));
//        Espresso.onView(withId(R.id.phoneRegEditText)).perform(closeSoftKeyboard());
//        Espresso.onView(withId(R.id.checkBoxStudent)).perform(click());
//        Espresso.onView(withId(R.id.registerBtn)).perform(click());
//        Espresso.onView(withText("Password must be greater than 6 characters")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
//    }


    @Test
    public void test13() {
        //test 13 - without numbers
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(typeText("jimmyjohnjohnson"));
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.registerBtn)).perform(click());
    }


    @Test
    public void test14() {
        //test 14 - without special characters
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(typeText("jimmyjoh#$^$hnson"));
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.registerBtn)).perform(click());
    }


    @Test
    public void test15() {
        //test 15 - entering alphanumerica char between 8 - 16 char and special char
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(typeText("jimmyjoh@njohnson"));
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.registerBtn)).perform(click());
    }


    @Test
    public void test16() {
        //test 16 - test tab button - should be able to hit tab to skip between lines
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(typeText("jimmyjoh@njohnson"));
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.registerBtn)).perform(click());
    }


    @Test
    public void test17() {
        //test 17 - test enter button
        Espresso.onView(withId(R.id.registerBtn)).perform(click());
    }


    @Test
    public void test18() {
        //test 18 - test "Student" option
        Espresso.onView(withId(R.id.fullNameRegEditText)).perform(typeText("Jimmy Johnson"));
        Espresso.onView(withId(R.id.emailRegEditText)).perform(typeText("jimmyjohnson@gmail.com"));
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(typeText("jimyjohnjohnson"));
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.phoneRegEditText)).perform(typeText("7577895415"));
        Espresso.onView(withId(R.id.phoneRegEditText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.registerBtn)).perform(click());
        Espresso.onView(withId(R.id.checkBoxStudent)).perform(click());
    }


    @Test
    public void test19() {
        //test 19 - tests teacher box
        Espresso.onView(withId(R.id.fullNameRegEditText)).perform(typeText("Mr.X"));
        Espresso.onView(withId(R.id.emailRegEditText)).perform(typeText("teachyoself@gmail.com"));
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(typeText("learningisfun"));
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.phoneRegEditText)).perform(typeText("7575561484"));
        Espresso.onView(withId(R.id.phoneRegEditText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.registerBtn)).perform(click());
        Espresso.onView(withId(R.id.checkBoxTeacher)).perform(click());
    }


    @Test
    public void test20() {
        //test 20 - tests sign in box
        Espresso.onView(withId(R.id.createRegText)).perform(click());
    }


    @Test
    public void test21() {
        //test 21 - tests to see if error would pop up if selected both student and teacher
        Espresso.onView(withId(R.id.fullNameRegEditText)).perform(typeText("Mr.X"));
        Espresso.onView(withId(R.id.emailRegEditText)).perform(typeText("teachyoself@gmail.com"));
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(typeText("learningisfun"));
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.phoneRegEditText)).perform(typeText("7575561484"));
        Espresso.onView(withId(R.id.phoneRegEditText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.registerBtn)).perform(click());
        Espresso.onView(withId(R.id.checkBoxTeacher)).perform(click());
        Espresso.onView(withId(R.id.checkBoxStudent)).perform(click());
        Espresso.onView(withText("Please select only one role")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }


    @Test
    public void test22() {
        //test 22 - tests to see if error would pop up if selected neither student and teacher
        Espresso.onView(withId(R.id.fullNameRegEditText)).perform(typeText("Mr.X"));
        Espresso.onView(withId(R.id.emailRegEditText)).perform(typeText("teachyoself@gmail.com"));
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(typeText("learningisfun"));
        Espresso.onView(withId(R.id.passwordRegEditText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.phoneRegEditText)).perform(typeText("7575561484"));
        Espresso.onView(withId(R.id.phoneRegEditText)).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.registerBtn)).perform(click());
        Espresso.onView(withText("Please select only one role")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }
}