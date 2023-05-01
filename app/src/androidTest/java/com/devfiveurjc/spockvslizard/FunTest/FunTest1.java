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
public class FunTest1 {
    @Rule
    public ActivityScenarioRule<Menu> activityRule=
            new ActivityScenarioRule<>(Menu.class);

    @Test
    public void resultado_partida() throws NoSuchAlgorithmException {
        Looper.prepare();
        Juego juego = new Juego();
        int[] resultadosEsperados ={0, -1, 1, 1, -1, 1, 0, -1, -1, -1 , -1, 1, 0, 1, -1 , -1, 1, -1,
                0, -1 , 1, -1, 1, -1, -1};

        int cont=0;
        for (int i = 0; i < 5; i++) {
            for(int j = 0; j <5 ; j++) {
                int fila = i;
                int columna = j;
                int resultadoEsperado = resultadosEsperados[cont];
                int resultadoObtenido = juego.resultado(columna, fila);
                assertEquals(resultadoEsperado, resultadoObtenido);
                cont++;
            }
        }
    }

}