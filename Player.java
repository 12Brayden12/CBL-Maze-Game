import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import javax.swing.*;
public class Player extends JPanel implements ActionListener {
    
    private final Board board;
    private Position pos;
    private int dx;
    private int dy;
    private GameActions actions;
    

    public Player(Board board) {
        this.board = board;
        actions = new GameActions();
      
    }
    

    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    public class MyKeyListener extends KeyAdapter { 
        public void keyPressed(KeyEvent e) {
            if (actions.reversed()) {
                if (e.getKeyChar() == 'a') {
                    System.out.println("button press");
                    new Move(board, dx, dy);
                } else if (e.getKeyChar() == 'd') {
                    new Move(board, dx, dy);
                } else if (e.getKeyChar() == 's') {
                    new Move(board, dx, dy)
                    
                } else  if (e.getKeyChar() == 'w') {
                    
                }
                
            } else {
                if (e.getKeyChar() == 'a') {
                    lDir.moveDirection(board);
                } else if (e.getKeyChar() == 'd') {
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
