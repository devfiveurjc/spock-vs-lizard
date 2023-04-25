package com.devfiveurjc.spockvslizard.UITest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.devfiveurjc.spockvslizard.Menu;
import com.devfiveurjc.spockvslizard.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class UITest3 {
    @Rule
    public ActivityScenarioRule<Menu> activityRule=
            new ActivityScenarioRule<>(Menu.class);
    @Test
    public void correctText(){
        String name = "Jugador";
        String expResult="Buena suerte "+name;

        onView(withId(R.id.nombreIngresado)).check(matches(isDisplayed()));
        onView(withId(R.id.nombreIngresado)).perform(typeText(name), ViewActions.closeSoftKeyboard()); //escribe en un campo de texto el nombre jugador
        onView(withId(R.id.nombreIngresado)).check(matches(withText(name))); //se comprueba que el elemento que almacena el texto, tiene el contenido introducido

        onView(withId(R.id.option1)).perform(click()); //se hace clic para cambiar a la actividad principal
        onView(withId(R.id.nombre)).check(matches(isDisplayed())); //se comprueba que el campo con el texto se muestra
        onView(withId(R.id.nombre)).check(matches(withText(expResult))); //se comprueba que el campo tenga el valor del nombre

    }
}

