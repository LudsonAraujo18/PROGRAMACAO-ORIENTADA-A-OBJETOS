package model;

public class Robo {
    private int linha;
    private int coluna;
    private int passo;

    public Robo(int linha, int coluna, int passo) {
        this.linha = linha;
        this.coluna = coluna;
        this.passo = passo;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void mostrarPosicaoAtual() {
        System.out.println("Posição atual do robô -> Linha: " + linha + " | Coluna: " + coluna);
    }

    public void andarFrente() {
        linha -= passo;
        if (linha < 0) {
            linha = 0;
        }
    }

    public void andarTras(int limiteLinhas) {
        linha += passo;
        if (linha >= limiteLinhas) {
            linha = limiteLinhas - 1;
        }
    }

    public void andarDireita(int limiteColunas) {
        coluna += passo;
        if (coluna >= limiteColunas) {
            coluna = limiteColunas - 1;
        }
    }

    public void andarEsquerda() {
        coluna -= passo;
        if (coluna < 0) {
            coluna = 0;
        }
    }
}
