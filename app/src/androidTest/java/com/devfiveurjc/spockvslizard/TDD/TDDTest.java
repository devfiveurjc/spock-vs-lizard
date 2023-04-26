package com.devfiveurjc.spockvslizard.TDD;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.devfiveurjc.spockvslizard.Menu;
import com.devfiveurjc.spockvslizard.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class TDDTest {
    @Rule
    public ActivityScenarioRule<Menu> activityRule=
            new ActivityScenarioRule<>(Menu.class);
    @Test
    public void newFeatureTest(){
        onView(withId(R.id.ajustes)).check(matches(isDisplayed()));
        onView(withId(R.id.ajustes)).check(matches(isClickable()));
        onView(withId(R.id.ajustes)).perform(click());
        onView(withId(R.id.secret)).check(matches(isDisplayed()));
        onView(withId(R.id.secret)).check(matches(isClickable()));
        onView(withId(R.id.secret)).perform(click());
        onView(withId(R.id.secretText)).check(matches(isDisplayed()));
        onView(withId(R.id.secretText)).check(matches(withText("¡¡Esto sí es TDD!!")));


    }
}

