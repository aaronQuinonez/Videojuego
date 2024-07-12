package PracticaFP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio3 extends JFrame{
    private static JButton btn;

    public Ejercicio3() {
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ejercicio 2");
        setLayout(new FlowLayout());
        createContents();
        setVisible(true);
    }
    private void createContents(){
        btn = new JButton("Presione");
        Listener listener = new Listener();
        add(btn);
        btn.addActionListener(listener);
    }
    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Color selectedColor = JColorChooser.showDialog(Ejercicio3.this, "Seleccione un color", getContentPane().getBackground());
            if (selectedColor != null) {
                getContentPane().setBackground(selectedColor);
            }
        }
    }
    public static void main(String[] args) {
        Ejercicio3 ejemplo = new Ejercicio3();
    }
}
