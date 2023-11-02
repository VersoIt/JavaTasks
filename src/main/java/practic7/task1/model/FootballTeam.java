package practic7.task1.model;

import java.util.Observable;
import java.util.concurrent.Flow;

public class FootballTeam {

    private final String name;

    private int score;

    public FootballTeam(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        ++score;
    }
}