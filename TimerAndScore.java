import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TimerAndScore {
    private Timer timer;
    private int remainingTime;
    private int fruitsCollected;
    private int fakeFruitsCollected;
    private JLabel scoreLabel;
    private JLabel timeLabel;
    private JLabel fakeFruitLabel;
    private GameActions actions;
   


    public TimerAndScore(Board board, MazeGameGUI gui) {
        this.fruitsCollected = 0;
        this.fakeFruitsCollected = 0;
        actions = new GameActions(gui, board ,this);
        
        remainingTime = 25;
        scoreLabel = new JLabel();
        scoreLabel.setText("Your score is: 0");
        
        
        timeLabel = new JLabel();
        fakeFruitLabel = new JLabel();
        fakeFruitLabel.setText("Collected fakefruits: 0");
        
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e ) {
                remainingTime--;
                updateTimeLabel();
                if (remainingTime <= 0) {
                    timerStop();
                    actions.GameOver();


                    
                }

            }
        } );
        timerStart();
    
    }
    public void updateTimeLabel() {
        timeLabel.setText("Text: " + remainingTime);

    }
    public void timerStart() {
        timer.start();
    }
    public void timerStop() {
        timer.stop();
    }
    public void fruits() {
        fruitsCollected+= 50;
        scoreLabel.setText("Your score is: " + fruitsCollected);
    }
    public void fakeFruit() {
        
        fakeFruitsCollected++;
        fakeFruitLabel.setText("Collected fake fruits: " +fakeFruitsCollected);
    }
    public JLabel getScoreLabel() {
        return scoreLabel;
    }
    public JLabel getTimeLabel() {
        return timeLabel;
    }
    public JLabel getFakeFruits() {
        return fakeFruitLabel;
    }
    public int finalScore() {
        return fruitsCollected + remainingTime*10;
    }
    
}
