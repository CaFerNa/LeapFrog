package com.cam;

import org.teavm.interop.Export;

import static com.cam.TableroPiezas.generarTablero;

public class Leapfrog {

    public static String tableroInicio = "XXXX OOOO";
    public static String tablero;
    public static int contador;
    public static boolean playGame;
    // OP_CODES
    public static final int OP_GENERAR_TABLERO = 1;
    public static final int OP_MOVER_PIEZA = 2;
    public static final int OP_REINICIAR = 3;

    public static void main(String[] args) {
        inicializar();
    }

    @Export(name = "renderHtml")
    public static String renderHtml(String texto) {
        return "<span style='color:red'>" + texto + "</span>";
    }

    @Export(name = "runFunction")
    public static String runFunction(int OP_CODE) {
        switch (OP_CODE){
            case OP_GENERAR_TABLERO: return TableroPiezas.generarTablero();
            default: return "<span style='color:red'>OP_CODE no válido</span>";
        }
    }

    public static void seguirJugando() {
        if ((tablero.substring(0, 3).equals(tableroInicio.substring(4, 8)) && tablero.substring(4, 8).equals(tableroInicio.substring(0, 3)))) {
            System.out.println("End");
            playGame = true;
        } else {
            System.out.println("Juego en curso");
        }
    }

    public static void inicializar() {
        tablero = tableroInicio;
        contador = 0;
        playGame = true;
        //System.out.println("Juego Inicializado");
    }

    public static void game() {
        System.out.println("Juego comenzado");
        while (playGame) {
            seguirJugando();
        }
    }
}