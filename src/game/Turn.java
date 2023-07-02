package game;

import player.Player;

import java.util.List;

public class Turn {
    private List<Player> players;
    int currentTurn;

    public Turn(int currentTurn, List<Player> players) {
        this.players = players;
        this.currentTurn = currentTurn;
        printTurnInfo();
    }

    public void printTurnInfo() {
        System.out.print("Current turn: " + currentTurn + "\n" + "Scoreboard:" + "\n");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore());
        }
    }
}
