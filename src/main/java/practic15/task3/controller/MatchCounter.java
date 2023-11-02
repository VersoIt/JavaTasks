package practic15.task3.controller;

import java.util.function.IntConsumer;

interface MatchCounter {

    void onCount(IntConsumer consumer);

    void start();
}
