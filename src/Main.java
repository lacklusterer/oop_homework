import game.Session;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean playAgain = true;
        Scanner scanner = new Scanner(System.in);

        while (playAgain) {
            System.out.println("How many players?");
            int humanCount = 0;
            try {
                humanCount = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                continue;
            }

            Session session = new Session(humanCount);
            session.startGame();

            System.out.println("Do you want to start a new game? (y/n)");
            String playAgainOption = scanner.nextLine();

            if (!playAgainOption.equalsIgnoreCase("y")) {
                playAgain = false;
            }
        }

        System.out.println("Goodbye!");
    }
}
