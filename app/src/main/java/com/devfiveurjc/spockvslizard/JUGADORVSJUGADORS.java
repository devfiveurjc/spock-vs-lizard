package com.devfiveurjc.spockvslizard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.NoSuchAlgorithmException;

public class JUGADORVSJUGADORS extends AppCompatActivity {
    ImageView datojugador;
    ImageView datojugador2;
    int jugador;
    int jugador2;
    int turno;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugsdorvs_jugador);
        String valor = getIntent().getStringExtra("Jugador");
        Toast.makeText(this,valor, Toast.LENGTH_LONG).show();
        TextView texto = findViewById(R.id.Nombre);
        texto.setText(valor);
        datojugador = findViewById(R.id.Datojugador);
        datojugador2 = findViewById(R.id.Datomaquina);
        turno =0;
        jugador =0;
        jugador2 =0;

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    public void cambiaimagen(View view) throws NoSuchAlgorithmException {
        //cognitive now lower
        TextView textoResultado = findViewById(R.id.Resultado);
        Juego j = new Juego();
        Juego result = new Juego();
        int sol;
        if (turno <= 1) {
            int jugadorImage = -1;
            int jugador2Image = -1;
            int sonido = -1;
            switch (view.getId()) {
                case R.id.piedra:
                    jugadorImage = R.drawable.piedra;
                    sonido = R.raw.rocas;
                    if (turno == 0) {
                        jugador = 0;
                    } else {
                        jugador2Image = R.drawable.piedra;
                        jugador2 = 0;
                    }
                    break;
                case R.id.papel:
                    jugadorImage = R.drawable.papel;
                    sonido = R.raw.papel;
                    if (turno == 0) {
                        jugador = 1;
                    } else {
                        jugador2Image = R.drawable.papel;
                        jugador2 = 1;
                    }
                    break;
                case R.id.tijera:
                    jugadorImage = R.drawable.tijera;
                    sonido = R.raw.tijeras;
                    if (turno == 0) {
                        jugador = 2;
                    } else {
                        jugador2Image = R.drawable.tijera;
                        jugador2 = 2;
                    }
                    break;
                case R.id.lagarto:
                    jugadorImage = R.drawable.lagarto;
                    sonido = R.raw.lagartp;
                    if (turno == 0) {
                        jugador = 3;
                    } else {
                        jugador2Image = R.drawable.lagarto;
                        jugador2 = 3;
                    }
                    break;
                case R.id.spok:
                    jugadorImage = R.drawable.spock;
                    sonido = R.raw.spok;
                    if (turno == 0) {
                        jugador = 4;
                    } else {
                        jugador2Image = R.drawable.spock;
                        jugador2 = 4;
                    }
                    break;
            }
            if (turno == 0) {
                mp = MediaPlayer.create(this, sonido);
                mp.start();
                datojugador.setImageResource(jugadorImage);
                textoResultado.setText("Turno del Jugador 2");
            } else {
                mp = MediaPlayer.create(this, sonido);
                mp.start();
                datojugador2.setImageResource(jugador2Image);
                sol = result.resultado(jugador, jugador2);
                if (sol == 0) {
                    textoResultado.setText("EMPATE");
                } else if (sol == 1) {
                    textoResultado.setText("JUGADOR 2 GANA");
                } else if (sol == -1) {
                    textoResultado.setText("JUGADOR 1 GANA");
                }
            }
        } else {
            textoResultado.setText("¡Tienes que limpiar tablero!");
        }
        turno++;

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
