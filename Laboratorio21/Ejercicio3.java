package Laboratorio21;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class Ejercicio3 extends JFrame {
    private ArrayList<ImageIcon> imagenes;
    private JLabel etiquetaImagen;
    private int indiceActual;

    public Ejercicio3() {
        setTitle("Galería de Imágenes");
        setSize(1500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        imagenes = new ArrayList<>();
        etiquetaImagen = new JLabel();
        etiquetaImagen.setHorizontalAlignment(JLabel.CENTER);
        add(etiquetaImagen, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        JMenuItem itemCargar = new JMenuItem("Cargar Imágenes");
        itemCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarImagen();
            }
        });
        menuBar.add(itemCargar);
        setJMenuBar(menuBar);

        JPanel panelBotones = new JPanel();
        JButton anterior = new JButton("Anterior");
        JButton siguiente = new JButton("Siguiente");

        anterior.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarImagenAnterior();
            }
        });

        siguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarImagenSiguiente();
            }
        });

        panelBotones.add(anterior);
        panelBotones.add(siguiente);
        add(panelBotones, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void cargarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File[] archivosSeleccionados = fileChooser.getSelectedFiles();
            for (File archivo : archivosSeleccionados) {
                imagenes.add(new ImageIcon(archivo.getAbsolutePath()));
            }
            if (!imagenes.isEmpty()) {
                indiceActual = 0;
                mostrarImagenActual();
            }
        }
    }

    private void mostrarImagenActual() {
        if (!imagenes.isEmpty() && indiceActual >= 0 && indiceActual < imagenes.size()) {
            etiquetaImagen.setIcon(imagenes.get(indiceActual));
        }
    }

    private void mostrarImagenAnterior() {
        if (indiceActual > 0) {
            indiceActual--;
            mostrarImagenActual();
        }
    }

    private void mostrarImagenSiguiente() {
        if (indiceActual < imagenes.size() - 1) {
            indiceActual++;
            mostrarImagenActual();
        }
    }

    public static void main(String[] args){
        new Ejercicio3();
    }
}