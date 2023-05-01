package com.devfiveurjc.spockvslizard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Menu extends AppCompatActivity {

    private TextInputEditText nombre_jugador;
    int modo;
    Window window;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.window = getWindow();

        cargarPrefeencias();
        cambiarFondo();

        TextView opcion1=findViewById(R.id.option1);
        opcion1.setText("1 VS Maquina");
        TextView opcion2=findViewById(R.id.option2);
        opcion2.setText("1 VS 1");
        TextView tutorial=findViewById(R.id.tutorialButton);
        tutorial.setText("Vídeo Tutorial");

        this.nombre_jugador = findViewById(R.id.nombreIngresado);

    }

    public void PlayClick(View view){
        String nombreIngresado = nombre_jugador.getText().toString().trim();

        if (!nombreIngresado.isEmpty()){
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("Jugador", nombreIngresado);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("Jugador", "Usuario");
            startActivity(intent);
        }
    }
    public void PlayClick2(View view){
        String nombreIngresado = nombre_jugador.getText().toString().trim();

        if (!nombreIngresado.isEmpty()){
            Intent intent = new Intent(this, JUGADORVSJUGADORS.class);
            intent.putExtra("Jugador", nombreIngresado);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, JUGADORVSJUGADORS.class);
            intent.putExtra("Jugador", "Usuario");
            startActivity(intent);
        }
    }

    public void tutorial(View view) {
        Intent intent = new Intent(this, tutorial.class);
        startActivity(intent);
    }


    public void sonido(View view) {
        Intent intent = new Intent(this, menuSonido.class);
        startActivity(intent);
    }

    public void cargarPrefeencias(){
        SharedPreferences preferences = getSharedPreferences("apariencia", Context.MODE_PRIVATE);
        modo = preferences.getInt("modo",1);
    }

    public void cambiarFondo(){
        if(modo==0){
            //layout.setBackgroundResource(R.drawable.bgdark);
            window.setBackgroundDrawableResource(R.drawable.bgdark);
        }
        else{
            //layout.setBackgroundResource(R.drawable.background);
            window.setBackgroundDrawableResource(R.drawable.background);
        }
    }
}
