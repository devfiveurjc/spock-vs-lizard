package com.devfiveurjc.spockvslizard;

import java.util.Random;

public class Juego {

    private int[][] tablero;

    public int eleccionMaquina(){ //0:Piedra; 1:Papel; 2:Tijera; 3:Lagarto; 4:Spock
        Random random = new Random();
        return random.nextInt(5);
    }

    private void inicializarTablero() {

        /*                  JUGADOR
                            PIEDRA  PAPEL TIJERA LAGARTO SPOCK
       MAQUINA     PIEDRA      0      -1     1      1      -1
                   PAPEL       1       0    -1     -1       1
                   TIJERA     -1       1     0      1      -1
                   LAGARTO    -1       1    -1      0       1
                   SPOCK       1      -1     1     -1       0

         */
        int[][] t
                = {
                {0, -1, 1, 1, -1},
                {1, 0, -1, -1, 1},
                {-1, 1, 0, 1, -1},
                {-1, 1, -1, 0, 1},
                {1, -1, 1, -1, 0},
        };

        this.tablero = t;
    }

    private int ganador(int j1, int j2) {
        return this.tablero[j1][j2];
    }


    public int resultado(int eleccionJugador, int eleccionMaquina){
        int r = 0;
        inicializarTablero();
        int victorioso = ganador(eleccionMaquina, eleccionJugador);//falta eleccion del jugador
        switch(victorioso){
            case 0:
                r = 0; // Empate
                break;
            case 1:
                r = 1;// Gana Maquina
                break;
            default:
                r = -1; // Gana Jugador
                break;
        }
        return r;
    }
}

