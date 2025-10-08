public class Dealer extends Person {
    public Dealer() {
        super("Dealer");
    }

    @Override
    public void playTurn(Deck deck) {
        System.out.println("Dealer's turn...");
        while (hand.score() < 17) {
            takeCard(deck);
            System.out.println("Dealer draws a card. Current hand: " + hand + " (Score: " + hand.score() + ")");
        }
    }
}