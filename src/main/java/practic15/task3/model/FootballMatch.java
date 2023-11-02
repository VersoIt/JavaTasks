package practic15.task3.model;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class FootballMatch {

    private final FootballTeam firstTeam = new FootballTeam("AC Milan", 0);

    private final FootballTeam secondTeam = new FootballTeam("RealMadrid", 0);

    private final SubmissionPublisher<FootballMatch> publisher = new SubmissionPublisher<>();

    public void increaseScoreInFirstTeam() {
        firstTeam.increaseScore();
        notifySubscribers();
    }

    public void increaseScoreInSecondTeam() {
        secondTeam.increaseScore();
        notifySubscribers();
    }

    public Flow.Publisher<FootballMatch> getPublisher() {
        return publisher;
    }

    @Override
    public String toString() {

        return "FootballMatch{" +
                "firstTeam=" + firstTeam +
                ", secondTeam=" + secondTeam +
                ", publisher=" + publisher +
                '}';
    }

    public FootballTeam getFirstTeam() {
        return firstTeam;
    }

    public FootballTeam getSecondTeam() {
        return secondTeam;
    }

    public void notifySubscribers() {
        publisher.submit(this);
    }
}
