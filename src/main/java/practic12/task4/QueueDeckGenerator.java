package practic12.task4;

import java.util.*;

public class QueueDeckGenerator implements DeckGenerator<Integer> {

    private final int amountCardsInOneDeck;

    public QueueDeckGenerator(int amountCardsInOneDeck) {
        this.amountCardsInOneDeck = amountCardsInOneDeck;
    }

    @Override
    public Pair<DeckCollection<Integer>> generate() {
        Queue<Integer> first = new ArrayDeque<>();
        Queue<Integer> second = new ArrayDeque<>();

        List<Integer> allCards = new ArrayList<>();
        for (int card = 0; card < amountCardsInOneDeck * 2; ++card) {
            allCards.add(card);
        }
        Collections.shuffle(allCards);

        copyTo(allCards, first, 0, amountCardsInOneDeck);
        copyTo(allCards, second, amountCardsInOneDeck, amountCardsInOneDeck * 2);

        return new Pair<>(new QueueDeckCollection(first), new QueueDeckCollection(second));
    }

    private void copyTo(List<Integer> allCards, Queue<Integer> destination, int sourceStart, int sourceEnd) {
        for (int idxNum = sourceStart; idxNum < sourceEnd; ++idxNum) {
            destination.add(allCards.get(idxNum));
        }
    }
}
