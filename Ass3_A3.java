//Create an applet that displays a message in the center of the screen. The message should update based on events like mouse click, mouse move, mouse drag, mouse press, and key press.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Ass3SetA3 extends JFrame implements MouseListener, MouseMotionListener, KeyListener {
    JPanel pnl;
    JTextField txt1, txt2;
    String msg = "";

    Ass3SetA3() {
        super("Ass3SetA3");
        setSize(600, 600);
        setLocation(300, 100);
        setLayout(new BorderLayout());

        pnl = new JPanel();
        txt1 = new JTextField();
        txt2 = new JTextField();

        add(txt1, BorderLayout.NORTH);
        add(txt2, BorderLayout.SOUTH);
        add(pnl, BorderLayout.CENTER);

        txt1.setFont(new Font("Arial", Font.BOLD, 16));
        txt2.setFont(new Font("Arial", Font.BOLD, 16));
        txt1.setEditable(false);
        txt2.setEditable(false);
        pnl.setBackground(Color.YELLOW);
        pnl.addMouseListener(this);
        pnl.addMouseMotionListener(this);
        pnl.addKeyListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1)
            msg = "Left Button Clicked";
        else if (e.getButton() == MouseEvent.BUTTON2)
            msg = "Middle Button Clicked";
        else if (e.getButton() == MouseEvent.BUTTON3)
            msg = "Right Button Clicked";

        txt1.setText(msg);
    }

    public void mousePressed(MouseEvent e) {
        txt1.setText("Mouse Pressed at " + e.getX() + ", " + e.getY());
    }

    public void mouseReleased(MouseEvent e) {
        txt1.setText("Mouse Released at " + e.getX() + ", " + e.getY());
    }

    public void mouseEntered(MouseEvent e) {
        txt1.setText("Mouse Entered");
    }

    public void mouseExited(MouseEvent e) {
        txt1.setText("Mouse Exited");
    }

    public void mouseMoved(MouseEvent e) {
        msg = "Moved at x = " + e.getX() + " y = " + e.getY();
        txt2.setText(msg);
    }

    public void mouseDragged(MouseEvent e) {
        msg = "Dragged at x = " + e.getX() + " y = " + e.getY();
        txt2.setText(msg);
    }

    public void keyTyped(KeyEvent e) {
        msg += e.getKeyChar();
        txt2.setText(msg);
    }

    public void keyPressed(KeyEvent e) {
        txt1.setText("Key Pressed");
    }

    public void keyReleased(KeyEvent e) {
        txt1.setText("Key Released");
    }

    public static void main(String args[]) {
        new Ass3SetA3();
    }
}
