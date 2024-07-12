package PracticaFP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio2  extends JFrame{
    private static JLabel mensaje;
    private static JButton btn;
    private static int conteo;

    public Ejercicio2() {
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ejercicio 2");
        setLayout(new FlowLayout());
        createContents();
        setVisible(true);
    }
    private void createContents(){
        conteo = 0;
        mensaje = new JLabel("Número de intentos: " + conteo);
        btn = new JButton("Presione");
        Listener listener = new Listener();
        add(btn);
        add(mensaje);
        btn.addActionListener(listener);
    }
    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            conteo++;
            mensaje.setText("Número de intentos: " + conteo);
        }
    }
    public static void main(String[] args) {
        Ejercicio2 ejemplo = new Ejercicio2();
    }
}