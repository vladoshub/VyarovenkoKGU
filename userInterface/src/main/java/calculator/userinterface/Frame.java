package calculator.userinterface;


import javax.swing.*;

public class Frame extends JFrame {

    public Frame(){
        setBounds(100, 100, 265, 460);
        setTitle("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new JPanelApp());
        setVisible(true);
    }



}
