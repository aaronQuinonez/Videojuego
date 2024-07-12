package Laboratorio21;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class SimpleTextPaneExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTextPane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JTextPane textPane = new JTextPane();

        // Crear un estilo
        StyleContext context = new StyleContext();
        StyledDocument document = new DefaultStyledDocument(context);

        // Estilo para negrita
        Style boldStyle = context.addStyle("Bold", null);
        StyleConstants.setBold(boldStyle, true);

        // Estilo para cursiva
        Style italicStyle = context.addStyle("Italic", null);
        StyleConstants.setItalic(italicStyle, true);

        // Estilo para subrayado
        Style underlineStyle = context.addStyle("Underline", null);
        StyleConstants.setUnderline(underlineStyle, true);

        textPane.setStyledDocument(document);

        try {
            document.insertString(document.getLength(), "Texto en negrita\n", boldStyle);
            document.insertString(document.getLength(), "Texto en cursiva\n", italicStyle);
            document.insertString(document.getLength(), "Texto subrayado\n", underlineStyle);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        frame.add(new JScrollPane(textPane), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}