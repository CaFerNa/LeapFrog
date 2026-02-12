package com.cam;

import java.util.Arrays;

public class TableroPiezas {

    public static String renderTablero(String[] piezas, int piezaPulsada) {
        StringBuilder sb = new StringBuilder();
        String pieza = "";
        String color = "";
        sb.append("<div style='display: flex; justify-content: space-between; align-items: center; width: 100%;'>");
        for (int i = 0; i < piezas.length ; i++) {
            pieza = (piezas[i]);
            if (pieza.equals("O")) {
                if (i == piezaPulsada) {color = "#898989";} else {color = "#3b82f6";}
                sb.append("<button type='button' id='" + i + "' style='width: 10%; aspect-ratio: 2/1; background-color: "+color+"; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box; font-size: larger;'>O</button>");
            } else if (pieza.equals("X")) {
                if (i == piezaPulsada) {color = "#898989";} else {color = "#ff0000";}
                sb.append("<button type='button' id='" + i + "'style='width: 10%; aspect-ratio: 2/1; background-color: "+color+"; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box; font-size: larger;'>X</button>");
            } else if (pieza.equals(" ")){
                color = "white";
                sb.append("<button type='button' id='" + i + "'style='width: 10%; aspect-ratio: 2/1; background-color: " + color + "; color: white; border: 1px solid #eee; border-radius: 4px; cursor: pointer; box-sizing: border-box;'>&nbsp;</button>");
            }
        }
        sb.append("</div>");
        return sb.toString();
    }

    public static String renderFooter(String[] args){
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
        sb.append("<p id='msg'>&nbsp;</p>");
        sb.append("<button id='btn' style='display: block; margin: 0 auto;'>Pulsa para empezar</button>");
        return sb.toString();
    }

    public static  String renderPage(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(renderTablero(args,10));
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
        sb.append("<p id='msg'>&nbsp;</p>");
        sb.append("<button id='btn' style='display: block; margin: 0 auto;'>Pulsa para empezar</button>");
        return sb.toString();
    }
}
