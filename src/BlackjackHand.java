public class BlackjackHand extends Hand {
    @Override
    public int score() {
        int total = 0;
        int aces = 0;

        for (Card c : cards) {
            total += c.getValue();
            if (c.getRank().equals("A")) {
                aces++;
            }
        }

        // Adjust for Aces if score is over 21
        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }

        return total;
    }
}