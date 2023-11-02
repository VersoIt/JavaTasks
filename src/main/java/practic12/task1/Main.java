package practic12.task1;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringToStackMapper mapper = new StringToStackMapper();
        Stack<Integer> firstDeck = mapper.convert(scanner.nextLine());
        Stack<Integer> secondDeck = mapper.convert(scanner.nextLine());

        GameVisitor game = new GameVisitor();

        StackDeckCollection firstDeckCollection = new StackDeckCollection(firstDeck);
        StackDeckCollection secondDeckCollection = new StackDeckCollection(secondDeck);

        Player firstPlayer = new Player(firstDeckCollection, game);
        Player secondPlayer = new Player(secondDeckCollection, game);

        firstPlayer.accept(secondPlayer);
    }
}
