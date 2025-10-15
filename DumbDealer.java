public class DumbDealer extends Dealer {
    @Override
    public void playTurn(Deck deck) {
        System.out.println("\nDumb Dealer's turn...");
        // Dumb logic: hits until 19 even if busts
        while (hand.score() < 19) {
            takeCard(deck);
            System.out.println("Dumb Dealer draws a card. Hand: "
                    + hand + " (Score: " + hand.score() + ")");
        }
        System.out.println("Dumb Dealer stands. Final score: " + hand.score());
    }
}
