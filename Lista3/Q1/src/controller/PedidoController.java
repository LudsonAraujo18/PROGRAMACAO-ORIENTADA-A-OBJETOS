package controller;

import model.Pedido;
import java.util.ArrayList;

public class PedidoController {

    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public void adicionarPedido(Pedido p) {
        pedidos.add(p);
    }

    public Pedido buscarPorCodigo(int codigo) {
        for (Pedido p : pedidos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Pedido> listarPorStatus(String status) {
        ArrayList<Pedido> lista = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getStatus().equalsIgnoreCase(status)) {
                lista.add(p);
            }
        }
        return lista;
    }

    public void confirmarEntrega(int codigo) {
        Pedido p = buscarPorCodigo(codigo);
        if (p != null) {
            p.entregar();
            System.out.println("Pedido entregue com sucesso!");
        } else {
            System.out.println("Pedido não localizado!");
        }
    }
}
