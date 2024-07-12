package Laboratorio21;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Ejercicio1 extends JFrame {
    private Stack<Double> numbers = new Stack<>();
    private Stack<Character> operations = new Stack<>();
    private boolean isOperatorClicked = false;
    private JTextField operaciones;
    private JPanel panel;

    public Ejercicio1(){
        setTitle("Calculadora Avanzada");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        createContents();
        setVisible(true);
    }

    public void createContents(){
        operaciones = new JTextField();
        operaciones.setFont(new Font("Arial", Font.PLAIN, 18));
        operaciones.setHorizontalAlignment(JTextField.RIGHT);
        operaciones.setEditable(false);
        add(operaciones, BorderLayout.NORTH);

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4));
        String[] buttonLabels = {
            "7", "8", "9", "/", "C",
            "4", "5", "6", "*", "√",
            "1", "2", "3", "-", "^",
            "0", ".", "=", "+"
        };
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(new Listener());
            panel.add(button);
        }
        add(panel, BorderLayout.CENTER);
    }

    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.matches("[0-9]") || command.equals(".")) {
                if (isOperatorClicked) {
                    operaciones.setText("");
                    isOperatorClicked = false;
                }
                operaciones.setText(operaciones.getText() + command);
            } else if (command.equals("C")) {
                operaciones.setText("");
                numbers.clear();
                operations.clear();
            } else if (command.equals("=")) {
                performOperation();
                isOperatorClicked = true;
            } else if (command.equals("√")) {
                double value = Double.parseDouble(operaciones.getText());
                operaciones.setText(String.valueOf(Math.sqrt(value)));
                isOperatorClicked = true;
            } else if (command.equals("^")) {
                double base = Double.parseDouble(operaciones.getText());
                operaciones.setText("");
                isOperatorClicked = true;
                operations.push('^');
                numbers.push(base);
            } else {
                performOperation();
                operations.push(command.charAt(0));
                isOperatorClicked = true;
            }
        }

        private void performOperation() {
            if (operations.isEmpty()) {
                numbers.push(Double.parseDouble(operaciones.getText()));
                return;
            }

            double secondOperand = Double.parseDouble(operaciones.getText());
            double firstOperand = numbers.pop();
            char operation = operations.pop();

            switch (operation) {
                case '+':
                    numbers.push(firstOperand + secondOperand);
                    break;
                case '-':
                    numbers.push(firstOperand - secondOperand);
                    break;
                case '*':
                    numbers.push(firstOperand * secondOperand);
                    break;
                case '/':
                    if (secondOperand != 0) {
                        numbers.push(firstOperand / secondOperand);
                    } else {
                        JOptionPane.showMessageDialog(Ejercicio1.this, "Error: División por cero", "Error", JOptionPane.ERROR_MESSAGE);
                        numbers.push(firstOperand);
                    }
                    break;
                case '^':
                    numbers.push(Math.pow(firstOperand, secondOperand));
                    break;
            }

            operaciones.setText(numbers.peek().toString());
        }
    }
    public static void main(String[] args){
        new Ejercicio1();
    }
}