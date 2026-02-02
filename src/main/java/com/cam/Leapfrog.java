package com.cam;

import org.teavm.interop.Export;

import static com.cam.Tablero.generarTablero;

public class Leapfrog {

    String pieza = "";

    public static void main(String[] args) {
        renderHtml("Tablero");
    }

    @Export(name = "renderHtml")
    public static String renderHtml(String nombre) {
        if (nombre == null) {
            return "<span style='color:red'>¡Por favor escribe un nombre!</span>";
        } else {
            switch (nombre) {
                case "Tablero": return Tablero.generarTablero();
                case "Azul": return "<span style='color:red'>Azul</span>";
                case "Rojo": return "<span style='color:red'>Rojo</span>";
                case "Vacio": return "";
            }
        }

        return generarTablero();
    }
}