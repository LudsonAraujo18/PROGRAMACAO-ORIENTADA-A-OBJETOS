package controller;

import java.io.*;
import java.util.*;
import model.Dado;
import model.Player;

public class GameController {
    private ArrayList<Player> jogadores = new ArrayList<>();
    private Dado dado1 = new Dado();
    private Dado dado2 = new Dado();
    private final String ARQUIVO = "ranking.txt";

    public boolean adicionarJogador(String username, int aposta) {
        for (Player p : jogadores) {
            if (p.getUsername().equalsIgnoreCase(username)) {
                System.out.println(" Já existe um jogador com esse nome!");
                return false;
            }
        }
        jogadores.add(new Player(username, aposta));
        return true;
    }

    public int jogarDados() {
        int soma = dado1.rolar() + dado2.rolar();
        System.out.println("\n Os dados foram lançados!");
        System.out.println("Dado 1: " + (soma / 2) + " | Dado 2: " + (soma - soma / 2));
        System.out.println("Soma total: " + soma);
        return soma;
    }

    public void verificarGanhadores(int soma) {
        ArrayList<Player> vencedores = new ArrayList<>();
        for (Player p : jogadores) {
            if (p.getAposta() == soma) {
                vencedores.add(p);
            }
        }

        if (vencedores.isEmpty()) {
            System.out.println("\n Nenhum jogador venceu. A máquina ganhou!");
        } else {
            System.out.println("\n VENCEDORES:");
            for (Player v : vencedores) {
                System.out.println(v.getUsername());
                atualizarRanking(v.getUsername());
            }
        }
    }

    public Map<String, Integer> carregarRanking() {
        Map<String, Integer> ranking = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 2) {
                    ranking.put(partes[0], Integer.parseInt(partes[1]));
                }
            }
        } catch (IOException e) {
        }
        return ranking;
    }

    private void atualizarRanking(String nome) {
        Map<String, Integer> ranking = carregarRanking();
        ranking.put(nome, ranking.getOrDefault(nome, 0) + 1);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Map.Entry<String, Integer> e : ranking.entrySet()) {
                bw.write(e.getKey() + ";" + e.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar ranking!");
        }
    }

    public void mostrarRanking() {
        Map<String, Integer> ranking = carregarRanking();
        if (ranking.isEmpty()) {
            System.out.println(" Nenhum vencedor registrado ainda!");
            return;
        }

        System.out.println("==== TOP 5 JOGADORES ====");
        ranking.entrySet().stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
            .limit(5)
            .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue() + " vitórias"));
        System.out.println("============================\n");
    }

    public ArrayList<Player> getJogadores() {
        return jogadores;
    }
}
