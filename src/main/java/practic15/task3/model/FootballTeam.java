package practic15.task3.model;

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