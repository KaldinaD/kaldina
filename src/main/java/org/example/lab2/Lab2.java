package org.example.lab2;

import javax.swing.*;
import java.awt.*;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;

public class Lab2 extends JFrame {
    private final JPanel mainPanel;
    private final JTextArea textArea;
    private final JScrollPane scrollPane;
    private final JPanel panel;
    private final JTextField textField;
    private final JButton button;

    public Lab2() {
        mainPanel = new JPanel();
        textField = new JTextField();
        textArea = new JTextArea(5, 5);
        scrollPane = new JScrollPane(textArea);
        panel = new JPanel();
        button = new JButton("Число->Текст");
        setLayoutManager();
        addComponentsToJFrame();
        addActionEvent();
        init();
    }

    private void init() {
        setTitle("Перевод числа в текст");
        setPreferredSize(new Dimension(350, 200));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textField.setPreferredSize(new Dimension(50,30));
        textArea.setEditable(false);
        scrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    private void setLayoutManager() {
        mainPanel.setLayout(new BorderLayout());
        panel.setLayout(new FlowLayout());
    }

    private void addComponentsToJFrame() {
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        panel.add(textField);
        panel.add(button);
        mainPanel.add(panel, BorderLayout.SOUTH);
        add(mainPanel);
    }

    public void setString(final String string) {
        textArea.setText("");
        textArea.append(string + "\n");
    }

    private void addActionEvent() {
        button.addActionListener(e -> {
            action();
        });
    }

    private void action(){
        String chislo = textField.getText();
        try {
            int number = Integer.parseInt(chislo);
            String result = TransferNumberToText.toString(number);
            setString(result);
        } catch (RuntimeException e){
            setString("error");
        }
    }

    public static void main(String[] args){
        Lab2 lab = new Lab2();
    }
}
