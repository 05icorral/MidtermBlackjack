public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player = new Player("Isaac", 100);
        Dealer dealer = new Dealer();

        // Initial deal
        player.takeCard(deck);
        player.takeCard(deck);
        dealer.takeCard(deck);
        dealer.takeCard(deck);

        System.out.println(player.getName() + "'s hand: " + player.getHand() + " (Score: " + player.getScore() + ")");
        System.out.println("Dealer shows: " + dealer.getHand().getCards().get(0));

        // Let the player play
        player.playTurn(deck);

        // Dealer plays if player didn’t bust
        if (player.getScore() <= 21) {
            dealer.playTurn(deck);
        }

        // Print results
        System.out.println("\n--- Results ---");
        System.out.println(player.getName() + ": " + player.getHand() + " (Score: " + player.getScore() + ")");
        System.out.println("Dealer: " + dealer.getHand() + " (Score: " + dealer.getScore() + ")");
    }
}