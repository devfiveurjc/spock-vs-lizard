package com.devfiveurjc.spockvslizard.FunTest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

import android.os.Looper;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.devfiveurjc.spockvslizard.JUGADORVSJUGADORS;
import com.devfiveurjc.spockvslizard.Menu;
import com.devfiveurjc.spockvslizard.R;

import java.security.NoSuchAlgorithmException;

@RunWith(AndroidJUnit4.class)
public class FunTest3 {
    @Rule
    public ActivityScenarioRule<Menu> activityRule=
            new ActivityScenarioRule<>(Menu.class);
    @Test
    public void cambiaimagenTest() {
        String ResultadoText = "JUGADOR 1 GANA";
        onView(withId(R.id.option2)).perform(click());
        onView(withId(R.id.piedra)).perform(click());
        onView(withId(R.id.tijera)).perform(click());
        onView(withId(R.id.Resultado)).check(matches(withText(ResultadoText)));
 }
    @Test
    public void cambiaimagenTest2() {
        String ResultadoText = "EMPATE";
        onView(withId(R.id.option2)).perform(click());
        onView(withId(R.id.piedra)).perform(click());
        onView(withId(R.id.piedra)).perform(click());
        onView(withId(R.id.Resultado)).check(matches(withText(ResultadoText)));
    }
    @Test
    public void cambiaimagenTest3() {
        String ResultadoText = "JUGADOR 2 GANA";
        onView(withId(R.id.option2)).perform(click());
        onView(withId(R.id.tijera)).perform(click());
        onView(withId(R.id.piedra)).perform(click());
        onView(withId(R.id.Resultado)).check(matches(withText(ResultadoText)));
    }
}
