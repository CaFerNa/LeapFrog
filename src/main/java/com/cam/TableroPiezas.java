package com.cam;

public class TableroPiezas {
    public static String generarTablero() {
        String tablero = "<div style='display: flex; justify-content: space-between; align-items: center; width: 100%;'>" +
                "<button id='uno' type='button' style='width: 10%; aspect-ratio: 2/1; background-color: #3b82f6; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box; font-size: larger;'>O</button>" +
                "<button id='dos' type='button' style='width: 10%; aspect-ratio: 2/1; background-color: #3b82f6; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box; font-size: larger;'>O</button>" +
                "<button id='tres' type='button' style='width: 10%; aspect-ratio: 2/1; background-color: #3b82f6; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box; font-size: larger;'>O</button>" +
                "<button id='cuatro' type='button' style='width: 10%; aspect-ratio: 2/1; background-color: #3b82f6; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box; font-size: larger;'>O</button>" +
                "<button id='cinco' type='button' style='width: 10%; aspect-ratio: 2/1; background-color: #ffffff; color: white; border: 1px solid #eee; border-radius: 4px; cursor: pointer; box-sizing: border-box;'>&nbsp;</button>" +
                "<button id='seis' type='button' style='width: 10%; aspect-ratio: 2/1; background-color: #ff0000; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box; font-size: larger;'>X</button>" +
                "<button id='siete' type='button' style='width: 10%; aspect-ratio: 2/1; background-color: #ff0000; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box; font-size: larger;'>X</button>" +
                "<button id='ocho' type='button' style='width: 10%; aspect-ratio: 2/1; background-color: #ff0000; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box; font-size: larger;'>X</button>" +
                "<button id='nueve' type='button' style='width: 10%; aspect-ratio: 2/1; background-color: #ff0000; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box; font-size: larger;'>X</button>";

//        StringBuilder sb = new StringBuilder();
//        sb.append("<h4>Tablero Fila").append(1).append(" Columna").append(1).append(" </h4>");
//        tablero.concat(sb.toString());

        return tablero;
    }

    public String pieza (String id, String ficha) {
        String color = " ";
        switch (color) {
            case "X" :
                color = "#3b82f6";
                break;
            case "O" :
                color = "#ff0000";
                break;
            case " " :
                color = "#ffffff";
                break;
            default :
                color = "#ffffff";
        }
        return "<button id='" + id + "' type='button' style='width: 10%; aspect-ratio: 2/1; background-color: " + color + "; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box; font-size: larger;'>" + color + "</button>";
    }
}
