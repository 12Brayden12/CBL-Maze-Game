import java.awt.*;
import java .awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.border.Border;

import java.util.ArrayList;
public class MazeGameGUI {
    
    private final Board tester;
    private final Player testPlayer;
    private JFrame gameFrame;
    private JPanel mazePanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JButton[] buttons;
    

    public MazeGameGUI(int difficulty) {

        tester = new Board(0, 0, difficulty, difficulty, difficulty);
        testPlayer = new Player(tester);

        gameFrame = new JFrame();
        mazePanel = new JPanel();
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        
        

    }
    public void MazeFrame() {
        gameFrame.setTitle("Maze Game");
        gameFrame.setLayout(new BorderLayout());
        gameFrame.setSize(500, 500);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setResizable(true);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
}  
public void mazePanel() {
        mazePanel.setLayout(new BorderLayout());
        mazePanel.add(tester, BorderLayout.CENTER);
        mazePanel.setFocusable(true);

        mazePanel.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e ) {
                int keyCode = e.getKeyCode();
                if (e.getKeyChar() == 'w' || keyCode == KeyEvent.VK_UP) {
                    testPlayer.uDir.moveDirection(tester);
                    
                } else if (e.getKeyChar() == 's' || keyCode == KeyEvent.VK_DOWN) {
                    testPlayer.dDir.moveDirection(tester);
                    
                } else if (e.getKeyChar() == 'd' || keyCode == KeyEvent.VK_RIGHT) {
                    testPlayer.rDir.moveDirection(tester);
                } else if (e.getKeyChar() == 'a' || keyCode == KeyEvent.VK_LEFT) {
                    testPlayer.lDir.moveDirection(tester);
                }
            }            
        });
        /*
        mazePanel.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                char[] chars = {'w','s','a','d'};
                int[] keycodes = {KeyEvent.VK_UP,KeyEvent.VK_DOWN,KeyEvent.VK_LEFT,KeyEvent.VK_RIGHT};
                Move[] directions = {testPlayer.uDir,testPlayer.dDir,testPlayer.lDir,testPlayer.rDir};
                for (int i=0; i < directions.length; i++) {
                    if (e.getKeyChar() == chars[i] || e.getKeyCode() == keycodes[i] ) {
                        directions[i].moveDirection(tester);
                    }

            }
                
            }
            
        });
         * 
         */
        gameFrame.add(mazePanel,BorderLayout.CENTER);

    }
    public void bottomPanel() {
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBackground(Color.WHITE);
        
    }
    public void buttonsAction() {
        buttons = new JButton[4];
        String[] buttonNames = {"Up","Down","Right","Left"};
        String[] positions = {BorderLayout.NORTH,BorderLayout.SOUTH,BorderLayout.EAST,BorderLayout.WEST};

        final MoveLeft lDir = new MoveLeft();
        final MoveRight rDir = new MoveRight();
        final MoveDown dDir = new MoveDown();
        final MoveUp uDir = new MoveUp();

            ActionListener[] actions = {
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        testPlayer.lDir.moveDirection(tester);
                    }
                },
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        testPlayer.dDir.moveDirection(tester);
                    }
                },
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        testPlayer.rDir.moveDirection(tester);
                    }
                },
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        testPlayer.lDir.moveDirection(tester);
                    }
                }
            };

    }
    public void addButtons(String[] buttonNames, String[] positions, ActionListener[] actions) {
        for (int i = 0; i < buttons.length;i++){
            buttons[i] = new JButton(buttonNames[i]);
            buttons[i].setFocusable(true);
            buttons[i].addActionListener(actions[i]);
            bottomPanel.add(buttons[i],positions[i]);
        }
        gameFrame.add(bottomPanel,BorderLayout.SOUTH);
    }
    public void topPanel() {
        topPanel.setLayout(new FlowLayout());
        topPanel.setBackground(Color.BLACK);
        gameFrame.add(topPanel,BorderLayout.NORTH);
    }
    
    
    
    
}
