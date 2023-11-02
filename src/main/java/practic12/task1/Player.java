package practic12.task1;

import java.util.List;

public class Player implements DeckPlayer {

    private final DeckCollection<Integer> deck;

    private final PlayerVisitor visitor;

    public Player(DeckCollection<Integer> deck, PlayerVisitor visitor) {
        this.deck = deck;
        this.visitor = visitor;
    }

    public void accept(DeckPlayer other) {
        visitor.accept(this, other);
    }

    public DeckCollection<Integer> getDeck() {
        return deck;
    }
}
