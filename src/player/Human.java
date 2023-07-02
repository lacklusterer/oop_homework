package player;

import java.util.Scanner;

public class Human extends Player{
    public Human(String name) {
        super(name);
    }

    @Override
    public void makeMove() {
        System.out.println("Press any button to roll your dice.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        rollDice();
    }

    public void comment() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(name + ", do you want to make a comment? (y/n)");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("y")) {
            System.out.println("Please enter your comment:");
            String comment = scanner.nextLine();
            System.out.println("\n" + name + ": " + comment);
        }
    }
}
