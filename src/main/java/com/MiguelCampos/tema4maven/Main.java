package com.MiguelCampos.tema4maven;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;

public class Main {
    static void main() throws IOException {
    //crear baner
        String texto = "Miguel Campos";
        String banner = FigletFont.convertOneLine(texto);
        System.out.println(banner);

    }
}
