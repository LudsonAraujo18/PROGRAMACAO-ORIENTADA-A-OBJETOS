package view;

import java.util.Scanner;
import model.Robo;
import controller.SalaController;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Robo r1 = new Robo(0, 0, 1);
        SalaController sala = new SalaController();

        int opcao;

        System.out.println("=== SIMULADOR DE ROBÔ ===");

        do {
            sala.mostrarSala(r1);
            r1.mostrarPosicaoAtual();

            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Andar para Frente");
            System.out.println("2 - Andar para Trás");
            System.out.println("3 - Andar para Direita");
            System.out.println("4 - Andar para Esquerda");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> r1.andarFrente();
                case 2 -> r1.andarTras(sala.getLinhas());
                case 3 -> r1.andarDireita(sala.getColunas());
                case 4 -> r1.andarEsquerda();
                case 0 -> System.out.println("Encerrando o programa...");
                default -> System.out.println("Opção inválida!");
            }

            System.out.println();
        } while (opcao != 0);

        sc.close();
    }
}
