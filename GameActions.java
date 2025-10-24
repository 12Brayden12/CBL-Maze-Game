import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.*;


/**
 * Handles game actions and states such as winning, losing, and power-up effects.
 */
public class GameActions {
    private Timer timeReversed;
    private JFrame win;
    private JFrame fail;
    private JPanel winPanel;
    private JPanel failPanel;
    private JLabel winLabel;
    private JLabel information;
    private JLabel information2;
    private JLabel failLabel;
    private JLabel scoreLabel;

    private TimerAndScore scores;
    private static boolean controlsReversed;
    private SoundManager soundManager;
    Font font;
    private MazeGameGUI mainFrame;
    

    /**
     * Constructs a GameActions object to handle game states and actions.
     * @param gui The main game GUI
     * @param board The game board
     * @param scores The timer and score tracker
     */
    public GameActions(MazeGameGUI gui, Board board, TimerAndScore scores) {
        
        mainFrame = gui;
        controlsReversed = false;
        this.scores = scores;

        
       
        win = new JFrame("You won!!!");
        fail = new JFrame("Game Over");
        font = new Font("Verdana", Font.BOLD, 40);
        winLabel = new JLabel();
        information = new JLabel();
        information2 = new JLabel();
        failLabel = new JLabel();
        scoreLabel = new JLabel();
        soundManager = new SoundManager();
        winPanel = new JPanel();
        failPanel = new JPanel();
        soundManager.playBGM("bgm.wav");
        
        
    }
 
    /**
     * Handles the win condition of the game, displaying the win screen with score.
     */
    public void win() {
        mainFrame.getFrame().dispose();

        winLabel.setText("Congratulations!!!");
        winLabel.setFont(font);
        winLabel.setPreferredSize(new Dimension(400, 80));
        winLabel.setForeground(Color.BLACK);
        winLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        information.setText("<html><center>You successfully reached<br>"
                + "the end of the game!</center></html>");
        information.setFont(font);
        information.setMaximumSize(new Dimension(400, 50));
        information.setForeground(Color.BLACK);
        information.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        int finalScore = scores.finalScore();
        scores.timerStop();
        scoreLabel.setText("Your final score is: " + finalScore);
        scoreLabel.setFont(new Font("Verdana", Font.BOLD, 25));
        scoreLabel.setForeground(Color.RED);
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        BoxLayout boxlayout = new BoxLayout(winPanel, BoxLayout.Y_AXIS);

        winPanel.setLayout(boxlayout);
        winPanel.setBackground(Color.WHITE);

        winPanel.add(Box.createVerticalGlue());
        winPanel.add(winLabel);
        winPanel.add(Box.createVerticalStrut(10));
        winPanel.add(information);
        winPanel.add(Box.createVerticalStrut(20));
        winPanel.add(scoreLabel);
        winPanel.add(Box.createVerticalGlue());
            
        win.setLayout(new BorderLayout());
        win.setBackground(Color.WHITE);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(500, 500);
        win.setResizable(true);
        win.setLocationRelativeTo(null);
        win.add(winPanel, BorderLayout.CENTER);
        win.setVisible(true);
            

    }

    /**
     * Handles the game over condition, displaying the failure screen.
     */
    public void gameOver() {
        mainFrame.getFrame().dispose();
        
        failLabel.setText("Game Over!!!");
        failLabel.setFont(new Font("Verdana", Font.BOLD, 40));
        
        failLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        failLabel.setForeground(Color.RED);

        information2.setText("Try again!");
        information2.setFont(new Font("Verdana", Font.BOLD, 25));
        
        information2.setAlignmentX(Component.CENTER_ALIGNMENT);
        information2.setForeground(Color.BLACK);

        failPanel.setLayout(new BoxLayout(failPanel, BoxLayout.Y_AXIS));
        failPanel.setBackground(Color.WHITE);

        failPanel.add(Box.createVerticalGlue());
        failPanel.add(failLabel);
        failPanel.add(Box.createVerticalStrut(20));
        failPanel.add(information2);
        failPanel.add(Box.createVerticalGlue());
       
        fail.setLayout(new BorderLayout());
        fail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fail.setSize(500, 500);
        fail.setResizable(true);
        fail.setVisible(true);
        fail.add(failPanel, BorderLayout.CENTER);
        fail.setLocationRelativeTo(null);

    }

    /**
     * Handles the action when a fruit is collected.
     */
    public void fruitAction() {
        scores.fruits();
        SoundManager.playSound("fruit.wav");
    }
     
    /**
     * Handles the action when a fake fruit is collected, reverses controls for a duration.
     */
    public void fakeFruitAction() {
        scores.fakeFruit();
        SoundManager.playSound("fakefruit.wav");

        mainFrame.getPanel('b').removeAll();
        mainFrame.getFrame().repaint();
        JButton[] reversedbButtons = mainFrame.getButtons();
        String[] original = mainFrame.getPositions('o');
        String[] positions2 = mainFrame.getPositions('r');
        String[] buttonNames = mainFrame.getNames();

        for (int i = 0; i < buttonNames.length; i++) {
            reversedbButtons[i].setFocusable(false);
            mainFrame.getPanel('b').add(reversedbButtons[i], positions2[i]);
        }
        mainFrame.getFrame().add(mainFrame.getPanel('b'), BorderLayout.SOUTH);
        mainFrame.getPanel('b').add(mainFrame.getPanel('c'), BorderLayout.CENTER);
        mainFrame.getFrame().revalidate();
        mainFrame.getPanel('b').repaint();
        mainFrame.getFrame().repaint();

        controlsReversed = true;

        int duration = 10000;
        if (timeReversed != null && timeReversed.isRunning()) {
            timeReversed.stop();
        }
        timeReversed = new Timer(duration, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controlsReversed = false;
                for (int i = 0; i < buttonNames.length; i++) {
                    reversedbButtons[i].setFocusable(false);
                    mainFrame.getPanel('b').add(reversedbButtons[i], original[i]);
                }
                mainFrame.getFrame().add(mainFrame.getPanel('b'), BorderLayout.SOUTH);
                mainFrame.getPanel('b').add(mainFrame.getPanel('c'), BorderLayout.CENTER);
                mainFrame.getFrame().revalidate();
                mainFrame.getPanel('b').repaint();
                mainFrame.getFrame().repaint();
            }
        });
        timeReversed.setRepeats(false);
        timeReversed.start();
    }

    public boolean reversed() {
        return controlsReversed;
    }
    

}
