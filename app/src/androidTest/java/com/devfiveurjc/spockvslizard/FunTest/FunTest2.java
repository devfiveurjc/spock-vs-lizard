package com.devfiveurjc.spockvslizard.FunTest;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.devfiveurjc.spockvslizard.Juego;
import com.devfiveurjc.spockvslizard.Menu;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.security.NoSuchAlgorithmException;


import static org.junit.Assert.assertEquals;

import android.os.Looper;

@RunWith(AndroidJUnit4.class)
public class FunTest2 {
    @Rule
    public ActivityScenarioRule<Menu> activityRule=
            new ActivityScenarioRule<>(Menu.class);

    @Test
    public void eleccionMaquina_debeSerUnNumeroEntre0y4() throws NoSuchAlgorithmException {
        Looper.prepare();
        Juego juego = new Juego();
        for (int i = 0; i < 100; i++) {
            int eleccion = juego.eleccionMaquina();
            boolean resultado = eleccion >= 0 && eleccion <= 4;
            assertEquals(true, resultado);
        }
    }
}
