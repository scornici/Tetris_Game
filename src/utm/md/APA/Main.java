package utm.md.APA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements Runnable {

   // private JLabel scoreLabel;
    public Main() {

        run();
    }

    public void run() {

        final JFrame frame = new JFrame("Menu");
        frame.setLocation(500, 300);

        // Main playing area
        final Menu menu = new Menu(frame);
        frame.add(menu, BorderLayout.CENTER);
        frame.setResizable(false);

        // Put the frame on the screen
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }



    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Main());
        }
    }
