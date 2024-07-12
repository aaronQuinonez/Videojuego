package Laboratorio21;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.*;
import java.awt.*;
import java.io.*;

public class Ejercicio2 extends JFrame {
    private JTextPane archivoTexto;
    private JFileChooser archivos;

    public Ejercicio2() {
        setTitle("Editor de Texto");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        archivoTexto = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(archivoTexto);
        add(scrollPane, BorderLayout.CENTER);

        archivos = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
        archivos.setFileFilter(filter);

        barraMenu();
        createToolBar();

        setVisible(true);
    }

    public void barraMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Archivo");
        JMenuItem archivoNuevo = new JMenuItem("Nuevo");
        JMenuItem abrirArchivo = new JMenuItem("Abrir");
        JMenuItem guardarArchivo = new JMenuItem("Guardar");

        archivoNuevo.addActionListener(e -> archivoTexto.setText(""));
        abrirArchivo.addActionListener(e -> abrir());
        guardarArchivo.addActionListener(e -> guardar());

        menu.add(archivoNuevo);
        menu.add(abrirArchivo);
        menu.add(guardarArchivo);

        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    public void createToolBar() {
        JToolBar barraHerramientas = new JToolBar();

        JButton negrita = new JButton("N");
        JButton cursiva = new JButton("I");
        JButton subrayado = new JButton("U");

        negrita.setFont(new Font("Arial", Font.BOLD, 12));
        cursiva.setFont(new Font("Arial", Font.ITALIC, 12 ));
        subrayado.setFont(new Font("Arial", Font.PLAIN, 12));

        negrita.addActionListener(e -> aplicarEstilo(StyleConstants.Bold));
        cursiva.addActionListener(e -> aplicarEstilo(StyleConstants.Italic));
        subrayado.addActionListener(e -> aplicarEstilo(StyleConstants.Underline));

        barraHerramientas.add(negrita);
        barraHerramientas.add(cursiva);
        barraHerramientas.add(subrayado);

        add(barraHerramientas, BorderLayout.NORTH);
    }

    public void aplicarEstilo(Object bold) {
        StyledDocument doc = archivoTexto.getStyledDocument();
        int inicio = archivoTexto.getSelectionStart();
        int fin = archivoTexto.getSelectionEnd();
        Element element = doc.getCharacterElement(inicio);
        AttributeSet as = element.getAttributes();

        SimpleAttributeSet sas = new SimpleAttributeSet();
        if (bold == StyleConstants.Bold) {
            StyleConstants.setBold(sas, !StyleConstants.isBold(as));
        } else if (bold == StyleConstants.Italic) {
            StyleConstants.setItalic(sas, !StyleConstants.isItalic(as));
        } else if (bold == StyleConstants.Underline) {
            StyleConstants.setUnderline(sas, !StyleConstants.isUnderline(as));
        }
        doc.setCharacterAttributes(inicio, fin - inicio, sas, false);
    }

    private void abrir() {
        int returnValue = archivos.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = archivos.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                archivoTexto.read(reader, null);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "No se pudo abrir el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void guardar() {
        int returnValue = archivos.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = archivos.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                archivoTexto.write(writer);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "No se pudo guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new Ejercicio2();
    }
}