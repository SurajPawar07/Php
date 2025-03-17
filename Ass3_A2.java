//Create a GUI that accepts the user's name, class, and hobbies, and displays the selected options in a textbox.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Ass3SetA2 extends JFrame implements ActionListener, ItemListener {
    JLabel l1, l2, l3;
    JTextField txt_name, txt_display;
    JRadioButton rb1, rb2, rb3;
    JCheckBox cb1, cb2, cb3;
    JButton b1;

    Ass3SetA2() {
        super("Ass3SetA2");
        setSize(400, 300);
        setLayout(null);

        l1 = new JLabel("Your Name:");
        l2 = new JLabel("Your Class:");
        l3 = new JLabel("Your Hobbies:");
        txt_name = new JTextField();
        txt_display = new JTextField();
        rb1 = new JRadioButton("FY");
        rb2 = new JRadioButton("SY");
        rb3 = new JRadioButton("TY");
        cb1 = new JCheckBox("Music");
        cb2 = new JCheckBox("Dance");
        cb3 = new JCheckBox("Sports");
        b1 = new JButton("Submit");

        add(l1);
        add(l2);
        add(l3);
        add(txt_name);
        add(txt_display);
        add(rb1);
        add(rb2);
        add(rb3);
        add(cb1);
        add(cb2);
        add(cb3);
        add(b1);

        l1.setBounds(50, 20, 100, 20);
        txt_name.setBounds(150, 20, 150, 20);
        l2.setBounds(50, 50, 100, 20);
        rb1.setBounds(150, 50, 50, 20);
        rb2.setBounds(200, 50, 50, 20);
        rb3.setBounds(250, 50, 50, 20);
        l3.setBounds(50, 80, 100, 20);
        cb1.setBounds(150, 80, 80, 20);
        cb2.setBounds(230, 80, 80, 20);
        cb3.setBounds(310, 80, 80, 20);
        txt_display.setBounds(50, 120, 300, 50);
        b1.setBounds(150, 180, 100, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);

        b1.addActionListener(this);
        cb1.addItemListener(this);
        cb2.addItemListener(this);
        cb3.addItemListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String name = txt_name.getText();
        String className = "";
        if (rb1.isSelected()) className = "FY";
        else if (rb2.isSelected()) className = "SY";
        else if (rb3.isSelected()) className = "TY";

        String hobbies = "";
        if (cb1.isSelected()) hobbies += "Music ";
        if (cb2.isSelected()) hobbies += "Dance ";
        if (cb3.isSelected()) hobbies += "Sports";

        txt_display.setText("Name: " + name + ", Class: " + className + ", Hobbies: " + hobbies);
    }

    public void itemStateChanged(ItemEvent e) {
        // Handle checkbox state changes if needed
    }

    public static void main(String args[]) {
        new Ass3SetA2();
    }
  }
