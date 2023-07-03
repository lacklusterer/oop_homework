package test;

import game.Dice;
import java.util.Map;
import java.util.HashMap;

public class probability_test {
    public static void main(String[] args) {
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice();
        Dice dice4 = new Dice();

        System.out.println(dice2.getId());

        int n = 1000000; // Number of times to roll the dice

        // Map to store the occurrences of each outcome
        Map<Integer, Integer> outcomes = new HashMap<>();

        // Roll the dice n times
        for (int i = 0; i < n; i++) {
            int result = dice2.roll();
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

