package utm.md.APA;


import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JComponent implements Runnable{
    private JFrame frame;
    private JLabel scoreLabel;
    public Menu(JFrame frame) {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.frame = frame;
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Tetris Game", SwingConstants.CENTER);
        Font f = new Font(null, Font.PLAIN, 30); // set font to bigger size
        title.setFont(f);
        title.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        String inst = """
                                 Joaca Tetris
                  Elaborata de studentii gr. FI-201
                      Scornici Ivan si Mititelu Ana
                                    Reguli:
                                           
                1. ← → - mutarea stanga/dreapta
                2. ↑ ↓ - rotirea stanga/dreapta
                3. p - pause
                4. d - accelerare
                5. spacebar - coboară în jos
                """;

        JTextPane instructions = new JTextPane();
        instructions.setText(inst);
        instructions.setFont(new Font(null, Font.PLAIN, 15));
        instructions.setEditable(false);

        StyledDocument doc = instructions.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(2,1)); // sets grid layout
        buttons.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.WHITE);
        buttons.setFocusable(true);

        // Start button
        JButton start = new JButton("Start");
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                run();
            }
        });

        // Quit button
        JButton quit = new JButton("Quit");
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible (false);
                System.exit(0);
            }
        });
        buttons.add(start);
        buttons.add(quit);

        // set layout
        add(title, BorderLayout.PAGE_START);
        add(instructions, BorderLayout.CENTER);
        add(buttons, BorderLayout.PAGE_END);

        this.frame.setResizable(false);
    }


    public void run() {
        frame.remove(this);
        final Board board = new Board(this);
        frame.add(board, BorderLayout.CENTER);
        board.start();
        scoreLabel = new JLabel("Score: 0");
        frame.add(scoreLabel, BorderLayout.NORTH);
        frame.setTitle("Tetris by Scornici and Mititelu");
        frame.setSize(300, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }
    JLabel getStatusBar() {

        return scoreLabel;
    }
    }
