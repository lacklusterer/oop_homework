package player;

public class Bot extends Player{
    public Bot(String name) {
        super(name);
    }

    @Override
    public void makeMove() {
        rollDice();
    }

    public void taunt() {
        int randomIndex = (int) (Math.random() * 5);

        switch (randomIndex) {
            case 0 -> System.out.println("Oh, I see, you think you're good? Just lucky, I suppose.");
            case 1 ->
                    System.out.println("Congratulations, you won. But remember, even a broken clock is right twice a day.");
            case 2 ->
                    System.out.println("You beat me fair and square. But don't get too cocky; I'm just getting started.");
            case 3 ->
                    System.out.println("Well, well, well. Looks like you stumbled upon a win. Enjoy it while it lasts.");
            case 4 ->
                    System.out.println("You must have a horseshoe hidden somewhere. Luck can't explain your victory.");
        }
    }
}
