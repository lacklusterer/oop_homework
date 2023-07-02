package game;

import player.Player;

import java.util.List;

public class Turn {
    private List<Player> players;

    public Turn(List<Player> players) {
        this.players = players;
    }

    public void printScoreboard() {
        System.out.println("Scoreboard:");

        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore());
        }
    }
}
