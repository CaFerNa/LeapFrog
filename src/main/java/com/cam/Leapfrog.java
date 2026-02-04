package com.cam;

import org.teavm.interop.Export;

import static com.cam.TableroPiezas.generarTablero;

public class Leapfrog {

    static String tableroInicio = "XXXX OOOO";
    static String tablero;
    static int contador;
    static boolean playGame;

    public static void main(String[] args) {
        inicializar();
        renderHtml("TableroPiezas");
    }

    @Export(name = "renderHtml")
    public static String renderHtml(String id) {
        return "<span style='color:red'>" + id + "</span>";
    }

    @Export(name = "runFunction")
    public static String runFunction() {
            return TableroPiezas.generarTablero();
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