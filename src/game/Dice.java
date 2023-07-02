package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Dice {
    private static int diceNumber = 0;
    private int diceID;
    private Random random;

    ArrayList<Integer> sides = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

    {
        diceNumber++;
        diceID = diceNumber;
    }

    public Dice() {
        this.random = new Random();
        sides.remove(Integer.valueOf(diceID));
    }

    public int roll() {
        int chance = random.nextInt(100) + 1;

        if (chance <= 20) {
            return diceID;
        } else {
            return sides.get(random.nextInt(5));
        }
    }

    public int getId() {
        return diceID;
    }
}