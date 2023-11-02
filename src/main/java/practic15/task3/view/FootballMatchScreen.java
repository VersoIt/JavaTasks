package practic15.task3.view;

import practic15.task3.controller.FootballMatchController;
import practic15.task3.model.FootballMatch;
import practic15.task3.model.FootballTeam;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Flow;

public class FootballMatchScreen extends JFrame implements Flow.Subscriber<FootballMatch>, FootballMatchView {

    private FootballMatchController controller;

    private Flow.Subscription subscription;

    private AbstractButton increaseFirstTeamButton;

    private AbstractButton increaseSecondTeamButton;

    private JLabel resultView;
    private JLabel counterView;
    private JLabel winnerView;
    private JLabel lastScorerView;

    public FootballMatchScreen() {
        inflateUI();
    }

    public static void main(String[] args) {
        FootballMatchScreen footballMatchScreen = new FootballMatchScreen();
        FootballMatchController controller = new FootballMatchController(footballMatchScreen, footballMatchScreen, new FootballMatch());
        footballMatchScreen.setController(controller);
    }

    private void inflateUI() {
        initSettings();
        createUI();
        setEventsToUI();
        combineViewsToComponents();

        setVisible(true);
    }

    private void createUI() {
        resultView = new JLabel();
        counterView = new JLabel();
        winnerView = new JLabel();
        lastScorerView = new JLabel();

        increaseFirstTeamButton = new JButton();
        increaseFirstTeamButton.setPreferredSize(new Dimension(1, 1));
        increaseSecondTeamButton = new JButton();
    }

    public void setController(FootballMatchController controller) {
        this.controller = controller;
    }

    private void combineViewsToComponents() {
        JPanel jpanel = new JPanel(new BorderLayout());

        JPanel increaseFirstTeamButtonPanel = new JPanel(new GridBagLayout());
        increaseFirstTeamButton.setPreferredSize(new Dimension(200, 30));

        JPanel increaseSecondTeamButtonPanel = new JPanel(new GridBagLayout());
        increaseSecondTeamButton.setPreferredSize(new Dimension(200, 30));

        JPanel center = new JPanel(new BorderLayout());
        center.add(resultView, BorderLayout.NORTH);
        center.add(winnerView, BorderLayout.CENTER);
        jpanel.add(center);

        increaseFirstTeamButtonPanel.add(increaseFirstTeamButton);
        increaseSecondTeamButtonPanel.add(increaseSecondTeamButton);

        jpanel.add(increaseFirstTeamButtonPanel, BorderLayout.WEST);
        jpanel.add(increaseSecondTeamButtonPanel, BorderLayout.EAST);

        jpanel.add(counterView, BorderLayout.SOUTH);
        jpanel.add(lastScorerView, BorderLayout.NORTH);

        add(jpanel);
    }

    private void setEventsToUI() {
        increaseFirstTeamButton.addActionListener(e -> {
            controller.increaseFirstTeamScore();
            subscription.request(1);
        });

        increaseSecondTeamButton.addActionListener(e -> {
            controller.increaseSecondTeamScore();
            subscription.request(1);
        });
    }

    private void initSettings() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
    }

    private void updateUiFrom(FootballMatch match) {
        increaseFirstTeamButton.setText(match.getFirstTeam().getName());
        increaseSecondTeamButton.setText(match.getSecondTeam().getName());

        resultView.setText(String.format("Result: %d X %d", match.getFirstTeam().getScore(), match.getSecondTeam().getScore()));
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(FootballMatch item) {
        updateUiFrom(item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.printf("%s: %s%n", "ERROR: ", throwable.getMessage());
    }

    @Override
    public void onComplete() {
    }

    @Override
    public void setRemainingMatchTime(int seconds) {
        counterView.setText(String.format("Remaining: %d", seconds));
    }

    @Override
    public void setWinner(FootballTeam team) {
        String teamName = team != null ? team.getName() : "nothing";
        winnerView.setText(String.format("Winner: %s", teamName));
    }

    @Override
    public void setLastScorer(FootballTeam team) {
        lastScorerView.setText(String.format("Last scorer: %s", team.getName()));
    }
}
