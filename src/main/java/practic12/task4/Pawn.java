package practic12.task4;

public class Pawn implements DeckPlayer {

    private final DeckCollection<Integer> deck;

    private final PawnVisitor visitor;

    public Pawn(DeckCollection<Integer> deck, PawnVisitor visitor) {
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
