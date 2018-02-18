package com.experitest.ExperiBank;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule(LoginActivity.class);

    @Test
    public void loginActivityTest() {
        ViewInteraction editText = onView(
                withId(R.id.usernameTextField));
        editText.perform(scrollTo(), replaceText("company"), closeSoftKeyboard());


        ViewInteraction editText2 = onView(
                withId(R.id.passwordTextField));
        editText2.perform(scrollTo(), replaceText("company"), closeSoftKeyboard());

        ViewInteraction button = onView(
                allOf(withId(R.id.loginButton), withText("Login"),
                        withParent(allOf(withId(R.id.makePaymentView),
                                withParent(withId(R.id.scrollView1))))));
        button.perform(scrollTo(), click());

        ViewInteraction button2 = onView(
                allOf(withId(R.id.logoutButton), withText("Logout")));
        button2.perform(scrollTo(), click());

    }

}
