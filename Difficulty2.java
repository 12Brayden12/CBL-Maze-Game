import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Component;
import java.awt.Dimension;

public class Difficulty2 {
    
    private JFrame frame;
    private JPanel panel;
    private JButton easy;
    private JButton medium;
    private JButton hard;
    private BoxLayout boxLayout;

    public Difficulty2() {
        frame = new JFrame("Difficulty");
        boxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        Font font = new Font("Verdana", Font.BOLD, 40);
        Dimension buttonSize = new Dimension(300,60);
        easy = new JButton();
        easy.setText("Easy");
        easy.setFont(font);
        easy.setAlignmentX(Component.CENTER_ALIGNMENT);
        easy.setMaximumSize(buttonSize);
        easy.setPreferredSize(buttonSize);
        easy.setBackground(new Color(0, 255, 0));
        medium = new JButton();
        medium.setText("Medium");
        medium.setFont(font);
        medium.setAlignmentX(Component.CENTER_ALIGNMENT);
        medium.setMaximumSize(buttonSize);
        medium.setPreferredSize(buttonSize);
        medium.setBackground(new Color(255, 204, 50)); 
        hard = new JButton();
        hard.setText("Hard");
        hard.setFont(font);
        hard.setAlignmentX(Component.CENTER_ALIGNMENT);
        hard.setMaximumSize(buttonSize);
        hard.setPreferredSize(buttonSize);
        hard.setBackground(new Color(255, 0, 0));

        frame.add(Box.createVerticalGlue());
        frame.add(easy);
        frame.add(Box.createRigidArea(new Dimension(0, 30)));
        frame.add(medium);
        frame.add(Box.createRigidArea(new Dimension(0, 30)));
        frame.add(hard);
        frame.add(Box.createVerticalGlue());
        
        frame.setLayout(boxLayout);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setBackground(Color.WHITE);
        frame.setVisible(true);




        easy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                int size = 10;
                int easyFruit = 50;
                int easyFakeFruit = 20;
                int easyTraps = 10;
                new MazeGameGUI(size,easyFruit, easyFakeFruit, easyTraps);
            }
        });
        hard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                int size = 20;
                int hardFruit = 10;
                int hardFakeFruit = 7;
                int hardTraps = 6;
                new MazeGameGUI(size,hardFruit, hardFakeFruit, hardTraps);
            }
        });
        medium.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                int size = 100;
                int mediumFruit = 7;
                int mediumFakeFruit = 5;
                int mediumTraps = 4;
                new MazeGameGUI(size,mediumFruit, mediumFakeFruit, mediumTraps);
            }
            
        });

    }

}
