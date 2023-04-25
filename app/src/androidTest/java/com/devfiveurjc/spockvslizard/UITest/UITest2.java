package com.devfiveurjc.spockvslizard.UITest;

import static androidx.test.espresso.Espresso.onView;
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
public class UITest2 {
    @Rule
    public ActivityScenarioRule<Menu> activityRule=
            new ActivityScenarioRule<>(Menu.class);
    @Test
    public void menuItemsCorrectlyCreated(){
        String option1Text="1 VS Maquina";
        String option2Text="1 VS 1";
        String tutorialText="Vídeo Tutorial";

        onView(withId(R.id.option1)).check(matches(isDisplayed())); //al cargar la activity, comprueba que el elemento exista
        onView(withId(R.id.option1)).check(matches(withText(option1Text))); //comprueba que si existe, tiene el texto correcto

        onView(withId(R.id.option2)).check(matches(isDisplayed())); //al cargar la activity, comprueba que el elemento exista
        onView(withId(R.id.option2)).check(matches(withText(option2Text))); //comprueba que si existe, tiene el texto correcto

        onView(withId(R.id.tutorialButton)).check(matches(isDisplayed())); //al cargar la activity, comprueba que el elemento exista
        onView(withId(R.id.tutorialButton)).check(matches(withText(tutorialText))); //comprueba que si existe, tiene el texto correcto

        onView(withId(R.id.ajustes)).check(matches(isDisplayed())); //al cargar la activity, comprueba que el elemento de ajustes exista
        onView(withId(R.id.ajustes)).check(matches(isClickable())); //comprueba que se pueda hacer click en los ajustes
    }
}
