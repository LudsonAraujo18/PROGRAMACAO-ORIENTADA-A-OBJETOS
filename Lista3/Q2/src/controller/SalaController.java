package controller;

import model.Robo;

public class SalaController {
    private final int linhas = 20;
    private final int colunas = 40;

    public void mostrarSala(Robo robo) {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (i == robo.getLinha() && j == robo.getColuna()) {
                    System.out.print("1"); // Robô
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }
}
