package com.devfiveurjc.spockvslizard;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    ImageView Datojugador;
    ImageView Datomaquina;
    MediaPlayer mp;
    TextView cabecera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String valor = getIntent().getStringExtra("Jugador");
        Toast.makeText(this,valor, Toast.LENGTH_LONG).show();
        TextView texto = findViewById(R.id.nombre);
        texto.setText("Buena suerte "+valor);
        cabecera= findViewById(R.id.cabecera);
        cabecera.setText("Elije");
        Datojugador = findViewById(R.id.Datojugador);
        Datomaquina = findViewById(R.id.Datomaquina);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    public void cambiaimagen(View view) throws NoSuchAlgorithmException {
        //TextView textoResultado = findViewById(R.id.Resultado);
        Juego j = new Juego();
        Juego result = new Juego();
        int maquina;
        int jugador = 0;
        int sol;
        System.out.println(view.getId());
        switch(view.getId()) {
            case R.id.piedra:
                mp = MediaPlayer.create(this, R.raw.rocas);
                Datojugador.setImageResource(R.drawable.piedra);
                mp.start();

                jugador = 0;
                break;
            case R.id.papel:
                mp = MediaPlayer.create(this, R.raw.papel);
                Datojugador.setImageResource(R.drawable.papel);
                mp.start();
                jugador = 1;
                break;
            case R.id.tijera:
                mp = MediaPlayer.create(this,R.raw.tijeras);
                Datojugador.setImageResource(R.drawable.tijera);
                mp.start();
                jugador = 2;
                break;
            case R.id.lagarto:
                mp = MediaPlayer.create(this, R.raw.lagartp);
                Datojugador.setImageResource(R.drawable.lagarto);
                mp.start();
                jugador = 3;
                break;
            case R.id.spok:
                mp = MediaPlayer.create(this, R.raw.spok);
                Datojugador.setImageResource(R.drawable.spock);
                mp.start();
                jugador = 4;
                break;
        }
        maquina = j.eleccionMaquina();
        switch(maquina){
            case 0:
                Datomaquina.setImageResource(R.drawable.piedra);
                break;
            case 1:
                Datomaquina.setImageResource(R.drawable.papel);
                break;
            case 2:
                Datomaquina.setImageResource(R.drawable.tijera);
                break;
            case 3:
                Datomaquina.setImageResource(R.drawable.lagarto);
                break;
            case 4:
                Datomaquina.setImageResource(R.drawable.spock);
                break;
        }
        sol = result.resultado(jugador, maquina);
        if (sol == 0){
            cabecera.setText("EMPATE");
        } else if (sol == 1){
            cabecera.setText("HAS PERDIDO");
        }else if (sol == -1){
            cabecera.setText("HAS GANADO");
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
