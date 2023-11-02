package practic20.task2.presentation.controller;

import practic20.task2.domain.Calculator;
import practic20.task2.ioc.DependencyInjection;
import practic20.task2.presentation.View;

public class CalculatorController implements Controller<String> {

    private View<String> view;

    private String calculation;

    private boolean isClear = true;

    private Calculator calculator = DependencyInjection.provideCalculator();

    public CalculatorController() {
        calculation = "0";
    }

    @Override
    public void addCharacter(String character) {
        if (isClear && character.equals("0"))
            return;

        calculation = isClear ? character : calculation + character;
        isClear = false;
        view.setContent(calculation);
    }

    @Override
    public void clear() {
        isClear = true;
        calculation = "0";
        view.setContent(calculation);
    }

    @Override
    public void calculate() {
        try {
            calculation = calculator.calculate(calculation).toString();
            view.setContent(calculation);
        } catch (Exception exception) {
            calculation = "0";
            isClear = true;
            view.setContent("Ошибка");
        }
    }

    @Override
    public void setView(View<String> view) {
        this.view = view;
    }

    @Override
    public void eraseLast() {
        if (calculation.length() <= 1) {
            isClear = true;
            calculation = "0";
        } else {
            calculation = calculation.substring(0, calculation.length() - 1);
        }
        view.setContent(calculation);
    }
}
