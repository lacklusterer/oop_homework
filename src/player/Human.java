package player;

import java.util.Scanner;

public class Human extends Player{
    public Human(String name) {
        super(name);
    }

    @Override
    public void makeMove() {
        System.out.println("Press any button to roll the dice.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        rollDice();
    }
}
