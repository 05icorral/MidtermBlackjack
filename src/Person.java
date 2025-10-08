public abstract class Person {
    protected String name;
    protected BlackjackHand hand = new BlackjackHand();

    public Person(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public BlackjackHand getHand() { return hand; }

    public void takeCard(Deck deck) {
        hand.addCard(deck.dealCard());
    }

    public void resetHand() {
        hand.clear();
    }

    public int getScore() {
        return hand.score();
    }

    // Each subclass decides how they play their turn
    public abstract void playTurn(Deck deck);
}