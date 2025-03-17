// Write a program to create a GUI that allows the user to change the font, size, and style of text in a `JTextField`.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Ass3SetA1 extends JFrame implements ItemListener {
    JLabel l1, l2, l3;
    JComboBox<String> cmb1, cmb2;
    JCheckBox cb1, cb2;
    JTextField t1;
    Font f;

    Ass3SetA1() {
        super("Ass3SetA1");
        setSize(350, 250);
        setLocation(200, 150);
        setLayout(null);

        l1 = new JLabel("Font");
        l2 = new JLabel("Size");
        l3 = new JLabel("Style");
        cmb1 = new JComboBox<>();
        cmb2 = new JComboBox<>();
        cb1 = new JCheckBox("Bold");
        cb2 = new JCheckBox("Italic");
        t1 = new JTextField("Font Operation");

        add(l1);
        add(l2);
        add(l3);
        add(cmb1);
        add(cmb2);
        add(cb1);
        add(cb2);
        add(t1);

        l1.setBounds(50, 20, 100, 20);
        cmb1.setBounds(50, 45, 150, 20);
        l2.setBounds(50, 80, 100, 20);
        cmb2.setBounds(50, 105, 150, 20);
        t1.setBounds(50, 140, 250, 50);
        l3.setBounds(220, 20, 100, 20);
        cb1.setBounds(220, 50, 80, 20);
        cb2.setBounds(220, 80, 80, 20);

        cmb1.addItem("Arial");
        cmb1.addItem("Times New Roman");
        cmb1.addItem("Bookman Old Style");
        cmb1.addItem("Courier New");
        cmb1.addItem("Georgia");

        cmb2.addItem("10");
        cmb2.addItem("15");
        cmb2.addItem("20");
        cmb2.addItem("25");
        cmb2.addItem("30");

        f = new Font("Arial", Font.PLAIN, 10);
        t1.setFont(f);

        cmb1.addItemListener(this);
        cmb2.addItemListener(this);
        cb1.addItemListener(this);
        cb2.addItemListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) {
        String fn = cmb1.getSelectedItem().toString();
        int fs = Integer.parseInt(cmb2.getSelectedItem().toString());
        if (cb1.isSelected() && cb2.isSelected())
            f = new Font(fn, Font.ITALIC + Font.BOLD, fs);
        else if (cb1.isSelected())
            f = new Font(fn, Font.BOLD, fs);
        else if (cb2.isSelected())
            f = new Font(fn, Font.ITALIC, fs);
        else
            f = new Font(fn, Font.PLAIN, fs);

        t1.setFont(f);
    }

    public static void main(String args[]) {
        new Ass3SetA1();
    }
  }
