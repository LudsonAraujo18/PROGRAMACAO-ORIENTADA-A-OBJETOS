package model;

public class Player {
    private String username;
    private int aposta;
    private int vitorias;

    public Player(String username, int aposta) {
        this.username = username;
        this.aposta = aposta;
        this.vitorias = 0;
    }

    public String getUsername() {
        return username;
    }

    public int getAposta() {
        return aposta;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void adicionarVitoria() {
        vitorias++;
    }

    @Override
    public String toString() {
        return username + " - Vitórias: " + vitorias;
    }
}
