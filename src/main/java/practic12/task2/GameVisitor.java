package practic12.task2;

public class GameVisitor implements PlayerVisitor {

    public static int ENDING_STEPS = 106;

    @Override
    public void accept(DeckPlayer firstPlayer, DeckPlayer secondPlayer) {
        if (firstPlayer.getDeck().getLength() != secondPlayer.getDeck().getLength()) {
            System.out.println("Неверные входные данные!");
            return;
        }


        int steps = 0;
        while (firstPlayer.getDeck().getLength() != 0 && secondPlayer.getDeck().getLength() != 0) {
            ++steps;

            if (steps == ENDING_STEPS) {
                System.out.println("botva");
                return;
            }

            int firstPlayerCard = firstPlayer.getDeck().get();
            int secondPlayerCard = secondPlayer.getDeck().get();

            if (firstPlayerCard == 0 && secondPlayerCard == 9) {
                splitCards(firstPlayer, firstPlayerCard, secondPlayerCard);
            } else if (firstPlayerCard == 9 && secondPlayerCard == 0) {
                splitCards(secondPlayer, secondPlayerCard, firstPlayerCard);
            } else if (firstPlayerCard > secondPlayerCard) {
                splitCards(firstPlayer, firstPlayerCard, secondPlayerCard);
            } else if (firstPlayerCard < secondPlayerCard) {
                splitCards(secondPlayer, secondPlayerCard, firstPlayerCard);
            } else {
                System.out.println("Something went wrong...");
                return;
            }
        }

        if (firstPlayer.getDeck().getLength() == 0) {
            System.out.printf("%s %d", "second", steps);
            return;
        }

        System.out.printf("%s %d", "first", steps);
    }

    private void splitCards(DeckPlayer winner, int winnerCard, int loserCard) {
        winner.getDeck().add(winnerCard);
        winner.getDeck().add(loserCard);
    }
}
