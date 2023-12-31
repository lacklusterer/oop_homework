package game;

import player.Player;

import java.util.List;

public class Turn {
    private List<Player> players;
    int currentTurn;

    public Turn(int currentTurn, List<Player> players) {
        this.players = players;
        this.currentTurn = currentTurn;
    }

    public void printTurnInfo() {
        System.out.println("_____________________________________");
        System.out.print("Current turn: " + currentTurn + "\n" + "Scoreboard:" + "\n");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore());
        }
    }

    public void playersPlayTurn() {
        for (Player player : players) {
            System.out.println(player.getName() + "'s turn!");
            player.makeMove();
            System.out.println(player.getName() + "'s current score is " + player.getScore());
        }
        printTurnInfo();
    }
}
