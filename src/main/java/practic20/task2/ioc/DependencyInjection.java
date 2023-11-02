package practic20.task2.ioc;

import practic20.task2.domain.Calculator;
import practic20.task2.domain.Calculator32;
import practic20.task2.presentation.controller.CalculatorController;
import practic20.task2.presentation.controller.Controller;

public class DependencyInjection {

    public static Controller<String> provideController() {
        return new CalculatorController();
    }

    public static Calculator provideCalculator() {
        return new Calculator32();
    }
}
