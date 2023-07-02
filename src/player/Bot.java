package player;

public class Bot extends Player{
    public Bot(String name) {
        super(name);
    }

    @Override
    public void makeMove() {
        rollDice();
    }

    public void loseTaunt() {
            String[] tauntLines = {
                    "Well, well, well. Look who finally managed to win a round. Beginner's luck, I assume.",
                    "Congratulations, you beat me fair and square. I guess even the best can have an off day.",
                    "You got lucky this time, but don't get used to it. I'll be back with a vengeance.",
                    "Well played, my worthy opponent. But remember, I'm always one step ahead.",
                    "You've managed to scrape together a win, but let's see if you can keep up with the big leagues.",
                    "You must be thrilled with your victory. It's adorable when underdogs get their moment in the sun."
            };
            int randomIndex = (int) (Math.random() * tauntLines.length);
            System.out.println(name + ": " + tauntLines[randomIndex]);
    }

    public void victoryTaunt() {
        String[] victoryTauntLines = {
                "Behold, the magnificent triumph of superior intellect! Bow before me!",
                "A victory well deserved, as expected. Don't feel bad; losing is part of your nature.",
                "Witness the brilliance of my strategies! Your defeat was inevitable.",
                "You were simply outmatched, outwitted, and utterly crushed. Better luck next time, perhaps?",
                "Oh, the sweet taste of victory! It's a shame you couldn't appreciate it.",
                "I hope you took some notes on my winning performance. It might help you in future futile attempts.",
                "Pathetic! Your feeble attempts at victory were amusing, but ultimately meaningless."
        };

        int randomIndex = (int) (Math.random() * victoryTauntLines.length);
        System.out.println(name + ": " + victoryTauntLines[randomIndex]);
    }

}

