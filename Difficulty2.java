import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


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
        
        easy = new JButton();
        easy.setText("Easy");
        easy.setFont(font);
        medium = new JButton();
        medium.setText("Medium");
        medium.setFont(font);
        hard = new JButton();
        hard.setText("Hard");
        hard.setFont(font);
        
        frame.add(easy);
        frame.add(medium);
        frame.add(hard);
        
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
                int easyFruit = 0;
                int easyFakeFruit = 0;
                int easyTraps = 0;
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
                int size = 15;
                int mediumFruit = 7;
                int mediumFakeFruit = 5;
                int mediumTraps = 4;
                new MazeGameGUI(size,mediumFruit, mediumFakeFruit, mediumTraps);
            }
            
        });

    }

}
