package com.devfiveurjc.spockvslizard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;



public class Inicio extends AppCompatActivity {

    //variable para ajustar el tiempo que se va a mostrar esta pantalla
    private final int time = 5000;
    int modo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        ImageView image = findViewById(R.id.Imagen);
        Animation shakes = AnimationUtils.loadAnimation(this, R.anim.anim);
        image.startAnimation(shakes);

        cargarPrefeencias();
        setModo();

        startService(new Intent(this, MyService.class));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Inicio.this, Menu.class);
                startActivity(intent);
                finish();
            }
        }, time);
    }

    public void cargarPrefeencias(){
        SharedPreferences preferences = getSharedPreferences("apariencia", Context.MODE_PRIVATE);
        modo = preferences.getInt("modo",1);
    }

    public void setModo(){
        final Menu me = new Menu();
        if(modo==0){
            getDelegate().setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        }
        else{
            getDelegate().setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}
