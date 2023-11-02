package practic12.task4;

import java.util.Queue;

public class DeckToStringViewConverter implements DeckToViewConverter<String, Integer> {

    @Override
    public String convert(Queue<Integer> deck) {
        StringBuilder result = new StringBuilder();
        for (Integer element : deck) {
            result.append(element == null ? "?" : element).append(" ");
        }
        return result.toString();
    }
}
