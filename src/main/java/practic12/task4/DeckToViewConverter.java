package practic12.task4;

import java.util.Queue;

public interface DeckToViewConverter<T, K> {

    T convert(Queue<K> deck);
}
