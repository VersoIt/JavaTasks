package practic20.task2.presentation.swing;

import practic20.task2.ioc.DependencyInjection;
import practic20.task2.presentation.View;
import practic20.task2.presentation.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorScreen extends JFrame implements View<String> {

    private final Controller<String> controller;

    private JLabel expressionField;

    public CalculatorScreen() {
        super("Calculator");
        controller = DependencyInjection.provideController();
        controller.setView(this);

        initSettings();
        initUi();
    }

    private void initUi() {
        JPanel contentPane = createContentPane();

        expressionField = inflateExpressionField();
        contentPane.add(expressionField);

        generateButtons(contentPane);
        setContentPane(contentPane);

        revalidate();
    }

    private JLabel inflateExpressionField() {
        Font font = new Font("Arial", Font.PLAIN, 22);
        JLabel expressionField = new JLabel("0", SwingConstants.LEFT);
        expressionField.setFont(font);

        return expressionField;
    }

    private JPanel createContentPane() {
        JPanel contentPane = new JPanel();

        BoxLayout layout = new BoxLayout(contentPane, BoxLayout.Y_AXIS);
        contentPane.setLayout(layout);

        return contentPane;
    }

    private void generateButtons(JPanel contentPane) {
        JPanel panel = new JPanel(new GridLayout(5, 4));

        CalculationSignature[] calculationSignatures = getCalculationSignatures();

        for (CalculationSignature signature : calculationSignatures) {
            JButton button = createCalcButton(signature);
            panel.add(button);
        }

        contentPane.add(panel);
    }

    private JButton createCalcButton(CalculationSignature signature) {
        JButton button = new JButton(signature.name());
        button.addActionListener(signature.action);
        button.setSize(150, 130);

        return button;
    }

    private void initSettings() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 460);
        setResizable(true);
        setLocationRelativeTo(null);
    }

    private CalculationSignature[] getCalculationSignatures() {

        return new CalculationSignature[]{
                new CalculationSignature("C", e -> controller.clear()),
                new CalculationSignature("(", e -> controller.addCharacter("(")),
                new CalculationSignature(")", e -> controller.addCharacter(")")),
                new CalculationSignature("<-", e -> controller.eraseLast()),
                new CalculationSignature("7", e -> controller.addCharacter("7")),
                new CalculationSignature("8", e -> controller.addCharacter("8")),
                new CalculationSignature("9", e -> controller.addCharacter("9")),
                new CalculationSignature("/", e -> controller.addCharacter("/")),
                new CalculationSignature("4", e -> controller.addCharacter("4")),
                new CalculationSignature("5", e -> controller.addCharacter("5")),
                new CalculationSignature("6", e -> controller.addCharacter("6")),
                new CalculationSignature("*", e -> controller.addCharacter("*")),
                new CalculationSignature("1", e -> controller.addCharacter("1")),
                new CalculationSignature("2", e -> controller.addCharacter("2")),
                new CalculationSignature("3", e -> controller.addCharacter("3")),
                new CalculationSignature("-", e -> controller.addCharacter("-")),
                new CalculationSignature(".", e -> controller.addCharacter(".")),
                new CalculationSignature("0", e -> controller.addCharacter("0")),
                new CalculationSignature("+", e -> controller.addCharacter("+")),
                new CalculationSignature("=", e -> controller.calculate()),
        };
    }

    @Override
    public void setContent(String content) {
        expressionField.setText(content);
    }

    private record CalculationSignature(String name, ActionListener action) {
    }
}
