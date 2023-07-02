package player;

import game.Dice;

public abstract class Player {
    private static int playerNumber = 0;
    private int id;

    private String name;
    private int score;
    private Dice dice;

    {
        playerNumber++;
        id = playerNumber;
    }

    public Player(String name) {
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getId() {
        return id;
    }

    public void giveDice(Dice dice) {
        this.dice = dice;
    }

    public void rollDice() {
        int result = dice.roll();
        score += result;
        System.out.println(name + " rolled a " + result);
    }

    public abstract void makeMove();
}
