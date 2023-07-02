package player;

import game.Dice;

public class Player {
    private String name;
    private int score;

    public Player() {
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void rollDice(Dice dice) {
        score += dice.roll();
    }
}
