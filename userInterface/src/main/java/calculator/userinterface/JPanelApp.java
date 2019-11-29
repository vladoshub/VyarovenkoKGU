package calculator.userinterface;

import calculator.api.Operations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class JPanelApp extends JPanel {

    JTextField txt1 = null;
    double res = 0;
    double flag=1;
    double save=0;
    String op = "";
    Operations operations;

    public JPanelApp()
    {
        try
        {

           final UserInterface userInterface = new UserInterface("C:/jar/");
            userInterface.InitJar();

            String[] oper = new String[userInterface.getOperations().size()];
            int i=0;
            for(Operations o:userInterface.getOperations()){
                oper[i]=o.getNameOp();
                i++;
            }
            JList list = new JList(oper);
            list.setBounds(180, 40, 60, 18*userInterface.getOperations().size());

            setLayout(null);
            // Specifies the position of the element
            final TextField txt1 = new TextField();
            txt1.setBounds(10, 10, 235, 25);

            JButton b0 = new JButton("0");
            b0.setBounds(10, 270, 75, 50);

            JButton b1 = new JButton("1");
            b1.setBounds(10, 190, 50, 50);

            JButton b2 = new JButton("2");
            b2.setBounds(60, 190, 50, 50);

            JButton b3 = new JButton("3");
            b3.setBounds(110, 190, 50, 50);

            JButton b4 = new JButton("4");
            b4.setBounds(10, 110, 50, 50);

            JButton b5 = new JButton("5");
            b5.setBounds(60, 110, 50, 50);

            JButton b6 = new JButton("6");
            b6.setBounds(110, 110, 50, 50);

            JButton b7 = new JButton("7");
            b7.setBounds(10, 40, 50, 50);

            JButton b8 = new JButton("8");
            b8.setBounds(60, 40, 50, 50);

            JButton b9 = new JButton("9");
            b9.setBounds(110, 40, 50, 50);

            JButton bRes = new JButton("=");
            bRes.setBounds(85, 270, 75, 50);
            Font bigFont = new Font("serif", Font.BOLD, 22);
            bRes.setFont(bigFont);

            JButton bPlus = new JButton("+");
            bPlus.setBounds(170, 40, 75, 50);
            Font bigFontPlus = new Font("serif", Font.BOLD, 22);
            bPlus.setFont(bigFontPlus);

            JButton bMinus = new JButton("-");
            bMinus.setBounds(170, 110, 75, 50);
            Font bigFontMinus = new Font("serif", Font.BOLD, 22);
            bMinus.setFont(bigFontMinus);

            JButton bMulti = new JButton("*");
            bMulti.setBounds(170, 190, 75, 50);
            Font bigFontMulti = new Font("serif", Font.BOLD, 22);
            bMulti.setFont(bigFontMulti);

            JButton bDivision = new JButton("/");
            bDivision.setBounds(170, 270, 75, 50);
            Font bigFontDivision = new Font("serif", Font.BOLD, 22);
            bDivision.setFont(bigFontDivision);


            JButton point = new JButton(".");
            point.setBounds(10, 350, 75, 50);
            Font fontPoint = new Font("serif", Font.BOLD, 22);
            point.setFont(fontPoint);

            add(txt1);
            add(b0);
            add(b1);
            add(b2);
            add(b3);
            add(b4);
            add(b5);
            add(b6);
            add(b7);
            add(b8);
            add(b9);
            add(bRes);
            add(point);
            add(list);
            add(point);

            list.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    JList theList = (JList) e.getSource();
                    if (e.getClickCount() == 2) {
                        int index = theList.locationToIndex(e.getPoint());
                        if (index >= 0) {
                            Object o = theList.getModel().getElementAt(index);
                            operations = userInterface.getOperations().get(index);
                            if (operations.getArgCount() == 2) {
                                if (res == 0) {
                                    if(!txt1.getText().equals(""))
                                        save=Double.valueOf(txt1.getText());
                                    if (operations.getNameOp().equals("-")) {
                                        flag = flag * -1;
                                        txt1.setText("");
                                    } else {
                                        txt1.setText("");
                                    }
                                } else {
                                    try {
                                        if (save == 0) {
                                            res=Double.valueOf(txt1.getText());
                                            save = res * flag;
                                            flag = 1;
                                            res=0;
                                            txt1.setText("");
                                        } else {
                                            save = operations.Calculate(save, res * flag);
                                            flag = 1;
                                            res = 0;
                                            txt1.setText(userInterface.Out(save));
                                            save=0;
                                        }
                                    } catch (Exception es) {
                                    }
                                }
                            } else {
                                try {
                                    txt1.setText(userInterface.Out(operations.Calculate(Double.valueOf(txt1.getText()))));
                                } catch (Exception ex) {

                                }

                            }
                        }
                    }

                }
            });


            point.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    if(!txt1.getText().equals("")&!txt1.getText().contains("."))
                    txt1.setText(txt1.getText() + ".");
                    res=0;
                    save=0;
                }
            });



            b1.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    txt1.setText(txt1.getText() + 1);
                        res = Double.valueOf(txt1.getText());

                }
            });

            b2.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    txt1.setText(txt1.getText() + 2);
                        res = Double.valueOf(txt1.getText());

                }
            });

            b3.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    txt1.setText(txt1.getText() + 3);
                        res = Double.valueOf(txt1.getText());
                }
            });

            b4.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    txt1.setText(txt1.getText() + 4);

                        res = Double.valueOf(txt1.getText());
                }
            });

            b5.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    txt1.setText(txt1.getText() + 5);
                        res = Double.valueOf(txt1.getText());
                }
            });

            b6.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    txt1.setText(txt1.getText() + 6);

                        res = Double.valueOf(txt1.getText());
                }
            });

            b7.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    txt1.setText(txt1.getText() + 7);
                        res = Double.valueOf(txt1.getText());
                }
            });

            b8.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    txt1.setText(txt1.getText() + 8);
                        res = Double.valueOf(txt1.getText());
                }
            });

            b9.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    txt1.setText(txt1.getText() + 9);

                        res = Double.valueOf(txt1.getText());
                }
            });

            b0.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    txt1.setText(txt1.getText() + 0);
                        res = Double.valueOf(txt1.getText());
                }
            });

            bRes.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg0)
                {
                    double k=Double.valueOf(txt1.getText());
                    if(save!=0&&k!=0) {
                        try {
                            double s = operations.Calculate(save, k);
                            txt1.setText(Double.toString(s));
                            res = 0;
                            save = 0;
                        } catch (Exception ve) {

                        }
                    }

                }
            });
        }
        catch (ArithmeticException exception)
        {
            //System.out.println("Can not divide by zero ");
        }
    }



}
