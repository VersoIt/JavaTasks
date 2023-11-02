package practic15.task3.view;

import practic15.task3.model.FootballTeam;

public interface FootballMatchView {

    void setRemainingMatchTime(int seconds);

    void setWinner(FootballTeam team);

    void setLastScorer(FootballTeam team);
}
