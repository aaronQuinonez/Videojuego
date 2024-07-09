package PracticaFP;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejemplo35fp extends JFrame {
    private static final int ANCHO = 300;
    private static final int ALTO = 100;
    private JTextField xBox; // numero
    private JTextField xfBox; // factorial

    public Ejemplo35fp() {
        setTitle("Calculadora de Factoriales");
        setSize(ANCHO, ALTO);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);
    }

    private void createContents() {
        JLabel xLabel = new JLabel("x:");
        JLabel xfLabel = new JLabel("x!:");
        JButton btn = new JButton("Factorial");
        Listener listener = new Listener();
        xBox = new JTextField(2);
        xfBox = new JTextField(10);
        xfBox.setEditable(false);
        add(xLabel);
        add(xBox);
        add(xfLabel);
        add(xfBox);
        add(btn);
        xBox.addActionListener(listener);
        btn.addActionListener(listener);
    }

    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int x;
            int xf;
            try {
                x = Integer.parseInt(xBox.getText());
            } catch (NumberFormatException nfe) {
                x = -1;
            }
            if (x < 0) {
                xfBox.setText("indefinido");
            } else {
                if (x == 0 || x == 1) {
                    xf = 1;
                } else {
                    xf = 1;
                    for (int i = 2; i <= x; i++) {
                        xf *= i;
                    }
                }
                xfBox.setText(Integer.toString(xf));
            }
        }
    }

    public static void main(String[] args) {
        new Ejemplo35fp();
    }
}
