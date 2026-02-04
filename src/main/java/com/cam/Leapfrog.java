package com.cam;

import org.teavm.interop.Export;

import static com.cam.TableroPiezas.renderTablero;

public class Leapfrog {

    public static String[] Tablero_Inicio = {"X","X","X","X"," ","O","O","O","O"};
    public static String[] tablero = {"O","O","O","O"," ","X","X","X","X"};
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
    public static String runFunction(int OP_CODE, String id) {
        switch (OP_CODE){
            case OP_GENERAR_TABLERO: return TableroPiezas.renderTablero(Tablero_Inicio);
            case OP_MOVER_PIEZA:
                comprobarTablero();
                return TableroPiezas.renderTablero(tablero);
            default: return "<span style='color:red'>OP_CODE no válido</span>";
        }
    }

    public static void comprobarTablero() {
        int correctos = 0;
        for (int i = 0; i < Tablero_Inicio.length; i++) {
            if(tablero[i].equals(Tablero_Inicio[i])) correctos++;
        }
        if (correctos == Tablero_Inicio.length) {
            renderHtml("<span style='color:red'>¡Has Ganado!</span>");
            System.out.println("Has Ganado!");
        } else {
            System.out.println("No has Ganado. Te faltan " + ((Tablero_Inicio.length)-correctos) + " para ganar.");
        }

    }

    public static void inicializar() {
        // tablero = Tablero_Inicio;
        contador = 0;
        playGame = true;
        //System.out.println("Juego Inicializado");
    }
}