import java.util.*;

public abstract class CardCollection {
    protected final List<Card> cards = new ArrayList<>();

    public void addCard(Card c) { cards.add(c); }
    public void clear() { cards.clear(); }
    public List<Card> getCards() { return Collections.unmodifiableList(cards); }

    @Override
    public String toString() {
        return cards.toString();
    }
}

