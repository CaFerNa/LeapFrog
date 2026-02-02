package com.cam;

public class Piezas {
    public String pieza (String clase) {
        String html = "";
        switch (clase) {
            case "Azul":
                html = "<button type='button' style='position: absolute; left: 1%; top: 24%; width: 5%; height: 13%; padding: 8px 16px; background-color: #3b82f6; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box; font-size: larger;'>" + 0 + "</button>";
            case "Rojo":
                html = "<button type=\"button\" style=\"position: absolute; left: 31%; top: 24%; width: 5%; height: 13%; padding: 8px 16px; background-color: #ff0000; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box; font-size: larger;\">X</button>";
            case "Vacio":
                html = "<button type=\"button\" style=\"position: absolute; left: 25%; top: 24%; width: 5%; height: 13%; padding: 8px 16px; background-color: #f9f9f9; color: white; border: none; border-radius: 4px; cursor: pointer; box-sizing: border-box;\">&nbsp;</button>";
        }
        return html;
    }
}
