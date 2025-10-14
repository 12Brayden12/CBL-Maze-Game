import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import javax.swing.*;
public class Player extends JPanel implements ActionListener {
    
    private final Board board;

    public Player(Board board) {
        this.board = board;
      
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
            if (e.getKeyChar() == 'a') {
                lDir.moveDirection(board);
            } else if (e.getKeyChar() =='d') {
                rDir.moveDirection(board);
                
            } else if (e.getKeyChar() == 's') {
                dDir.moveDirection(board);
                
            } else {
                uDir.moveDirection(board);
            }

        }
    }
    
}
