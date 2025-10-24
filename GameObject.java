import java.util.Random;

/**
 * GameObject represents an object in the maze game, such as fruits or traps.
 * It manages the object's symbol and its position on the game board.
 */
public class GameObject {

    public char symbol; 
    public Random location;
    public Position pos;

    /**
     * Constructs a GameObject with the specified symbol.
     *
     * @param symbol The character symbol representing the game object.
     */
    public GameObject(char symbol) {
        this.symbol = symbol; 
        location = new Random();
        pos = new Position(0, 0);
        
    }

    /**
     * Adds the game object to the board at random valid positions.
     *
     * @param board The board object representing the maze game.
     * @param amount The number of game objects to add to the board.
     */
    public void add(Board board, int amount) {
        int randX; 
        int randY;
        for (int i = 0; i < amount; i++) {
            while (pos.getX() == 0 || pos.getY() == 0) {
                randX = location.nextInt(board.boardSize());
                randY = location.nextInt(board.boardSize());
                if (randX   %  2 != 0 && (randX != 0 || randX != board.boardSize())) {
                    pos.setX(randX);
                }   
                if (randY % 2 != 0 && (randY != 0 || randY != board.boardSize())) {
                    pos.setY(randY);
                }
                if (board.getValue(pos.getX(), pos.getY()) == 'X' 
                    || board.getValue(pos.getX(), pos.getY()) == '8') {
                    pos.setX(0);
                    pos.setY(0);
                }
        }
            
            board.setValueBox(pos.getX(), pos.getY(), symbol);
        }
    }
    
}