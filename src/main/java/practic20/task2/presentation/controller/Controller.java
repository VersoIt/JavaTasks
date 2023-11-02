package practic20.task2.presentation.controller;

import practic20.task2.presentation.View;

public interface Controller<T> {

    void addCharacter(String number);

    void clear();

    void calculate();

    void setView(View<T>view);

    void eraseLast();
}
