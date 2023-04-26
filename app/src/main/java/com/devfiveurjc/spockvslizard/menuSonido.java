package com.devfiveurjc.spockvslizard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class menuSonido extends AppCompatActivity {

    AudioManager gestorSonido;
    int modo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_sonido);
        gestorSonido = (AudioManager) getSystemService(AUDIO_SERVICE);

        int volumenMaximo = gestorSonido.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int volumenActual = gestorSonido.getStreamVolume(AudioManager.STREAM_MUSIC);
        SeekBar barraSonido = (SeekBar) findViewById(R.id.barraVolumen);
        barraSonido.setMax(volumenMaximo);
        barraSonido.setProgress(volumenActual);

        barraSonido.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                gestorSonido.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Switch sw = findViewById(R.id.switchModo);

        cargarPrefeencias();

        if(modo==0){
            sw.setChecked(true);
        }
        else{
            sw.setChecked(false);
        }

        sw.setOnClickListener(view -> {
            if(sw.isChecked()){
                modo = 0;
                setModo();
                guardarPrefeencias();
            }
            else{
                modo = 1;
                setModo();
                guardarPrefeencias();
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

    private void guardarPrefeencias(){
        SharedPreferences preferences = getSharedPreferences("apariencia", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("modo",modo);
        editor.commit();
    }

    private void cargarPrefeencias(){
        SharedPreferences preferences = getSharedPreferences("apariencia", Context.MODE_PRIVATE);
        modo = preferences.getInt("modo",1);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void playSecret(View view) {
        Intent intent = new Intent(this, Secret.class);
        startActivity(intent);
    }


}
