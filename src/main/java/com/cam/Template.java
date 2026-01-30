package com.cam;

import org.teavm.interop.Export;

public class Template {

    public static void main(String[] args) {
        // Inicialización si fuera necesaria
    }

    @Export(name = "generarSaludo")
    public static String generarSaludo(String nombre) {
        if (nombre == null) {
            return "<span style='color:red'>¡Por favor escribe un nombre!</span>";
        }
        return "<div style='background:#e0f7fa; padding:10px; border-radius:5px;'>" +
                "<h3>¡Hola " + nombre + "!</h3>" +
                "<p>Este HTML ha sido generado íntegramente en <b>Java</b> y enviado a través de Wasm.</p>" +
                "</div>";
    }
}