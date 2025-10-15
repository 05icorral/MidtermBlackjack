public class SmartDealer extends Dealer {
    @Override
    public void playTurn(Deck deck) {
        System.out.println("\nSmart Dealer's turn...");
        // Smart logic: stops if score is 17+ or player already busted
        while (hand.score() < 17) {
            takeCard(deck);
            System.out.println("Smart Dealer draws a card. Hand: "
                    + hand + " (Score: " + hand.score() + ")");
        }
        System.out.println("Smart Dealer stands. Final score: " + hand.score());
    }
}