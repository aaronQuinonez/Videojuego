package PracticaFP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio1  extends JFrame{
    private static JLabel mensaje;
    private static JButton btn;

    public Ejercicio1() {
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ejercicio 1");
        setLayout(new FlowLayout());
        createContents();
        setVisible(true);
    }
    private void createContents(){
        mensaje = new JLabel();
        btn = new JButton("Presione");
        Listener listener = new Listener();
        add(btn);
        add(mensaje);
        btn.addActionListener(listener);
    }
    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mensaje.setText("Buenos días!");
        }
    }
    public static void main(String[] args) {
        Ejercicio1 ejemplo = new Ejercicio1();
    }
}