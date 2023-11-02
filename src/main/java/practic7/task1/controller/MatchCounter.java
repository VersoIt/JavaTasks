package practic7.task1.controller;

import java.util.function.IntConsumer;

interface MatchCounter {

    void onCount(IntConsumer consumer);

    void start();
}
