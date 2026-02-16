package com.cam;

import org.teavm.interop.Export;

public class Leapfrog {

    public static final String[] Tablero_Inicio = {"X","X","X","X"," ","O","O","O","O"};
    public static final String[] Tablero_Final = {"O","O","O","O"," ","X","X","X","X"};
    public static String[] tablero = {"","","","","","","","",""};
    // public static String[] mensajes = {"&nbsp;","Pulse para Comenzar", "Pulse para reiniciar", "Movimento no permitido", ""};
    public static String[] mensajes = {"","",""};
    public static int moves;
    public static boolean playGame;
    public static boolean firstMove;
    public static int pos_origen;
    public static final int COD_NOPIEZA = 10;

    // OP_CODES
    public static final int OP_GENERAR_TABLERO = 1;
    public static final int OP_GENERAR_FOOTER = 2;
    public static final int OP_MOVER_PIEZA = 3;
    public static final int OP_REINICIAR = 10;

    public static void main(String[] args) {}

    @Export(name = "runFunction")
    public static String runFunction(int id) {
        switch (id){
            case OP_REINICIAR: return inicializar();
            case 0: case 1 : case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: return gameLoop(id);
            default: return "<span style='color:red'>OP_CODE no válido</span>";
        }
    }

    public static String inicializar() {
        for (int i = 0; i < Tablero_Inicio.length; i++) tablero[i] = Tablero_Inicio[i];
        moves = 0;
        playGame = true;
        firstMove = true;
        mensajes[0] = "&nbsp;";
        mensajes[1] = "Pulse para reiniciar";
        System.out.println("[DEBUG] Juego Inicializado");
        return TableroPiezas.renderPage(tablero, COD_NOPIEZA, mensajes);
    }

    public static void comprobarTablero() {
        int correctos = 0;
        for (int i = 0; i < Tablero_Final.length; i++) {
            if(tablero[i].equals(Tablero_Final[i])) correctos++;
        }
        if (correctos == Tablero_Final.length) {
            mensajes[0] = "¡Has Ganado! en " + moves + " movimientos.";
            System.out.println("[DEBUG] Has Ganado!");
            playGame = false;
        } else {
            System.out.println("[DEBUG] No has Ganado. Te faltan " + ((Tablero_Final.length)-correctos) + " para ganar.");
            playGame = true;
        }
    }

    public static String moverPiezas(int cod_pieza) {
        if (firstMove) {
            firstMove = false;
            pos_origen = cod_pieza;
            mensajes[0] = "&nbsp;";
            return TableroPiezas.renderPage(tablero, cod_pieza, mensajes);
        } else{
            firstMove = true;
            //comprobamos
            if ((Math.abs(cod_pieza - pos_origen) > 2) || (!tablero[cod_pieza].equals(" "))) {
                System.out.println("[DEBUG] No permitido");
                mensajes[0] = "Movimiento no permitido";
                return TableroPiezas.renderPage(tablero, COD_NOPIEZA, mensajes);
            } else {
                tablero[cod_pieza] = tablero[pos_origen];
                tablero[pos_origen] = " ";
                System.out.print("[DEBUG] ");
                for (int i = 0; i < tablero.length; i++) System.out.print(tablero[i]);
                System.out.print(" \n");
                comprobarTablero();
                moves++;
                return TableroPiezas.renderPage(tablero, COD_NOPIEZA, mensajes);
            }

        }
    }

    public static String gameLoop(int id) {
        if (playGame) {
            return moverPiezas(id);
        } else {
            return TableroPiezas.renderPage(tablero, COD_NOPIEZA, mensajes);
        }
    }
}
