package practic12.task4;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

import static practic12.task4.GameVisitor.ENDING_STEPS;

public class GameScreen extends JFrame implements PawnVisitor {

    private final int cardsInOneDeck;

    private final DeckToViewConverter<String, Integer> deckToViewConverter = new DeckToStringViewConverter();

    private JPanel mainPanel;

    private JLabel computerLabel;
    private JLabel playerDeck;
    private JLabel computerDeck;

    private JLabel playerLabel;

    private int steps = 0;

    private JButton startButton;

    private JButton moveButton;

    private Queue<Integer> playerCards;

    private Queue<Integer> computerCards;

    public GameScreen(int cardsInOneDeck) {
        this.cardsInOneDeck = cardsInOneDeck;

        initSettings();
        initGameFrame();
        showWelcomeFrame();
        initPlayersCards();
    }

    private void initPlayersCards() {
        playerCards = new LinkedList<>();
        computerCards = new LinkedList<>();

        for (int i = 0; i < cardsInOneDeck; ++i) {
            playerCards.add(null);
            computerCards.add(null);
        }
    }

    private void initSettings() {
        setTitle("Пьяница");
        initUiComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        add(mainPanel);
        setVisible(true);
    }

    private void showWelcomeFrame() {
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        startButton.addActionListener(e -> {
            startButton.setVisible(false);
            showGameFrame();
        });

        mainPanel.add(startButton);
    }

    private void showGameFrame() {
        computerLabel.setVisible(true);
        playerLabel.setVisible(true);
        moveButton.setVisible(true);
        playerDeck.setVisible(true);
        computerDeck.setVisible(true);
    }

    private void initGameFrame() {
        computerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        playerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        moveButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(computerLabel);
        mainPanel.add(computerDeck);
        mainPanel.add(playerLabel);
        mainPanel.add(playerDeck);
        mainPanel.add(moveButton);

        add(mainPanel);

        computerLabel.setVisible(false);
        playerLabel.setVisible(false);
        moveButton.setVisible(false);
        computerDeck.setVisible(false);
        playerDeck.setVisible(false);
    }

    private void initUiComponents() {
        startButton = new JButton("Начать");
        computerLabel = new JLabel("Компьютер");
        playerLabel = new JLabel("Вы");
        moveButton = new JButton("Ходить");
        playerDeck = new JLabel();
        computerDeck = new JLabel();
    }

    public static void main(String[] args) {

        final int amountCardsInOneDeck = 5;
        GameScreen gameScreen = new GameScreen(amountCardsInOneDeck);

        DeckGenerator<Integer> deckGenerator = new QueueDeckGenerator(amountCardsInOneDeck);
        Pair<DeckCollection<Integer>> decks = deckGenerator.generate();

        Pawn player = new Pawn(decks.getFirst(), gameScreen);
        Pawn computer = new Pawn(decks.getSecond(), gameScreen);

        gameScreen.accept(player, computer);
    }

    @Override
    public void accept(DeckPlayer player, DeckPlayer computer) {

        if (steps++ == 0) {
            moveButton.addActionListener(e -> accept(player, computer));
        } else {
            if (steps == ENDING_STEPS) {
                JOptionPane.showMessageDialog(this, "botva");
                System.exit(0);
                return;
            }

            int playerCard = player.getDeck().get();
            int computerCard = computer.getDeck().get();

            if (playerCard == 0 && computerCard == 9) {
                splitCards(player, playerCard, computerCard);

                computerCards.remove();
                playerCards.remove();
                playerCards.add(playerCard);
                playerCards.add(computerCard);
            }
            else if (playerCard == 9 && computerCard == 0) {
                splitCards(computer, computerCard, playerCard);

                playerCards.remove();
                computerCards.remove();
                computerCards.add(computerCard);
                computerCards.add(playerCard);
            }
            else if (playerCard > computerCard) {
                splitCards(player, playerCard, computerCard);

                computerCards.remove();
                playerCards.remove();
                playerCards.add(playerCard);
                playerCards.add(computerCard);
            }
            else if (playerCard < computerCard) {
                splitCards(computer, computerCard, playerCard);

                playerCards.remove();
                computerCards.remove();
                computerCards.add(computerCard);
                computerCards.add(playerCard);
            }
            else {
                JOptionPane.showMessageDialog(this, "Something went wrong...");
                System.exit(0);
                return;
            }

            if (player.getDeck().getLength() == 0) {
                JOptionPane.showMessageDialog(this, "Computer winner: " + (steps - 1) + " steps");
                System.exit(0);
                return;
            }

            if (computer.getDeck().getLength() == 0) {
                JOptionPane.showMessageDialog(this, "You winner: " + (steps - 1) + " steps");
                System.exit(0);
            }
        }

        playerDeck.setText(deckToViewConverter.convert(playerCards));
        computerDeck.setText(deckToViewConverter.convert(computerCards));
    }


    private void splitCards(DeckPlayer winner, int winnerCard, int loserCard) {
        winner.getDeck().add(winnerCard);
        winner.getDeck().add(loserCard);
    }
}
