package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Dice {
    private static int nextId = 1;
    private int id;
    private Random random;

    ArrayList<Integer> sides = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

    public Dice() {
        this.id = nextId;
        this.random = new Random();
        nextId++;
        sides.remove(Integer.valueOf(id));
    }

    public int roll() {
        int chance = random.nextInt(100) + 1;

        if (chance <= 20) {
            return id;
        } else {
            return sides.get(random.nextInt(5));
        }
    }

    public int getId() {
        return id;
    }
}