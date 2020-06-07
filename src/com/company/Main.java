package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Main extends Frame implements ActionListener {

    private Label clearMe;
    private TextField txtA, txtB;

    private Main(String s){
        super(s);

        Panel mainPanel = new Panel();
        mainPanel.setLayout(new GridLayout(4, 2, 5, 10));

        Button bEqual = new Button("CALCULATE");
        Button bClear = new Button("clear");
        clearMe = new Label();
        txtA = new TextField();
        txtB = new TextField();

        mainPanel.add(new Label("a"));
        mainPanel.add(txtA);
        mainPanel.add(new Label("b"));
        mainPanel.add(txtB);
        mainPanel.add(new Label("sum"));
        mainPanel.add(clearMe);
        mainPanel.add(bEqual);
        mainPanel.add(bClear);

        bEqual.addActionListener(this);
        bClear.addActionListener(this);

        setSize(250,225);
        setVisible(true);
        add(mainPanel);

        addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent ev){
                System.exit(0);
            }
        });
    }


    public void actionPerformed(ActionEvent e) {
        int a, b, c;
        String stringA, stringB;
        if (e.getActionCommand().equals("clear"))
        {
            clearMe.setText(" ");
        }else{
            try {
                stringA = txtA.getText();
                a = Integer.parseInt(stringA);
                stringB = txtB.getText();
                b = Integer.parseInt(stringB);
                c = a + b;
                clearMe.setText(String.valueOf(c));
            } catch (NumberFormatException ae){
                clearMe.setText("Вставте int цифры");
            }
        }
    }


    public static void main(String[] args) {
        Main asd = new Main("calculate me!!!1!!");
    }
}
