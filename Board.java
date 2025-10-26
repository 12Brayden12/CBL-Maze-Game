import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * Board class represents the maze game board.
 * It handles the generation of the maze, placement of game objects,
 * rendering of the board, and provides methods to access and modify cells.
 */
public class Board extends JPanel {

    private char[][] entireBoard;
    private boolean[][] accessible;
    private int size;
    private int unVisited;
    private int scale;
    private Image trapImage;
    private Image playerImage;
    private Image fruitImage;
    private Image fakeFruitImage;
    private Image exitImage;
    ArrayList<Position> validPositions = new ArrayList<>();
    ArrayDeque<Position> positions = new ArrayDeque<>();

    /**
     * Constructs a Board instance.
     * Initializes the board size, generates the maze, places objects,
     * and loads images.
     *
     * @param x Width of the maze in cells
     * @param y Height of the maze in cells
     * @param fruitC Number of real fruits to place
     * @param fakeFruitC Number of fake fruits to place
     * @param trapC Number of traps to place
     */
    public Board(int x, int y, int fruitC, int fakeFruitC, int trapC) {
        initializeBoard(x, y);
        codeMaze();
        addGameObject('+', fruitC);
        addGameObject('!', fakeFruitC);
        addGameObject('@', trapC);

        // Load images for game objects
        trapImage = new ImageIcon("images/trap.jpg").getImage();
        playerImage = new ImageIcon("images/player.jpg").getImage();
        fruitImage = new ImageIcon("images/fruit.jpg").getImage();
        fakeFruitImage = new ImageIcon("images/fakeFruit.jpg").getImage();
        exitImage = new ImageIcon("images/exit.jpg").getImage();
    }

    /**
     * Initializes the board arrays and calculates scaling factors.
     *
     * @param width Maze width
     * @param length Maze length
     */
    public void initializeBoard(int width, int length) {
        unVisited = (width * width);
        width = width * 2 + 1;
        length = length * 2 + 1;
        scale = length;
        entireBoard = new char[width][length];
        size = width;
    }

    /**
     * Fills the board with initial values and generates walls.
     */
    public void codeMaze() {
        // Fill entire board with 'u' (unvisited)
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                entireBoard[row][col] = 'u';
            }
        }

        // Fill every second row/column with '=' to create initial walls
        for (int row = 0; row < size; row += 2) {
            for (int col = 0; col < size; col++) {
                entireBoard[row][col] = '=';
                entireBoard[col][row] = '=';
            }
        }

        // Add border walls '#'
        for (int row = 0; row < size; row++) {
            entireBoard[row][0] = '#';
            entireBoard[row][size - 1] = '#';
            entireBoard[0][row] = '#';
            entireBoard[size - 1][row] = '#';
        }

        // Start recursive maze generation
        generate(1, 1);
    }

    public int boardSize() {
        return size;
    }

    public int boardScale() {
        return scale;
    }

    /**
     * Sets the value of a specific cell and repaints the board.
     *
     * @param x Row index
     * @param y Column index
     * @param value Character to set
     */
    public void setValueBox(int x, int y, char value) {
        entireBoard[x][y] = value;
        repaint();
    }

    public char getValue(int x, int y) {
        return entireBoard[x][y];
    }

    /**
     * Paints the board, including walls, player, fruits, traps, and exit.
     *
     * @param g Graphics context
     */
    public void paint(Graphics g) {
        super.paint(g);
        int width = getWidth();
        int height = getHeight();
        int pixel = Math.min(width, height) / scale;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                char cell = entireBoard[row][col];
                if (cell == '=' || cell == '#') {
                    g.setColor(Color.black);
                    g.fillRect(row * pixel, col * pixel, pixel, pixel);
                } else if (cell == '8') {
                    g.drawImage(exitImage, row * pixel, col * pixel, pixel, pixel, this);
                } else if (cell == 'X') {
                    g.drawImage(playerImage, row * pixel, col * pixel, pixel, pixel, this);
                } else if (cell == '+') {
                    g.drawImage(fruitImage, row * pixel, col * pixel, pixel, pixel, this);
                } else if (cell == '!') {
                    g.drawImage(fakeFruitImage, row * pixel, col * pixel, pixel, pixel, this);
                } else if (cell == '@') {
                    g.drawImage(trapImage, row * pixel, col * pixel, pixel, pixel, this);
                }
            }
        }
    }

    /** Prints the board to console for debugging. */
    public void textVersion() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(entireBoard[row][col] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Places a specific number of game objects (fruits or traps) randomly on the board.
     *
     * @param symbol Character representing the object
     * @param amount Number of objects to place
     */
    public void addGameObject(char symbol, int amount) {
        Random location = new Random();

        for (int i = 0; i < amount; i++) {
            Position pos = new Position(0, 0);

            // Randomly choose a valid position (odd row/col inside borders)
            while (pos.getX() == 0 || pos.getY() == 0) {
                int randX = location.nextInt(size);
                int randY = location.nextInt(size);

                if (randX % 2 != 0 && randX != 0 && randX != size - 1) {
                    pos.setX(randX);
                }
                if (randY % 2 != 0 && randY != 0 && randY != size - 1) {
                    pos.setY(randY);
                }

                // Check if the position is empty
                if (getValue(pos.getX(), pos.getY()) != 'v') {
                    pos.setX(0);
                    pos.setY(0);
                }
            }

            setValueBox(pos.getX(), pos.getY(), symbol);
        }
    }

    /**
     * Returns the values of adjacent cells (north, south, east, west) relative to the current cell.
     *
     * @param currentCell Current position
     * @return Array of characters {west, east, south, north}
     */
    public char[] directionUpdate(Position currentCell) {
        char north = 0, south = 0, east = 0, west = 0;

        if (getValue(currentCell.getX(), currentCell.getY() + 1) != '#') {
            east = getValue(currentCell.getX(), currentCell.getY() + 2);
        }
        if (getValue(currentCell.getX(), currentCell.getY() - 1) != '#') {
            west = getValue(currentCell.getX(), currentCell.getY() - 2);
        }
        if (getValue(currentCell.getX() - 1, currentCell.getY()) != '#') {
            north = getValue(currentCell.getX() - 2, currentCell.getY());
        }
        if (getValue(currentCell.getX() + 1, currentCell.getY()) != '#') {
            south = getValue(currentCell.getX() + 2, currentCell.getY());
        }

        return new char[]{west, east, south, north};
    }

    /** Placeholder for position list (used in maze generation). */
    Position posList[] = new Position[(2 * (getX() / 2))];

    /** Current cell being processed during maze generation. */
    Position currentCell = new Position(5, 5);

    /**
     * Generates a random maze using depth-first search and backtracking.
     * Sets start ('X') and exit ('8') positions.
     *
     * @param posX Starting X coordinate
     * @param posY Starting Y coordinate
     */
    public void generate(int posX, int posY) {
        accessible = new boolean[size][size];
        currentCell = new Position(posX, posY);
        setValueBox(currentCell.getX(), currentCell.getY(), 'v');
        unVisited--;

        char[] direction = directionUpdate(currentCell);

        while (unVisited != 0) {
            int free = 0;

            // Check if any adjacent cells are unvisited
            if (direction[0] == 'u' || direction[1] == 'u'
                || direction[2] == 'u' || direction[3] == 'u') {

                free = 1;
            }

            Random generator = new Random();
            int random = generator.nextInt(4);
            setValueBox(currentCell.getX(), currentCell.getY(), 'v');

            int x = currentCell.getX();
            int y = currentCell.getY();

            // Move to a random unvisited adjacent cell
            if ((random == 0) && (direction[0] == 'u')) {
                if (getValue(x, y - 1) != '#') {
                    setValueBox(x, y - 1, 'v');
                    currentCell = new Position(x, y - 2);
                    positions.push(currentCell);
                    direction = directionUpdate(currentCell);
                    unVisited--;
                }
            } else if ((random == 1) && (direction[1] == 'u')) {
                if (getValue(x, y + 1) != '#') {
                    setValueBox(x, y + 1, 'v');
                    currentCell = new Position(x, y + 2);
                    positions.push(currentCell);
                    direction = directionUpdate(currentCell);
                    unVisited--;
                }
            } else if ((random == 2) && (direction[2] == 'u')) {
                if (getValue(x + 1, y) != '#') {
                    setValueBox(x + 1, y, 'v');
                    currentCell = new Position(x + 2, y);
                    positions.push(currentCell);
                    direction = directionUpdate(currentCell);
                    unVisited--;
                }
            } else if ((random == 3) && (direction[3] == 'u')) {
                if (getValue(x - 1, y) != '#') {
                    setValueBox(x - 1, y, 'v');
                    currentCell = new Position(x - 2, y);
                    positions.push(currentCell);
                    direction = directionUpdate(currentCell);
                    unVisited--;
                }
            } else {
                // Backtrack if no free adjacent cells
                if (free == 0 && positions.size() != 0) {
                    currentCell = positions.getLast();
                    positions.removeLast();
                    direction = directionUpdate(currentCell);
                }
            }
        }

        // Set exit and start positions
        setValueBox(currentCell.getX(), currentCell.getY(), '8');
        setValueBox(1, 1, 'X');
    }
}
