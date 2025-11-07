package view;

import java.util.Scanner;
import controller.GameController;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameController game = new GameController();

        System.out.println("==== JOGO DE DADOS ====");
        game.mostrarRanking();
        System.out.println("Pressione ENTER para iniciar...");
        sc.nextLine();

        System.out.println("Quantos jogadores vão participar? (máximo 11): ");
        int qtd = sc.nextInt();
        sc.nextLine();

        if (qtd > 11) qtd = 11;

        for (int i = 0; i < qtd; i++) {
            System.out.print("\nNome do jogador " + (i + 1) + ": ");
            String nome = sc.nextLine();
            System.out.print("Aposta (entre 2 e 12): ");
            int aposta = sc.nextInt();
            sc.nextLine();

            if (!game.adicionarJogador(nome, aposta)) {
                i--; 
            }
        }

        int soma = game.jogarDados();
        game.verificarGanhadores(soma);

        System.out.println("\nJogo encerrado!");
        sc.close();
    }
}
