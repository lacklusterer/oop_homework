package test;

import game.Dice;

import java.util.*;

public class probability_test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Dice> listDice = new ArrayList<Dice>();
        for (int i = 1; i <= 4; i++) {
            listDice.add(new Dice());
        }

        int chosenDiceIndex = 0;

        System.out.println("Test which dice?");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1, 2, 3, 4 -> chosenDiceIndex = choice-1;
            default -> System.out.println("Invalid choice");
        }

        Dice chosenDice = listDice.get(chosenDiceIndex);

        System.out.println(chosenDice.getId());

        int n = 1000000; // Number of times to roll the dice

        // Map to store the occurrences of each outcome
        Map<Integer, Integer> outcomes = new HashMap<>();

        // Roll the dice n times
        for (int i = 0; i < n; i++) {
            int result = chosenDice.roll();
            outcomes.put(result, outcomes.getOrDefault(result, 0) + 1);
        }

        // Calculate and display the probability for each outcome
        System.out.println("Outcome\tProbability");
        for (int outcome : outcomes.keySet()) {
            int count = outcomes.get(outcome);
            double probability = (double) count / n;
            System.out.println(outcome + "\t\t" + probability);
        }
    }
}
