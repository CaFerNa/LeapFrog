package com.cam;

import org.teavm.interop.Export;

public class Leapfrog {

    public static final String[] Tablero_Inicio = {"X","X","X","X"," ","O","O","O","O"};
    public static final String[] Tablero_Final = {"O","O","O","O"," ","X","X","X","X"};
    public static String[] tablero = {"","","","","","","","",""};
    public static int contador;
    public static boolean playGame;
    public static boolean firstMove;
    public static int pos_origen;
    public static final int COD_NOPIEZA = 10;

    // OP_CODES
    public static final int OP_GENERAR_PAGINA = 1;
    public static final int OP_MOVER_PIEZA = 2;

    public static void main(String[] args) {
        inicializar();
    }

    @Export(name = "renderHtml")
    public static String renderHtml(String texto, String id) {return texto;}

    @Export(name = "runFunction")
    public static String runFunction(int OP_CODE, int id) {
        switch (OP_CODE){
            case OP_GENERAR_PAGINA: return TableroPiezas.renderPage(tablero);
            case OP_MOVER_PIEZA: return gameLoop(id);
            default: return "<span style='color:red'>OP_CODE no válido</span>";
        }
    }

    public static void inicializar() {
        for (int i = 0; i < Tablero_Inicio.length; i++) tablero[i] = Tablero_Inicio[i];
        runFunction(OP_GENERAR_PAGINA, COD_NOPIEZA);
        contador = 0;
        playGame = true;
        firstMove = true;
        System.out.println("Juego Inicializado");
    }

    public static void comprobarTablero() {
        int correctos = 0;
        for (int i = 0; i < Tablero_Final.length; i++) {
            if(tablero[i].equals(Tablero_Final[i])) correctos++;
        }
        if (correctos == Tablero_Final.length) {
            renderHtml("<span style='color:red'>¡Has Ganado!</span>", "");
            System.out.println("Has Ganado!");
            playGame = false;
        } else {
            System.out.println(" No has Ganado. Te faltan " + ((Tablero_Final.length)-correctos) + " para ganar.");
            playGame = true;
        }
    }

    public static String moverPiezas(int cod_pieza) {
        if (firstMove) {
            firstMove = false;
            pos_origen = cod_pieza;
            return TableroPiezas.renderTablero(tablero, cod_pieza);
        } else{
            firstMove = true;
            tablero[cod_pieza] = tablero[pos_origen];
            //comprobamos
            System.out.println("[DEBUG] " + Math.abs(cod_pieza - pos_origen));
            if ((Math.abs(cod_pieza - pos_origen) > 2) && (!tablero[cod_pieza].equals(" "))) {
                System.out.println("[DEBUG] No permitido");
            }
            tablero[pos_origen] = " ";
            for (int i = 0; i < tablero.length; i++) System.out.print(tablero[i]);
            comprobarTablero();
            return TableroPiezas.renderTablero(tablero, COD_NOPIEZA);
        }
    }

    public static void endGame() {

    }

    public static String gameLoop(int id) {
        if (playGame) {
            return moverPiezas(id);
        } else {
            return TableroPiezas.renderTablero(tablero, 10);
        }
    }
}