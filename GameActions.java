import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.File;

public class GameActions {
    private Timer timeReversed;
    private JFrame win;
    private JFrame fail;
    private JLabel winLabel;
    private JLabel failLabel;
    private JLabel scoreLabel;
    private TimerAndScore scores;
    private static boolean controlsReversed;
    Font font;
    private MazeGameGUI mainFrame;
    private Clip bgmClip;

    public void playBGM(String bgmFile){
        try{
            File musicPath = new File("sounds/"+bgmFile);
            if (musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                bgmClip = AudioSystem.getClip();
                bgmClip.open(audioInput);
                bgmClip.loop(Clip.LOOP_CONTINUOUSLY);
                bgmClip.start();
            } else {
                System.out.println("Can't find file");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void stopBGM() {
        if (bgmClip != null) {
            if (bgmClip.isRunning())
            bgmClip.stop();
        }
            bgmClip.close();
            bgmClip = null;
    }


    public GameActions(MazeGameGUI gui, Board board,TimerAndScore scores) {
        
        mainFrame = gui;
        controlsReversed = false;
        this.scores = scores;

        
       

        font = new Font("Verdana", Font.BOLD, 40);
        winLabel = new JLabel();
        failLabel = new JLabel();
        scoreLabel = new JLabel();
        playBGM("bgm.wav");
        
        
    }
    public void Win() {

            stopBGM();

            int finalScore = scores.finalScore();
            scores.timerStop();
            
            scoreLabel.setText("Your final score is: " + finalScore);
            win = new JFrame("Win!");
            mainFrame.getFrame().dispose();
            winLabel.setText("Congratulations!!! You successfully reached the end of the game!!");
            winLabel.setFont(font);
            
            BoxLayout boxlayout = new BoxLayout(win.getContentPane(), BoxLayout.Y_AXIS);
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
        
        stopBGM();
        
        mainFrame.getFrame().dispose();
        fail = new JFrame("Game Over");
        fail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fail.setSize(500,500);
        fail.setResizable(true);

        JLabel label = new JLabel("GAME OVER", SwingConstants.CENTER);
        label.setFont(new Font("Verdana", Font.BOLD, 50));
        label.setForeground(Color.RED);
        fail.setVisible(true);
        fail.setLocationRelativeTo(null);
      


        
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
        scores.fruits();
        playSound("fruit.wav");
     }
     
     public void fakeFruitAction() {
        
        scores.fakeFruit();
        playSound("fakefruit.wav");
        
        mainFrame.getPanel('b').removeAll();
        mainFrame.getFrame().repaint();
        JButton[] reversedbButtons = mainFrame.getButtons();
        String[] original = mainFrame.getPositions('o');
        String[] positions2 = mainFrame.getPositions('r');
        String[] buttonNames = mainFrame.getNames();
        
        for ( int i = 0; i < buttonNames.length; i++) {

            reversedbButtons[i].setFocusable(false);
            mainFrame.getPanel('b').add(reversedbButtons[i],positions2[i]);
        }
        mainFrame.getFrame().add(mainFrame.getPanel('b'),BorderLayout.SOUTH);
        mainFrame.getPanel('b').add(mainFrame.getPanel('c'),BorderLayout.CENTER);
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
                for ( int i = 0; i < buttonNames.length; i++) {
                    reversedbButtons[i].setFocusable(false);
                    mainFrame.getPanel('b').add(reversedbButtons[i],original[i]);

                }
                mainFrame.getFrame().add(mainFrame.getPanel('b'),BorderLayout.SOUTH);
                mainFrame.getPanel('b').add(mainFrame.getPanel('c'),BorderLayout.CENTER);
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

    public void playSound(String soundFileName) {
        try {
            File soundFile = new File("sounds/" + soundFileName); 
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
