package JPanelExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Artem Konyukhov on 04.09.2017.
 */
public class SimpleGui implements ActionListener {
    JFrame frame;
    JButton labelButton, colorButton;
    JLabel label;

    public static void main(String[] args) {
        SimpleGui gui = new SimpleGui();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelButton = new JButton("Change label");
        labelButton.addActionListener(new LabelListener());

        colorButton = new JButton("Change colors");
        colorButton.addActionListener(new ColorListener());

        label = new JLabel("I'm a label");

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);


        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    class LabelListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            label.setText("Ouch!");
        }
    }

    class ColorListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            frame.repaint();
        }
    }
}
