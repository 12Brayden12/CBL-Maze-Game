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
    private JPanel centralbuttons;
    private JButton newGame;
    private JButton menu;
    private JButton[] buttons;
    private String[] buttonNames;
    private String[] positions;
    private String[] reversedPositions;
    private ActionListener[] actions;
    private GameActions gameactions;
    private TimerAndScore scores;
    

   
    

    public MazeGameGUI(int size,int difficulty, int difficulty1, int difficulty2) {
        tester = new Board(size , size, difficulty, difficulty1, difficulty2);
        scores = new TimerAndScore(tester,this);
        scores.timerStart();

        testPlayer = new Player(this,tester,scores);
        
        


        gameFrame = new JFrame();
        mazePanel = new JPanel();
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        gameactions = new GameActions(this, tester,scores);
        centralbuttons = new JPanel();
        newGame = new JButton();
        menu = new JButton();
        
        gameFrame.setTitle("Maze Game");
        gameFrame.setLayout(new BorderLayout());
        gameFrame.setSize(700, 700);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setResizable(true);
        gameFrame.setLocationRelativeTo(null);
        
 

        mazePanel.setLayout(new BorderLayout());
        mazePanel.add(tester, BorderLayout.CENTER);
        mazePanel.setFocusable(true);
       

        mazePanel.addKeyListener(new KeyAdapter() {
            
            public void keyPressed(KeyEvent e ) {
                int keyCode = e.getKeyCode();
                if (gameactions.reversed()) {
                    if (e.getKeyChar() == 'w' || keyCode == KeyEvent.VK_UP) {
                    testPlayer.Move(tester, 0, +1);
                    
                } else if (e.getKeyChar() == 's' || keyCode == KeyEvent.VK_DOWN) {
                    testPlayer.Move(tester, 0, -1);
                    
                } else if (e.getKeyChar() == 'd' || keyCode == KeyEvent.VK_RIGHT) {
                    
                    testPlayer.Move(tester, -1, 0);
                } else if (e.getKeyChar() == 'a' || keyCode == KeyEvent.VK_LEFT) {
                    testPlayer.Move(tester, +1, 0);
                }
                    
                } else {
                if (e.getKeyChar() == 'w' || keyCode == KeyEvent.VK_UP) {
                    System.out.println("w");
                    testPlayer.Move(tester, 0, -1);
                    
                } else if (e.getKeyChar() == 's' || keyCode == KeyEvent.VK_DOWN) {
                    System.out.println("s");
                    testPlayer.Move(tester, 0, +1);
                    
                } else if (e.getKeyChar() == 'd' || keyCode == KeyEvent.VK_RIGHT) {
                    System.out.println("d");
                    testPlayer.Move(tester, +1, 0);
                } else if (e.getKeyChar() == 'a' || keyCode == KeyEvent.VK_LEFT) {
                    System.out.println("a");
                    testPlayer.Move(tester, -1, 0);
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
        reversedPositions = new String[] {BorderLayout.SOUTH, BorderLayout.NORTH,BorderLayout.WEST,BorderLayout.EAST};
        actions = new ActionListener[] {
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("up");
                        testPlayer.Move(tester, 0, -1);
                    }
                },
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("down");
                        testPlayer.Move(tester, 0, +1);
                    }
                },
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("right");
                        testPlayer.Move(tester, +1, 0);
                    }
                },
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("left");
                        testPlayer.Move(tester,-1,0);
                    }
                }
            };
            for (int i = 0; i < buttons.length;i++){
                buttons[i] = new JButton(buttonNames[i]);
                buttons[i].setFocusable(false);
                buttons[i].addActionListener(actions[i]);
                bottomPanel.add(buttons[i],positions[i]);
                
            }
        centralbuttons.setLayout(new FlowLayout());
        centralbuttons.setBackground(Color.WHITE);
        
        newGame.setText("New Game");
        menu.setText("Menu");
        newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.setAlignmentX(Component.CENTER_ALIGNMENT);
        newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameFrame.dispose();
                new MazeGameGUI(size, difficulty, difficulty1, difficulty2);
            }
        });
        menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameFrame.dispose();
                new GameMenu();
            }
        });
        centralbuttons.add(newGame);
        centralbuttons.add(menu);

        bottomPanel.add(centralbuttons,BorderLayout.CENTER);
        
        
        gameFrame.add(bottomPanel, BorderLayout.SOUTH);
    
        topPanel.setLayout(new FlowLayout());
        topPanel.setBackground(Color.WHITE);
        topPanel.add(scores.getFakeFruits());
        topPanel.add(scores.getScoreLabel());
        topPanel.add(scores.getTimeLabel());

        gameFrame.add(topPanel,BorderLayout.NORTH);
        scores.timerStart();
   
        gameFrame.setVisible(true);
        mazePanel.requestFocusInWindow();
      
    
}
    public JFrame getFrame() {
        return gameFrame;
    }
    public JPanel getPanel(char panel) { 
        if (panel == 'm') {
            return mazePanel;

            
        } else if (panel == 't') {
            return topPanel;
            
        } else if (panel == 'c') {
            return centralbuttons;
        } else {
            return bottomPanel;
        }
    }
    public JButton[] getButtons() {
        return buttons;
    }
    public String[] getPositions(char x) {
       if (x == 'o') {
         return positions;
       } else{
           return reversedPositions;

       }
        }
    public String[] getNames() {
        return buttonNames;
    }
    
    }

