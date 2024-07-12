package PracticaFP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio4 extends JFrame{
    private static JLabel resultado;
    private static JTextField operador1;
    private static JTextField signo;
    private static JTextField operador2;
    private static JButton btn;

    public Ejercicio4() {
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ejercicio 4");
        setLayout(new FlowLayout());
        createContents();
        setVisible(true);
    }
    private void createContents(){
        operador1 = new JTextField(5);
        signo = new JTextField(2);
        operador2 = new JTextField(5);
        resultado = new JLabel(" = ");
        btn = new JButton("Calcular");
        Listener listener = new Listener();
        add(operador1);
        add(signo);
        add(operador2);
        add(resultado);
        add(btn);
        btn.addActionListener(listener);
    }
    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int op1 = Integer.parseInt(operador1.getText());
            int op2 = Integer.parseInt(operador2.getText());
            switch (signo.getText()) {
                case "+":
                    resultado.setText(" = " + (op1 + op2));
                    break;
                case "-":
                    resultado.setText(" = " + (op1 - op2));
                    break;
                case "*":
                    resultado.setText(" = " + (op1 * op2));
                    break;
                case "/":
                    if (op2 != 0) {
                        resultado.setText(" = " + (op1 / op2));
                    } else {
                        resultado.setText("No se puede dividir");;
                        return;
                    }
                    break;
            }

        }
    }
    public static void main(String[] args) {
        Ejercicio4 ejemplo = new Ejercicio4();
    }
}
