package com.cam;

import java.util.Arrays;

public class TableroPiezas {

    public static String renderTablero(String[] piezas) {
        StringBuilder sb = new StringBuilder();
        String pieza = "";
        sb.append("<div style='display: flex; justify-content: space-between; align-items: center; width: 100%;'>");
        for (int i = 0; i < piezas.length ; i++) {
            pieza = (piezas[i]);
            if (pieza.equals("O")) {
                sb.append("<button type='button' id='" + i + "' style='width: 10%; aspect-ratio: 2/1; background-color: #3b82f6; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box; font-size: larger;'>O</button>");
            } else if (pieza.equals("X")) {
                sb.append("<button type='button' id='" + i + "'style='width: 10%; aspect-ratio: 2/1; background-color: #ff0000; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box; font-size: larger;'>X</button>");
            } else
                sb.append("<button type='button' id='" + i + "'style='width: 10%; aspect-ratio: 2/1; background-color: #ffffff; color: white; border: 1px solid #eee; border-radius: 4px; cursor: pointer; box-sizing: border-box;'>&nbsp;</button>");
        }
        sb.append("</div>");
        return sb.toString();
    }
}
