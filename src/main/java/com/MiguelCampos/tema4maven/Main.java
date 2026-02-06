package com.MiguelCampos.tema4maven;

import com.github.lalyos.jfiglet.FigletFont;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    static void main() throws IOException {
        try {


            //crear baner
            String texto = "Miguel Campos";
            String banner = FigletFont.convertOneLine(texto);
            ArrayList<String> lineas = new ArrayList<>();
            lineas.addAll(Arrays.asList(banner.split("\n")));
            //curriculum
            lineas.add("");
            lineas.add("CURRICULUM VITAE");
            lineas.add("Estudiante de Informatica Grado Superior");
            lineas.add("Grado medio SMX");
            lineas.add("Educacion Secundaria Obligatoria");
            lineas.add("Idiomas: Español e Ingles");
            lineas.add("Habilidades");
            lineas.add("Manejo de Java y aplicaciones ofimaticas");
            lineas.add("Correo: miguelcampara1@gmail.com");
            lineas.add("Telefono 615 84 95 69");
            lineas.add("Dispuesto a trabajar y con ganas de aprender");

            Screen screen = new DefaultTerminalFactory().createScreen();
            screen.startScreen();
            screen.setCursorPosition(null);
            //8
            int height = screen.getTerminalSize().getRows();
            int yOffset = height;
            while (yOffset + lineas.size() > 0) {
                drawFrame(screen, lineas, yOffset);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }

                yOffset--;
            }

            screen.stopScreen();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void drawFrame(Screen screen, List<String> lines, int yOffset)
            throws IOException {
        TerminalSize size = screen.getTerminalSize();
        int width = size.getColumns();
        int height = size.getRows();
        screen.clear();
        TextGraphics tg = screen.newTextGraphics();
        for (int i = 0; i < lines.size(); i++) {
            int y = yOffset + i;
            if (y < 0 || y >= height) continue;
            String line = lines.get(i);
            // Centrado horizontal (opcional, pero queda mejor)
            int x = Math.max(0, (width - line.length()) / 2);
            if (x >= width) continue;
            // Recorte simple si se sale por la derecha
            String visible = (line.length() > width) ? line.substring(0, width) :
                    line;
            tg.putString(x, y, visible);
        }
        screen.refresh();
    }

}
