package practic7.task1.view;

import practic7.task1.model.FootballTeam;

public interface FootballMatchView {

    void setRemainingMatchTime(int seconds);

    void setWinner(FootballTeam team);

    void setLastScorer(FootballTeam team);
}
