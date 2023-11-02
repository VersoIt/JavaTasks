package practic7.task1.controller;

import practic7.task1.model.FootballMatch;
import practic7.task1.view.FootballMatchView;

import java.util.concurrent.Flow;

public class FootballMatchController {

    private final FootballMatchView view;

    private final FootballMatch model;

    private final Flow.Subscriber<FootballMatch> viewSubscriber;

    private boolean isMatchEnded = false;

    public FootballMatchController(FootballMatchView view, Flow.Subscriber<FootballMatch> viewSubscriber, FootballMatch model) {
        this.view = view;
        this.viewSubscriber = viewSubscriber;
        this.model = model;

        subscribeViewToModel();
        initMatchTimer();
    }

    private void initMatchTimer() {
        MatchCounter timeCounter = new FootballMatchTimeCounter(10);
        timeCounter.onCount(remaining -> {

            view.setRemainingMatchTime(Math.max(remaining, 0));
            if (remaining <= 0) {
                isMatchEnded = true;
                if (model.getFirstTeam().getScore() > model.getSecondTeam().getScore()) {
                    view.setWinner(model.getFirstTeam());
                } else if (model.getFirstTeam().getScore() < model.getSecondTeam().getScore()) {
                    view.setWinner(model.getSecondTeam());
                } else {
                    view.setWinner(null);
                }
            }
        });
        timeCounter.start();
    }

    private void subscribeViewToModel() {
        model.getPublisher().subscribe(viewSubscriber);
        model.notifySubscribers();
    }

    public void increaseFirstTeamScore() {
        if (!isMatchEnded) {
            view.setLastScorer(model.getFirstTeam());
            model.increaseScoreInFirstTeam();
        }
    }

    public void increaseSecondTeamScore() {
        if (!isMatchEnded) {
            view.setLastScorer(model.getSecondTeam());
            model.increaseScoreInSecondTeam();
        }
    }
}
