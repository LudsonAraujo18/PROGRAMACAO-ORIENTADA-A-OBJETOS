package view;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import model.Pedido;
import controller.PedidoController;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PedidoController controller = new PedidoController();

        int opcao;

        do {
            System.out.println("\n==== MENU ====");
            System.out.println("1 - Fazer pedido");
            System.out.println("2 - Confirmar entrega");
            System.out.println("3 - Ver pedidos confirmados");
            System.out.println("4 - Ver pedidos entregues");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> fazerPedido(sc, controller);
                case 2 -> confirmarEntrega(sc, controller);
                case 3 -> listarPedidos(controller, "confirmado");
                case 4 -> listarPedidos(controller, "entregue");
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }

    private static void fazerPedido(Scanner sc, PedidoController controller) {
        LocalDate data = LocalDate.now();
        LocalTime hora = LocalTime.now();

        System.out.print("Endereço de entrega: ");
        String endereco = sc.nextLine();

        Pedido p = new Pedido(data, hora, endereco);
        System.out.println("\nDados do pedido: " + p);

        System.out.print("Deseja alterar o endereço? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Novo endereço: ");
            p.setEnderecoEntrega(sc.nextLine());
            System.out.println("Endereço atualizado!\n" + p);
        }

        System.out.print("Deseja confirmar o pedido? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Quantidade de botijões: ");
            int qtd = sc.nextInt();
            sc.nextLine();
            System.out.print("Número do cartão de crédito: ");
            String cartao = sc.nextLine();

            p.confirmarPedido(qtd, cartao);
            controller.adicionarPedido(p);
            System.out.println("\nPedido confirmado com sucesso!");
            System.out.println(p);
        } else {
            System.out.println("Pedido cancelado!");
        }
    }

    private static void confirmarEntrega(Scanner sc, PedidoController controller) {
        System.out.print("Código do pedido: ");
        int cod = sc.nextInt();
        sc.nextLine();
        controller.confirmarEntrega(cod);
    }

    private static void listarPedidos(PedidoController controller, String status) {
        ArrayList<Pedido> lista = controller.listarPorStatus(status);
        if (lista.isEmpty()) {
            System.out.println("Nenhum pedido com status: " + status);
        } else {
            for (Pedido p : lista) {
                System.out.println(p);
            }
        }
    }
}
