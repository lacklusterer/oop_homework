package player;

import game.Dice;

public class Player {
    private static int playerNumber = 0;
    private int id;

    private String name;
    private int score;
    private boolean bot;

    {
        playerNumber++;
        id = playerNumber;
    }

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
