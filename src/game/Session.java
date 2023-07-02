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
    private int currentTurn = 0;

    public Session(int humanCount) {
        this.humanCount = humanCount;
        this.botCount = 4 - humanCount;
        this.players = new ArrayList<>();
        this.gameOver = false;
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
            startTurn(this.players);
        }
    }

    private void startTurn(List<Player> players) {
        System.out.println("_____________________________________");
        currentTurn++;
        Turn turn = new Turn(currentTurn, players);
        turn.playersPlayTurn();
        checkWinner();
    }

    private void checkWinner() {
        Player winner = null;
        ArrayList<Player> tieBreakPlayers = new ArrayList<>();

        for (Player player : players) {
            if (player.getScore() >= 21) {
                if (winner == null) {
                    winner = player;
                } else if (player.getScore() > winner.getScore()) {
                    winner = player;
                } else if (player.getScore() == winner.getScore()) {
                    tieBreakPlayers.add(winner);
                    tieBreakPlayers.add(player);
                }
            }
        }

        if (tieBreakPlayers.size() > 0) {
            System.out.println("Tie Breaker Round!");
            startTurn(tieBreakPlayers);
        } else if (winner != null) {
            endGame(winner);
        }
    }

    private void endGame(Player winner) {
        gameOver = true;

        System.out.println("#####################################");
        System.out.println("Winner: " + winner.getName());

        // Human comment
        for (Player human : players)
            if (human instanceof Human) {
                ((Human) human).comment();
            }

        // Bot taunts
        if (winner instanceof Bot) {
            ((Bot) winner).victoryTaunt();
            players.remove(winner);
        }

        for (Player bot : players) {
            if (bot instanceof Bot) {
                ((Bot) bot).loseTaunt();
            }
        }
    }
}
