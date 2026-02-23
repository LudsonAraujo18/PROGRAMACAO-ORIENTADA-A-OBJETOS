import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Elevador elevador = new Elevador();

        System.out.print("Informe a capacidade do elevador: ");
        int capacidade = scanner.nextInt();

        System.out.print("Informe o total de andares: ");
        int totalAndares = scanner.nextInt();

        elevador.inicializa(capacidade, totalAndares);

        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Entrar pessoa");
            System.out.println("2 - Sair pessoa");
            System.out.println("3 - Subir");
            System.out.println("4 - Descer");
            System.out.println("5 - Status");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    elevador.entrar();
                    break;
                case 2:
                    elevador.sai();
                    break;
                case 3:
                    elevador.subir();
                    break;
                case 4:
                    elevador.descer();
                    break;
                case 5:
                    System.out.println(elevador.status());
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}