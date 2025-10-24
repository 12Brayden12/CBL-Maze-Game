/**
 * Position represents a coordinate on the game board with x and y values.
 * Used to track locations of the player, fruits, traps.
 */
public class Position {

    private int xCord;
    private int yCord;

    /**
     * Constructs a Position with specified x and y coordinates.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public Position(int x, int y) {
        this.xCord = x;
        this.yCord = y;
        
    }
    
    /**
     * Constructs a Position initialized to (0, 0).
     */
    public Position() {
        xCord = 0;
        yCord = 0;
    }

    public int getX() {
        return xCord;
    }

    public int getY() {
        return yCord;
    }

    public void setX(int x) {
        this.xCord = x;   
    }

    public void setY(int y) {
        this.yCord = y;
    }
}
