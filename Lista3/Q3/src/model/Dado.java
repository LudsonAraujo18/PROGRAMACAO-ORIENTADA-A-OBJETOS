package model;

import java.util.Random;

public class Dado {
    private final Random random = new Random();

    public int rolar() {
        return random.nextInt(6) + 1; // número entre 1 e 6
    }
}
