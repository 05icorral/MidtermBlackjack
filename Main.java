import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Only one scanner for the entire game
        Player player = new Player("Isaac", 100);

        boolean playAgain = true;

        while (playAgain) {
            Deck deck = new Deck();

            System.out.print("Choose dealer type (smart/dumb): ");
            String dealerType = sc.nextLine().toLowerCase();

            Dealer dealer;
            if (dealerType.equals("smart")) {
                dealer = new SmartDealer();
            } else {
                dealer = new DumbDealer();
            }

            // Initial deal
            player.takeCard(deck);
            player.takeCard(deck);
            dealer.takeCard(deck);
            dealer.takeCard(deck);

            System.out.println(player.getName() + "'s hand: " + player.getHand() + " (Score: " + player.getScore() + ")");
            System.out.println("Dealer shows: " + dealer.getHand().getCards().get(0));

            // Let the player play
            player.playTurn(deck);

            // Dealer plays if player didn't bust
            if (player.getScore() <= 21) {
                dealer.playTurn(deck);
            }

            // Betting results
            int bet = 10;
            if (player.getScore() > 21) {
                System.out.println("You busted! Dealer wins.");
                player.subtractMoney(bet);
            } else if (dealer.getScore() > 21) {
                System.out.println("Dealer busted! You win!");
                player.addMoney(bet);
            } else if (player.getScore() > dealer.getScore()) {
                System.out.println("You win!");
                player.addMoney(bet);
            } else if (player.getScore() < dealer.getScore()) {
                System.out.println("Dealer wins!");
                player.subtractMoney(bet);
            } else {
                System.out.println("It's a tie!");
            }

            System.out.println("Balance: $" + player.getMoney());

            // Ask if player wants to play again
            System.out.print("Play again? (y/n): ");
            String choice = sc.next().toLowerCase();

            if (!choice.startsWith("y")) {
                playAgain = false;
                System.out.println("Thanks for playing!");
            }

            // Clear hands for next round
            player.clearHand();
            dealer.clearHand();

        }
    }
}