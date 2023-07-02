import game.Session;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("How many players?");
        Scanner scanner = new Scanner(System.in);
        int humanCount = Integer.parseInt(scanner.nextLine());

        Session session = new Session(humanCount);
        session.startGame();
    }
}
