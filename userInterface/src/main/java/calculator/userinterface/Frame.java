package calculator.userinterface;


import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame(){
        setBounds(100, 100, 320, 240);
        setTitle("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new JPanelApp(290,320));
        setVisible(true);
    }



}
