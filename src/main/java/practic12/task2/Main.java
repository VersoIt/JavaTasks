package practic12.task2;

import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringToQueueMapper mapper = new StringToQueueMapper();
        Queue<Integer> firstDeck = mapper.convert(scanner.nextLine());
        Queue<Integer> secondDeck = mapper.convert(scanner.nextLine());

        GameVisitor game = new GameVisitor();

        QueueDeckCollection firstDeckCollection = new QueueDeckCollection(firstDeck);
        QueueDeckCollection secondDeckCollection = new QueueDeckCollection(secondDeck);

        Player firstPlayer = new Player(firstDeckCollection, game);
        Player secondPlayer = new Player(secondDeckCollection, game);

        firstPlayer.accept(secondPlayer);
    }
}
