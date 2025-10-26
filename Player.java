
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 * Player class represents the player character in the maze game.
 * It handles player movement based on keyboard input and interacts
 * with the game board and score tracking.
 */
public class Player extends JPanel implements ActionListener {
    
    private final Board board;
    private Position chpos;
    private TimerAndScore scores;
    private MazeGameGUI gui;
    private GameActions actions;
    

    
    /**
     * Constructs a Player object with the specified board and score tracking.
     *
     * @param board The board object representing the maze game.
     * @param scores The TimerAndScore object for tracking scores.
     */
    public Player(MazeGameGUI gui, Board board, TimerAndScore scores) {
        this.board = board;
        this.scores = scores;
        actions = new GameActions(gui, board, scores);
        this.chpos = new Position(1, 1);
        this.gui = gui;
      
    }
    

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    /**
     * KeyListener class for handling keyboard input.
     */
    public class MyKeyListener extends KeyAdapter { 

        /** Handles key press events for player movement. */
        public void keyPressed(KeyEvent e) {
            if (actions.reversed()) {
                if (e.getKeyChar() == 'w') {
                    move(board, 0, -1);
                } else if (e.getKeyChar() == 's') {
                    move(board, 0, +1);
                } else if (e.getKeyChar() == 'a') {
                    move(board, +1, 0);
                    
                } else  if (e.getKeyChar() == 'd') {
                    move(board, -1, 0);
                    
                }
                
            } else {
                if (e.getKeyChar() == 'w') {
                    System.out.println("left");
                    move(board, 0, +1);
                } else if (e.getKeyChar() == 's') {
                    System.out.println("right");
                    move(board, 0, -1);
                    
                } else if (e.getKeyChar() == 'a') {
                    System.out.println("down");
                    move(board, -1, 0);
                    
                } else  if (e.getKeyChar() == 'd') {
                    System.out.println("up");
                    move(board, +1, 0);
                }
                

            }

        }
    }

    /**
     * Moves the player character in the specified direction on the board.
     *
     * @param board The board object representing the maze game.
     * @param dx The x-coordinate offset for movement.
     * @param dy The y-coordinate offset for movement.
     */
    public void move(Board board, int dx, int dy) {

        if (board.getValue(chpos.getX() + dx, chpos.getY() + dy) != '#'
             && board.getValue(chpos.getX() + dx, chpos.getY() + dy) != '=') {
            board.setValueBox(chpos.getX(), chpos.getY(), 'o');

            chpos.setX(chpos.getX() + dx);
            chpos.setY(chpos.getY() + dy);

            if (board.getValue(chpos.getX(), chpos.getY()) == '8') {
                actions.win();
                
                
            } else if (board.getValue(chpos.getX(), chpos.getY())  == '+') {
                
                actions.fruitAction();
                board.setValueBox(chpos.getX(), chpos.getY(), 'X');
                
            } else if (board.getValue(chpos.getX(), chpos.getY()) == '!') {
                actions.fakeFruitAction();
                
                board.setValueBox(chpos.getX(), chpos.getY(), 'X');
                
            } else if (board.getValue(chpos.getX(), chpos.getY()) == '@') {
                actions.gameOver();
                
            } else {
                board.setValueBox(chpos.getX(), chpos.getY(), 'X');
            }
            
        }

    }


    
}
