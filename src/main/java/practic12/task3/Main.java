package practic12.task3;

import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringToDequeMapper mapper = new StringToDequeMapper();
        Deque<Integer> firstDeck = mapper.convert(scanner.nextLine());
        Deque<Integer> secondDeck = mapper.convert(scanner.nextLine());

        GameVisitor game = new GameVisitor();

        DeqeueDeckCollection firstDeckCollection = new DeqeueDeckCollection(firstDeck);
        DeqeueDeckCollection secondDeckCollection = new DeqeueDeckCollection(secondDeck);

        Player firstPlayer = new Player(firstDeckCollection, game);
        Player secondPlayer = new Player(secondDeckCollection, game);

        firstPlayer.accept(secondPlayer);
    }
}
