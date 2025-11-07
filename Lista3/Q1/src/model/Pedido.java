package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Pedido {
    private static int contador = 1;

    private int codigo;
    private LocalDate dataCompra;
    private LocalTime horaCompra;
    private LocalTime horaEntrega;
    private String enderecoEntrega;
    private int quantidade;
    private double precoUnitario = 120.0; // valor médio do botijão
    private double total;
    private String numeroCartao;
    private String status;

    public Pedido(LocalDate dataCompra, LocalTime horaCompra, String enderecoEntrega) {
        this.codigo = contador++;
        this.dataCompra = dataCompra;
        this.horaCompra = horaCompra;
        this.enderecoEntrega = enderecoEntrega;
        this.status = "em aberto";
    }

    public void confirmarPedido(int quantidade, String numeroCartao) {
        this.quantidade = quantidade;
        this.numeroCartao = numeroCartao;
        this.total = quantidade * precoUnitario;

        this.horaEntrega = horaCompra.plusHours(2);
        if (horaEntrega.isBefore(horaCompra)) {
            dataCompra = dataCompra.plusDays(1);
        }

        this.status = "confirmado";
    }

    public void entregar() {
        this.status = "entregue";
    }

    public int getCodigo() {
        return codigo;
    }

    public String getStatus() {
        return status;
    }

    public void setEnderecoEntrega(String novoEndereco) {
        this.enderecoEntrega = novoEndereco;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        return "\n===== Pedido " + codigo + " =====" +
                "\nData da compra: " + dataCompra +
                "\nHora da compra: " + horaCompra.format(formatoHora) +
                "\nEndereço: " + enderecoEntrega +
                "\nQuantidade: " + quantidade +
                "\nPreço unitário: R$" + precoUnitario +
                "\nTotal: R$" + total +
                "\nHora entrega: " + (horaEntrega != null ? horaEntrega.format(formatoHora) : "-") +
                "\nStatus: " + status;
    }
}
