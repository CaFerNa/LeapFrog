package com.cam;

import org.teavm.interop.Export;

import static com.cam.TableroPiezas.renderTablero;

public class Leapfrog {

    public static String[] Tablero_Inicio = {"X","X","X","X"," ","O","O","O","O"};
    public static String[] tablero = {"X","X","X","X"," ","O","O","O","O"};
    public static int contador;
    public static boolean playGame;
    public static int[] firstMove = new int[2];
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
    public static String runFunction(int OP_CODE, int id) {
        switch (OP_CODE){
            case OP_GENERAR_TABLERO: return TableroPiezas.renderTablero(Tablero_Inicio, 10);
            case OP_MOVER_PIEZA: return gameLoop(id);
            default: return "<span style='color:red'>OP_CODE no válido</span>";
        }
    }

    public static void inicializar() {
        // tablero = Tablero_Inicio;
        renderHtml(TableroPiezas.renderTablero(Tablero_Inicio, 10));
        contador = 0;
        playGame = true;
        for (int i = 0; i < firstMove.length; i++)  firstMove[i] = 0;
        //System.out.println("Juego Inicializado");
    }

    public static void comprobarTablero() {
        int correctos = 0;
        for (int i = 0; i < Tablero_Inicio.length; i++) {
            if(tablero[i].equals(Tablero_Inicio[i])) correctos++;
        }
        if (correctos == Tablero_Inicio.length) {
            renderHtml("<span style='color:red'>¡Has Ganado!</span>");
            System.out.println("Has Ganado!");
            playGame = false;
        } else {
            System.out.println("No has Ganado. Te faltan " + ((Tablero_Inicio.length)-correctos) + " para ganar.");
            playGame = true;
        }

    }

    public static String moverPiezas(int cod_pieza) {
        if (firstMove[0] == 0) {
            firstMove[0] = 1;
            firstMove[1] = cod_pieza;
            System.out.println(firstMove[1]);
            return "Primer click";
        } else{
            firstMove[0] = 0;
            tablero[cod_pieza] = tablero[firstMove[1]];
            System.out.println(tablero[cod_pieza]);
            return "Segundo click";
        }
    }

    public static void endGame() {

    }

    public static String gameLoop(int id) {
        comprobarTablero();
        if (playGame) {
            moverPiezas(id);
            return TableroPiezas.renderTablero(tablero, id);
        } else return TableroPiezas.renderTablero(tablero, 10);

    }
}