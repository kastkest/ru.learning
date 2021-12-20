package ru.gb.kasterov.homeworkapp8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

    private JLabel display;
    private Double leftOperand;
    private Double rightOperand;
    private String operation;
    private boolean isNew = true;

    public Calculator() {
        setTitle("Калькулятор");
        setBounds(300, 300, 270, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        final ActionListener numberActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JButton source = (JButton) e.getSource();
                final String text = source.getText();
                String displayText = display.getText();
                if (!("+/-".equals(text))) {
                    if (".".equals(text) && displayText.contains(".")) {
                        return;
                    }
                    if ("0".equals(displayText)) {
                        displayText = "";
                    }
                    displayText += text;

                } else if (!displayText.contains("-") && !displayText.contains("+")) {
                    displayText = "-" + displayText;
                } else if (displayText.contains("-") && !displayText.contains("+")) {
                    displayText = displayText.replace("-", "+");
                } else if (displayText.contains("+") && !displayText.contains("-")) {
                    displayText = displayText.replace("+", "-");
                }
                display.setText(displayText);
            }
        };

        final ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                final JButton source = (JButton) e.getSource();
                final String text = source.getText();

                if ("=".equals(text)) {
                    rightOperand = Double.parseDouble(display.getText());
                    if (leftOperand != null) {
                        switch (operation) {
                            case "+":
                                display.setText(String.valueOf(leftOperand + rightOperand));
                                break;
                            case "-":
                                display.setText(String.valueOf(leftOperand - rightOperand));
                                break;
                            case "*":
                                display.setText(String.valueOf(leftOperand * rightOperand));
                                break;
                            case "/":
                                display.setText(String.valueOf(leftOperand / rightOperand));
                                break;
                            case "C":
                                display.setText("0");
                                break;
                        }
                        leftOperand = Double.parseDouble(display.getText());
                        rightOperand = null;
                        operation = null;
                    }

                    return;
                }


                leftOperand = Double.parseDouble(display.getText());
                display.setText("0");
                operation = text;


            }

        };

        final JPanel numberPanel = new JPanel();
        final GridLayout numberLayout = new GridLayout(6, 3, 5, 5);
        numberPanel.setLayout(numberLayout);

        for (int i = 0; i < 10; i++) {
            final JButton button = new JButton(String.valueOf(i));
            button.addActionListener(numberActionListener);
            numberPanel.add(button);
        }
        final JButton pointButton = new JButton(".");
        numberPanel.add(pointButton);
        final JButton signChangeButton = new JButton("+/-");
        numberPanel.add(signChangeButton);
        final JButton cancelButton = new JButton("С");
        numberPanel.add(cancelButton);
        final JButton plusButton = new JButton("+");
        numberPanel.add(plusButton);
        final JButton minusButton = new JButton("-");
        numberPanel.add(minusButton);
        final JButton multiplierButton = new JButton("*");
        numberPanel.add(multiplierButton);
        final JButton divisionButton = new JButton("/");
        numberPanel.add(divisionButton);
        final JButton finalButton = new JButton("=");
        numberPanel.add(finalButton);

        pointButton.addActionListener(numberActionListener);
        signChangeButton.addActionListener(numberActionListener);
        cancelButton.addActionListener(actionListener);
        plusButton.addActionListener(actionListener);
        minusButton.addActionListener(actionListener);
        multiplierButton.addActionListener(actionListener);
        divisionButton.addActionListener(actionListener);
        finalButton.addActionListener(actionListener);


        display = new JLabel("0");
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 17));
        add(display, BorderLayout.NORTH);
        add(numberPanel, BorderLayout.CENTER);


        setVisible(true);

    }

    public static void main(String[] args) {
        new Calculator();
    }
}