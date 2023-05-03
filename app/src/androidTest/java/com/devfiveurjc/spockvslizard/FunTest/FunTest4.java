package com.devfiveurjc.spockvslizard.FunTest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.os.Looper;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.devfiveurjc.spockvslizard.Menu;
import com.devfiveurjc.spockvslizard.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.security.NoSuchAlgorithmException;

@RunWith(AndroidJUnit4.class)
public class FunTest4 {
    @Rule
    public ActivityScenarioRule<Menu> activityRule=
            new ActivityScenarioRule<>(Menu.class);
    @Test
    public void cambiaimagenTest1() {
        String ResultadoText = "HAS GANADO";
        onView(withId(R.id.option1)).perform(click());
        onView(withId(R.id.spok)).perform(click());
        onView(withId(R.id.cabecera)).check(matches(withText(ResultadoText)));
    }
}
