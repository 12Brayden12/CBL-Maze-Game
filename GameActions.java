import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.*;

public class GameActions {
    private Board board;
    private JFrame win;
    private JFrame fail;
    private JLabel winLabel;
    private JLabel failLabel;
    private JLabel scoreLabel;
    private  int score;
    private boolean controlsReversed;
    Font font = new Font("Verdana", Font.BOLD, 40);
    
    
    public void Win(int score) {
            win = new JFrame("Win!");
            winLabel = new JLabel();
            winLabel.setText("Congratulations!!! You successfully reached the end of the game!!");
            winLabel.setFont(font);
            scoreLabel = new JLabel();
            scoreLabel.setText("Your score " );
            BoxLayout boxlayout = new BoxLayout(win, BoxLayout.Y_AXIS);
            win.setLayout(boxlayout);
            win.setBackground(Color.WHITE);
            win.add(Box.createVerticalGlue());
            win.add(winLabel);
            win.add(Box.createVerticalGlue());
            win.add(scoreLabel);
            win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            win.setSize(500,500);
            win.setResizable(true);
            win.setLocationRelativeTo(null);
            win.setVisible(true);


    }
    public void GameOver() {
        fail = new JFrame("Game Over");
        fail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fail.setSize(500,500);
        fail.setResizable(true);
        fail.setLocationRelativeTo(null);
      


        failLabel = new  JLabel();
        failLabel.setText("Game Over!!!");
        failLabel.setFont(font);
        failLabel.setBackground(Color.BLACK);
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());
        panel.add(failLabel,BorderLayout.CENTER);
        fail.add(panel);
        fail.setVisible(true);

    }

    
     public void fruitAction() {
        score += 50;
     }
     public int score() {
        return score;
     }
     public void fakeFruitAction() {
        if(controlsReversed) return;
        controlsReversed = true;
        int duration = 10000;
        Timer time = new Timer(duration, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controlsReversed = false;
            }
            
        });
        time.setRepeats(false);
        time.start();
    }
    public boolean reversed() {
        return controlsReversed;
    }

    
}
