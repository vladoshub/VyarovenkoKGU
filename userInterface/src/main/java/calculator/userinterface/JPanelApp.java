package calculator.userinterface;

import calculator.api.Operations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class JPanelApp extends JPanel {

    boolean check = false;
    boolean flag=false;
    double save = 0;
    double res1 = 0;
    double res2=0;
    int width,height;
    Operations operations;
    Operations preOperations;



    public JPanelApp(int width,int height)
    {
        this.width=width;
        this.height=height;
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
            final JComboBox list = new JComboBox(oper);
            list.setBounds(15, 10, width-15, 25);

            setLayout(null);
            // Specifies the position of the element
            final TextField txt1 = new TextField();
            txt1.setBounds(15, 45, width-75, 25);
            //txt1.setEditable(false);


            final JButton  but1 = new JButton("<");
            but1.setBounds(width-50, 45, 50, 30);

            final TextField txt2 = new TextField();
            txt2.setBounds(15, 80, width-75, 25);
            txt2.setEditable(true);

            final JButton  but2 = new JButton("<");
            but2.setBounds(width-50, 80, 50, 30);


            final TextField txt3 = new TextField();
            txt3.setBounds(15, 165, width-75, 25);
            txt3.setEditable(false);


            JButton bRes = new JButton("=");
            bRes.setBounds(width-50, 165, 50, 25);





            add(list);
            add(txt1);
            add(txt3);
            add(bRes);
            add(txt2);
            add(but1);
            add(but2);

            txt1.addFocusListener(new FocusListener(){


                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (!txt1.getText().equals("")) {
                        try {
                            Double.valueOf(txt1.getText());
                            txt1.setBackground(Color.white);
                            check = true;
                            list.updateUI();
                        } catch (Exception ve) {
                            txt1.setBackground(Color.RED);
                            check = false;
                            list.updateUI();
                        }


                    }
                }


            });


            txt2.addFocusListener(new FocusListener(){
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (!txt2.getText().equals("")) {
                        try {
                            Double.valueOf(txt2.getText());
                            txt2.setBackground(Color.white);
                            check = true;
                            list.updateUI();
                        } catch (Exception ve) {
                            txt2.setBackground(Color.RED);
                            check = false;
                            list.updateUI();
                        }


                    }
                }


            });


            list.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txt1.setVisible(false);
                    txt2.setVisible(false);

                    JComboBox theList = (JComboBox) e.getSource();
                    int index = theList.getSelectedIndex();
                    if (index >= 0) {
                        operations = userInterface.getOperations().get(index);
                        if (operations.getArgCount() == 2) {
                            txt1.setVisible(true);
                            txt2.setVisible(true);
                            but2.setVisible(true);
                            list.updateUI();
                        } else {
                            try {
                                txt2.setVisible(false);
                                txt1.setVisible(true);
                                but2.setVisible(false);
                                list.updateUI();
                            } catch (Exception ex) {

                            }

                        }
                    }

                }


            } );




            bRes.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg0) {


                    if(operations!=null){
                        if (operations.getArgCount()==1&&!txt1.getText().equals("")) {

                            try {
                                res1 = Double.valueOf(txt1.getText());
                                txt1.setBackground(Color.white);
                                check = true;
                                list.updateUI();
                            } catch (Exception ve) {
                                txt1.setBackground(Color.RED);
                                check = false;
                                list.updateUI();
                            }
                            try {
                                if (operations != null && check) {
                                    save = operations.Calculate(res1);
                                    txt3.setText(Double.toString(save));
                                    txt3.setBackground(Color.white);
                                    flag = true;
                                    list.updateUI();
                                }
                            } catch (Exception ve) {
                                txt3.setText(("Ошибка!"));
                                txt3.setBackground(Color.RED);
                                flag = false;
                                list.updateUI();
                            }
                        }
                        else if(operations.getArgCount()==2&&!(txt1.getText().equals("")||txt2.getText().equals(""))){
                            try {
                                res1 = Double.valueOf(txt1.getText());
                                txt1.setBackground(Color.white);
                                check = true;
                                list.updateUI();
                            } catch (Exception ve) {
                                txt1.setBackground(Color.RED);
                                check = false;
                                list.updateUI();
                            }
                            try {
                                res2 = Double.valueOf(txt2.getText());
                                txt2.setBackground(Color.white);
                                if (check)
                                    check = true;
                                list.updateUI();

                            } catch (Exception ve) {
                                txt2.setBackground(Color.RED);
                                check = false;
                                list.updateUI();
                            }

                            try {
                                if (operations != null && check) {
                                    save = operations.Calculate(res1, res2);
                                    txt3.setText(Double.toString(save));
                                    txt3.setBackground(Color.white);
                                    flag = true;
                                    list.updateUI();
                                }
                            } catch (Exception ve) {
                                txt3.setText(("Ошибка!"));
                                txt3.setBackground(Color.RED);
                                flag = false;
                                list.updateUI();
                            }
                        }
                    }
                }
            });

            but1.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg0)
                {
                    if(flag)
                    txt1.setText(Double.toString(save));
                    list.updateUI();

            }});


            but2.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg0)
                {
                    if(flag)
                        txt2.setText(Double.toString(save));
                    list.updateUI();
                }

            });

        }
        catch (ArithmeticException exception)
        {
            //System.out.println("Can not divide by zero ");
        }
    }



}
