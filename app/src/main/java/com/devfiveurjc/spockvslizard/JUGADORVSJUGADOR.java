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

public class JUGADORVSJUGADOR extends AppCompatActivity {
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

    private int devolver(int numero){
        switch (numero) {
            case 0:
                return R.drawable.piedra;
            case 1:
                return R.drawable.tijera;
            case 2:
                return R.drawable.papel;
            case 3:
                return R.drawable.lagarto;
            case 4:
                return R.drawable.spock;
            default:
        }
        return numero;
    }

    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    public void cambiaimagen(View view) {
        TextView textoResultado = findViewById(R.id.Resultado);
        Juego result = new Juego();
        int sol;
        if (turno <=1) {
            System.out.println(view.getId());
            switch (view.getId()) {
                case R.id.piedra:
                    if (turno ==0) {
                        mp = MediaPlayer.create(this, R.raw.rocas);
                        mp.start();
                        jugador = 0;
                        break;
                    }
                    else{
                        mp = MediaPlayer.create(this, R.raw.rocas);

                        datojugador.setImageResource(devolver(jugador));
                        datojugador2.setImageResource(R.drawable.piedra);
                        mp.start();
                        jugador2 = 0;
                        break;
                    }
                case R.id.papel:
                    if (turno ==0) {
                        mp = MediaPlayer.create(this, R.raw.papel);
                        mp.start();
                        jugador = 1;
                        break;
                    }
                    else{
                        mp = MediaPlayer.create(this, R.raw.papel);
                        datojugador.setImageResource(devolver(jugador));
                        datojugador2.setImageResource(R.drawable.papel);
                        mp.start();
                        jugador2 = 1;
                        break;
                    }
                case R.id.tijera:
                    if(turno ==0) {
                        mp = MediaPlayer.create(this, R.raw.tijeras);
                        mp.start();
                        jugador = 2;
                        break;
                    }
                    else {
                        mp = MediaPlayer.create(this, R.raw.tijeras);
                        datojugador.setImageResource(devolver(jugador));
                        datojugador2.setImageResource(R.drawable.tijera);
                        mp.start();
                        jugador2 = 2;
                        break;
                    }
                case R.id.lagarto:
                    if(turno ==0) {
                        mp = MediaPlayer.create(this, R.raw.lagartp);
                        mp.start();
                        jugador = 3;
                        break;
                    }
                    else{
                        mp = MediaPlayer.create(this, R.raw.lagartp);
                        datojugador.setImageResource(devolver(jugador));
                        datojugador2.setImageResource(R.drawable.lagarto);
                        mp.start();
                        jugador2 = 3;
                        break;
                    }
                case R.id.spok:
                    if (turno ==0) {
                        mp = MediaPlayer.create(this, R.raw.spok);
                        mp.start();
                        jugador = 4;
                        break;
                    }
                    else{
                        mp = MediaPlayer.create(this, R.raw.spok);
                        datojugador.setImageResource(devolver(jugador));
                        datojugador2.setImageResource(R.drawable.spock);
                        mp.start();
                        jugador2 = 4;
                        break;
                    }
            }
        }
        if (turno == 0){
            textoResultado.setText("Turno del Jugador 2");
        }
        else if (turno == 1){
            sol = result.resultado(jugador, jugador2);
            if (sol == 0){
                textoResultado.setText("EMPATE");
            } else if (sol == 1){
                textoResultado.setText("JUGADOR 2 GANA");
            }else if (sol == -1){
                textoResultado.setText("JUGADOR 1 GANA");
            }
        }
        else{
            textoResultado.setText("¡Tienes eu limpiar tablero!");
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
