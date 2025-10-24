import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Difficulty2 class creates a JFrame to select the difficulty level
 * of the maze game. It provides three buttons: Easy, Medium, and Hard,
 * each corresponding to different game parameters.
 */
public class Difficulty2 {

    private JFrame frame;
    private JButton easy;
    private JButton medium;
    private JButton hard;
    private BoxLayout boxLayout;

    /**
     * Constructs the difficulty selection window, initializes the buttons,
     * sets their properties, and attaches action listeners to start
     * the game with the chosen difficulty.
     */
    public Difficulty2() {
        frame = new JFrame("Difficulty");
        boxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);

        Font font = new Font("Verdana", Font.BOLD, 40);
        Dimension buttonSize = new Dimension(300, 60);

        // Initialize Easy button
        easy = new JButton();
        easy.setText("Easy");
        easy.setFont(font);
        easy.setAlignmentX(Component.CENTER_ALIGNMENT);
        easy.setMaximumSize(buttonSize);
        easy.setPreferredSize(buttonSize);
        easy.setBackground(new Color(0, 255, 0));

        // Initialize Medium button
        medium = new JButton();
        medium.setText("Medium");
        medium.setFont(font);
        medium.setAlignmentX(Component.CENTER_ALIGNMENT);
        medium.setMaximumSize(buttonSize);
        medium.setPreferredSize(buttonSize);
        medium.setBackground(new Color(255, 204, 50));

        // Initialize Hard button
        hard = new JButton();
        hard.setText("Hard");
        hard.setFont(font);
        hard.setAlignmentX(Component.CENTER_ALIGNMENT);
        hard.setMaximumSize(buttonSize);
        hard.setPreferredSize(buttonSize);
        hard.setBackground(new Color(255, 0, 0));

        // Add buttons and spacing to the frame
        frame.add(Box.createVerticalGlue());
        frame.add(easy);
        frame.add(Box.createRigidArea(new Dimension(0, 30)));
        frame.add(medium);
        frame.add(Box.createRigidArea(new Dimension(0, 30)));
        frame.add(hard);
        frame.add(Box.createVerticalGlue());

        // Set frame properties
        frame.setLayout(boxLayout);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setBackground(Color.WHITE);
        frame.setVisible(true);

        // Add action listeners for each button

        easy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                int size = 7;
                int easyFruit = 5;
                int easyFakeFruit = 2;
                int easyTraps = 0;
                new MazeGameGUI(size, easyFruit, easyFakeFruit, easyTraps);
            }
        });

        hard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                int size = 20;
                int hardFruit = 15;
                int hardFakeFruit = 10;
                int hardTraps = 3;
                new MazeGameGUI(size, hardFruit, hardFakeFruit, hardTraps);
            }
        });

        medium.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                int size = 12;
                int mediumFruit = 6;
                int mediumFakeFruit = 5;
                int mediumTraps = 2;
                new MazeGameGUI(size, mediumFruit, mediumFakeFruit, mediumTraps);
            }
        });
    }
}
