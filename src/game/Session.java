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
        addPlayers();
    }

    private void addPlayers() {
        for (int i = 0; i < humanCount; i++) {
            players.add(new Human("Human " + (i + 1)));
        }
        for (int i = 0; i < botCount; i++) {
            players.add(new Bot("Bot " + (i + 1)));
        }
    }

    private void startTurn(int turn) {
        System.out.println("Start of turn " + turn);
        this.turn++;
    }

    private void initPlayers() {
        List<Dice> diceList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            diceList.add(new Dice());
        }

        for (Player player : players) {
            Random random = new Random();
            int randomDiceIndex = random.nextInt(diceList.size());
            Dice randomDice = diceList.get(randomDiceIndex);
            player.giveDice(randomDice);
            diceList.remove(randomDiceIndex);
        }
    }

    public void startGame() {
        initPlayers();
        while (!gameOver) {
            startTurn(1);
        }
    }

    private void endGame(Player winner) {
        gameOver = true;
    }
}
