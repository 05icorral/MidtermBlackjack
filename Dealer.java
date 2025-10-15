public class Dealer extends Person {
    public Dealer() {
        super("Dealer");
    }

    @Override
    public void playTurn(Deck deck) {
        // Default or placeholder behavior
        System.out.println("Dealer is ready to play...");
    }
}