import java.util.Scanner;

public class Player extends Person {
    private int currency;

    public Player(String name, int startingMoney) {
        super(name);
        this.currency = startingMoney;
    }

    public int getMoney() {
        return currency;
    }

    public void addMoney(int amount) {
        currency += amount;
    }

    public void subtractMoney(int amount) {
        currency -= amount;
    }

    @Override
    public void playTurn(Deck deck) {
        Scanner sc = new Scanner(System.in);
        boolean continueTurn = true;

        while (continueTurn) {
            System.out.println(name + "'s hand: " + hand + " (Score: " + hand.score() + ")");
            if (hand.score() >= 21) break;

            System.out.print("Hit or Stand? ");
            String choice = sc.nextLine().toLowerCase();

            if (choice.startsWith("h")) {
                takeCard(deck);
            } else if (choice.startsWith("s")) {
                continueTurn = false;
            }
        }
    }
}