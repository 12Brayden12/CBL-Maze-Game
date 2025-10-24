import java.util.Random;

/**
 * Represents a game object with a symbol and position on the board.
 */
public class GameObject {

    public char symbol; 
    public Random location;
    public Position pos;

/**
     * Constructs a GameObject with the specified symbol.
     *
     * @param symbol the character symbol representing the game object
     */
    public GameObject(char symbol) {
        this.symbol = symbol; 
        location = new Random();
        pos = new Position(0,0);
        
    }

    /**
     * Adds the game object to the board at random valid positions.
     *
     * @param board the game board
     * @param amount the number of objects to add
     */
    public void add(Board board, int amount) {
        for (int i = 0; i < amount; i++) {
            Position validPos = findValidPosition(board);
            board.setValueBox(validPos.getX(), validPos.getY(), symbol);
        }
    }

    /**
     * Finds a valid random position on the board for the object.
     *
     * @param board the game board
     * @return a valid Position object
     */
    private Position findValidPosition(Board board) {
        int randX, randY;
        Position tempPos = new Position(0, 0);
        while (tempPos.getX() == 0 || tempPos.getY() == 0) {
            randX = location.nextInt(board.boardSize());
            randY = location.nextInt(board.boardSize());
            if (randX % 2 != 0 && (randX != 0 || randX != board.boardSize())) {
                tempPos.setX(randX);
            }
            if (randY % 2 != 0 && (randY != 0 || randY != board.boardSize())) {
                tempPos.setY(randY);
            }
            if (board.getValue(tempPos.getX(), tempPos.getY()) == 'X' || board.getValue(tempPos.getX(), tempPos.getY()) == '8') {
                tempPos.setX(0);
                tempPos.setY(0);
            }
        }
        return tempPos;
    }
    
}