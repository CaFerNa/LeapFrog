package com.cam;

public class Tablero {
    public static String generarTablero() {
        String tablero = "<div style='display: flex; justify-content: space-between; align-items: center; width: 100%;'>" +
                "<button id='1' type='button' style='width: 10%; aspect-ratio: 2/1; background-color: #3b82f6; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box; font-size: larger;'>O</button>" +
                "<button id='2' type='button' style='width: 10%; aspect-ratio: 2/1; background-color: #3b82f6; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box; font-size: larger;'>O</button>" +
                "<button id='3' type='button' style='width: 10%; aspect-ratio: 2/1; background-color: #3b82f6; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box; font-size: larger;'>O</button>" +
                "<button id='4' type='button' style='width: 10%; aspect-ratio: 2/1; background-color: #3b82f6; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box; font-size: larger;'>O</button>" +
                "<button id='5' type='button' style='width: 10%; aspect-ratio: 2/1; background-color: #f9f9f9; color: white; border: 1px solid #eee; border-radius: 4px; cursor: pointer; box-sizing: border-box;'>&nbsp;</button>" +
                "<button id='6' type='button' style='width: 10%; aspect-ratio: 2/1; background-color: #ff0000; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box; font-size: larger;'>X</button>" +
                "<button id='7' type='button' style='width: 10%; aspect-ratio: 2/1; background-color: #ff0000; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box; font-size: larger;'>X</button>" +
                "<button id='8' type='button' style='width: 10%; aspect-ratio: 2/1; background-color: #ff0000; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box; font-size: larger;'>X</button>" +
                "<button id='9' type='button' style='width: 10%; aspect-ratio: 2/1; background-color: #ff0000; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box; font-size: larger;'>X</button>";
        return tablero;
    }
}
