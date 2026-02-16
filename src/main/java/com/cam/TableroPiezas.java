package com.cam;

import org.teavm.runtime.Console;

import java.util.Arrays;

public class TableroPiezas {

    public static final String COD_AZUL = "#3b82f6";
    public static final String COD_ROJO = "#ff0000";
    public static final String COD_GRIS = "#898989";

    public static String renderTablero(String[] piezas, int piezaPulsada) {
        StringBuilder sb = new StringBuilder();
        String pieza = "";
        String color = "";
        sb.append("<div style='display: flex; justify-content: space-between; align-items: center; width: 100%;'>");
        for (int i = 0; i < piezas.length ; i++) {
            pieza = (piezas[i]);
            if (pieza.equals("O")) {
                if (i == piezaPulsada) {color = COD_GRIS;} else {color = COD_AZUL;}
                sb.append("<button type='button' id='" + i + "' style='width: 10%; aspect-ratio: 2/1; background-color: "+color+"; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box; font-size: larger;'>O</button>");
            } else if (pieza.equals("X")) {
                if (i == piezaPulsada) {color = COD_GRIS;} else {color = COD_ROJO;}
                sb.append("<button type='button' id='" + i + "'style='width: 10%; aspect-ratio: 2/1; background-color: "+color+"; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box; font-size: larger;'>X</button>");
            } else if (pieza.equals(" ")){
                color = "white";
                sb.append("<button type='button' id='" + i + "'style='width: 10%; aspect-ratio: 2/1; background-color: " + color + "; color: white; border: 1px solid #eee; border-radius: 4px; cursor: pointer; box-sizing: border-box;'>&nbsp;</button>");
            }
        }
        sb.append("</div>");
        return sb.toString();
    }

    public static String renderFooter(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div style='padding: 0 20px; width: 100%; box-sizing: border-box; margin-top: 10px'>");
        sb.append("<div style='display: flex; justify-content: space-between; width: 100%; text-align: center; font-size: larger; font-weight: bold;'>");
        sb.append("<span style='width: 10%;'>1</span>");
        sb.append("<span style='width: 10%;'>2</span>");
        sb.append("<span style='width: 10%;'>3</span>");
        sb.append("<span style='width: 10%;'>4</span>");
        sb.append("<span style='width: 10%;'>5</span>");
        sb.append("<span style='width: 10%;'>6</span>");
        sb.append("<span style='width: 10%;'>7</span>");
        sb.append("<span style='width: 10%;'>8</span>");
        sb.append("<span style='width: 10%;'>9</span>");
        sb.append("</div>");
        sb.append("</div>");
        sb.append("<p>&nbsp;</p>");
        sb.append("<p id='msg' style='display: grid; place-items: center;'>"+ args[0] +"</p>");
        sb.append("<p>&nbsp;</p>");
        sb.append("<button type='button' id='10' style='display: block; margin: 0 auto;'>"+ args[1] +"</button>");
        return sb.toString();
    }

    public static  String renderPage(String[] tablero, int id, String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(renderTablero(tablero, id));
        sb.append(renderFooter(args));
        return sb.toString();
    }
}
