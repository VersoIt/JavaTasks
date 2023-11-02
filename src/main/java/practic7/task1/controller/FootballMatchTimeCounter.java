package practic7.task1.controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.IntConsumer;

public class FootballMatchTimeCounter implements MatchCounter {

    private IntConsumer countedCallback;

    private int currentSeconds = 90;

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public FootballMatchTimeCounter(int duration) {
        this.currentSeconds = duration;
    }

    public void start() {
        scheduler.scheduleAtFixedRate(() -> countedCallback.accept(currentSeconds--), 0, 1, TimeUnit.SECONDS);
    }

    @Override
    public void onCount(IntConsumer callback) {
        countedCallback = callback;
    }
}
