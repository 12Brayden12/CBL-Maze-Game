import java.awt.*;
import java.awt.event.ActionEvent;
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
    private String[] buttonNames;
    private String[] positions;
    private ActionListener[] actions;
    private GameActions actions2;
    

    public MazeGameGUI(int difficulty, int difficulty1, int difficulty2) {
        tester = new Board(10, 10, difficulty, difficulty1, difficulty2);
        testPlayer = new Player(tester);

        gameFrame = new JFrame();
        mazePanel = new JPanel();
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        actions2 = new GameActions();
        
        gameFrame.setTitle("Maze Game");
        gameFrame.setLayout(new BorderLayout());
        gameFrame.setSize(500, 500);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setResizable(true);
        gameFrame.setLocationRelativeTo(null);
        
 

        mazePanel.setLayout(new BorderLayout());
        mazePanel.add(tester, BorderLayout.CENTER);
        mazePanel.setFocusable(true);
       

        mazePanel.addKeyListener(new KeyAdapter() {
            
            public void keyPressed(KeyEvent e ) {
                int keyCode = e.getKeyCode();
                if (actions2.reversed()) {
                    if (e.getKeyChar() == 'w' || keyCode == KeyEvent.VK_UP) {
                    testPlayer.dDir.moveDirection(tester);
                    
                } else if (e.getKeyChar() == 's' || keyCode == KeyEvent.VK_DOWN) {
                    testPlayer.uDir.moveDirection(tester);
                    
                } else if (e.getKeyChar() == 'd' || keyCode == KeyEvent.VK_RIGHT) {
                    testPlayer.lDir.moveDirection(tester);
                } else if (e.getKeyChar() == 'a' || keyCode == KeyEvent.VK_LEFT) {
                    testPlayer.rDir.moveDirection(tester);
                }
                    
                } else {
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
        }         
        });
    
        gameFrame.add(mazePanel,BorderLayout.CENTER);

   
    
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBackground(Color.WHITE);
        
        
        

        buttons = new JButton[4];
        buttonNames = new String[] {"Up","Down","Right","Left"};
        positions = new String[] {BorderLayout.NORTH,BorderLayout.SOUTH,BorderLayout.EAST,BorderLayout.WEST};

        actions = new ActionListener[] {
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        testPlayer.uDir.moveDirection(tester);
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

        for (int i = 0; i < buttons.length;i++){
            buttons[i] = new JButton(buttonNames[i]);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(actions[i]);
            bottomPanel.add(buttons[i],positions[i]);
        }
        gameFrame.add(bottomPanel, BorderLayout.SOUTH);
    
        topPanel.setLayout(new FlowLayout());
        topPanel.setBackground(Color.BLACK);
        gameFrame.add(topPanel,BorderLayout.NORTH);
   
        gameFrame.setVisible(true);
        mazePanel.requestFocusInWindow();
      
    
}
    }

