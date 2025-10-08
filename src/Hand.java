public class Hand extends CardCollection {
    public int score() {
        int total = 0;
        for (Card c : cards) {
            total += c.getValue();
        }
        return total;
    }
}
