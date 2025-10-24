
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * TimerAndScore class handles the game's timer, score tracking, and fake fruit count.
 * It provides labels for displaying remaining time, collected fruits, and fake fruits,
 * and interacts with GameActions to handle game over conditions.
 */
public class TimerAndScore {
    private Timer timer;
    private int remainingTime;
    private int fruitsCollected;
    private int fakeFruitsCollected;
    private JLabel scoreLabel;
    private JLabel timeLabel;
    private JLabel fakeFruitLabel;
    private GameActions actions;
   
    /**
    * Constructs a TimerAndScore object, initializing the game's timer, score tracking,
    * and fake fruit count. Sets up the JLabels for displaying score, remaining time,
    * and fake fruits collected, and starts a Swing Timer that reduce the time
    * every second and triggers game over when time reaches zero.
    *
    * @param board the game board associated with this timer and score tracker
    * @param gui   the MazeGameGUI instance to interact with GameActions
    */

    public TimerAndScore(Board board, MazeGameGUI gui) {
        this.fruitsCollected = 0;
        this.fakeFruitsCollected = 0;
        actions = new GameActions(gui, board, this);
        
        remainingTime = 100;
        scoreLabel = new JLabel();
        scoreLabel.setText("Your score is: 0");
        
        
        timeLabel = new JLabel();
        fakeFruitLabel = new JLabel();
        fakeFruitLabel.setText("Collected fakefruits: 0");
        
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remainingTime--;
                updateTimeLabel();
                if (remainingTime <= 0) {
                    timerStop();
                    actions.GameOver();


                    
                }

            }
        });
        timerStart();
    
    }

    /**
    * Updates the timeLabel to reflect the current remaining time.
    */
    public void updateTimeLabel() {
        timeLabel.setText("Text: " + remainingTime);

    }

    public void timerStart() {
        timer.start();
    }

    public void timerStop() {
        timer.stop();
    }

    /**
     * Increases the player's score by 50 points when a real fruit is collected
     * and updates the scoreLabel with the new total score.
     */
    public void fruits() {
        fruitsCollected += 50;
        scoreLabel.setText("Your score is: " + fruitsCollected);
    }
    
    /**
    * Increase the count of collected fake fruits by one
    * and updates the fakeFruitLabel to show the current total.
    */
    public void fakeFruit() {
        
        fakeFruitsCollected++;
        fakeFruitLabel.setText("Collected fake fruits: " + fakeFruitsCollected);
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
        return fruitsCollected + remainingTime * 10;
    }
    
}
