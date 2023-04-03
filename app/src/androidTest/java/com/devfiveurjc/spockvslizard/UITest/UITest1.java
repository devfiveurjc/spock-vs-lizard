package com.devfiveurjc.spockvslizard.UITest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewAssertion;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.devfiveurjc.spockvslizard.Menu;
import com.devfiveurjc.spockvslizard.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4ClassRunner.class)
public class UITest1 {
    @Rule
    public ActivityScenarioRule<Menu> activityRule=
            new ActivityScenarioRule<>(Menu.class);
    @Test
    public void textCreated(){
        onView(withId(R.id.tutorialButton)).check((ViewAssertion) isClickable()); //mira si es clickeable
        onView(withId(R.id.tutorialButton)).perform(click()); //hace click

        onView(withId(R.id.videoView)).check(matches(isDisplayed())); //comprueba que un elemento de la nueva activity haya cargado

    }
}


