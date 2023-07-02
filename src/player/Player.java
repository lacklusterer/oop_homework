package player;

import game.Dice;

public abstract class Player {
    private static int playerNumber = 0;
    private int id;

    protected String name;
    private int score;
    private Dice dice;

    {
        playerNumber++;
        id = playerNumber;
    } // Id instance initializer

    public Player(String name) {
        this.name = name;
        this.score = 0;
        System.out.println("Player " + name + " joined!");
    }

    public String getName() {return name;}

    public int getScore() {return score;}

    public int getId() {return id;}

    public void giveDice(Dice dice) {this.dice = dice;}

    public void rollDice() {
        int result = dice.roll();
        score += result;
        System.out.println(name + " rolled a " + result);
    }

    public abstract void makeMove();
}
