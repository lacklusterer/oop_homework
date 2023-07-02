package game;

import player.Bot;
import player.Human;
import player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Session {
    private List<Player> players;
    private int humanCount;
    private int botCount;

    private boolean gameOver;
    private int turn = 0;

    public Session(int humanCount) {
        this.humanCount = humanCount;
        this.botCount = 4 - humanCount;
        this.players = new ArrayList<>();
        this.gameOver = false;
        initPlayers();
    }

    private void startTurn() {
        Turn turn = new Turn(players);
        System.out.println("Start of turn " + 1);
    }

    private void initPlayers() {
        // Add players
        for (int i = 0; i < humanCount; i++) {
            players.add(new Human("Human " + (i + 1)));
        }
        for (int i = 0; i < botCount; i++) {
            players.add(new Bot("Bot " + (i + 1)));
        }

        // Create 4 die
        List<Dice> diceList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            diceList.add(new Dice());
        }

        // Randomly give players die
        Random random = new Random();
        for (Player player : players) {
            int randomDiceIndex = random.nextInt(diceList.size());
            player.giveDice(diceList.remove(randomDiceIndex));
        }
    }

    public void startGame() {
        initPlayers();
        while (!gameOver) {
            startTurn();
        }
    }

    public void endGame(Player winner) {
        gameOver = true;
        System.out.println("Winner: " + winner.getName());
    }
}
