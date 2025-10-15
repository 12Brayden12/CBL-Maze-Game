import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import javax.swing.*;
public class Player extends JPanel implements ActionListener {
    
    private final Board board;
    private GameActions actions;

    public Player(Board board) {
        this.board = board;
        actions = new GameActions();
      
    }
    MoveLeft lDir = new MoveLeft();
    MoveRight rDir = new MoveRight();
    MoveDown dDir = new MoveDown();
    MoveUp uDir = new MoveUp();

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public class MyKeyListener extends KeyAdapter { 
        public void keyPressed(KeyEvent e) {
            if (actions.reversed()) {
                if (e.getKeyChar() == 'a') {
                    rDir.moveDirection(board);
                } else if (e.getKeyChar() =='d') {
                    lDir.moveDirection(board);
                } else if (e.getKeyChar() == 's') {
                    uDir.moveDirection(board);
                    
                } else  if (e.getKeyChar() == 'w') {
                    dDir.moveDirection(board);
                }
                
            } else {
                if (e.getKeyChar() == 'a') {
                    lDir.moveDirection(board);
                } else if (e.getKeyChar() =='d') {
                    rDir.moveDirection(board);
                    
                } else if (e.getKeyChar() == 's') {
                    dDir.moveDirection(board);
                    
                } else  if (e.getKeyChar() == 'w') {
                    uDir.moveDirection(board);
                }
                

            }

        }
    }
    
}
