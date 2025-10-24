import java.awt.*;
import java.math.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.html.parser.Entity;

/**
 * Board panel that generates and renders a maze for the game.
 */
public class Board extends JPanel {
    private char[][] entireBoard;
    private boolean[][] accessible;
    private int size;
    private int unVisited;
    private int scale=1;
    private Image trapImage;
    private Image playerImage;
    private Image fruitImage;
    private Image fakeFruitImage;
    private Image exitImage;

    ArrayList<Position> validPositions = new ArrayList<>();
    ArrayDeque<Position> positions = new ArrayDeque<>();

    /**
     * Constructs a Board with the given dimensions and numbers of objects.
     *
     * @param x width in cells
     * @param y height in cells
     * @param fruitC number of real fruits to place
     * @param fakeFruitC number of fake fruits to place
     * @param trapC number of traps to place
     */
    public Board(int x, int y, int fruitC, int fakeFruitC, int trapC) {
        initializeBoard(x, y);
        codeMaze();
        addGameObject('+', fruitC);
        addGameObject('!', fakeFruitC);
        addTraps(trapC);
        
        trapImage = new ImageIcon("images/trap.jpg").getImage();
        playerImage = new ImageIcon("images/player.jpg").getImage();
        fruitImage = new ImageIcon("images/fruit.jpg").getImage();
        fakeFruitImage = new ImageIcon("images/fakeFruit.jpg").getImage();
        exitImage = new ImageIcon("images/exit.jpg").getImage();
    }
    
    

    /**
     * Initializes the game board with the specified dimensions.
     * 
     * @param width the width of the board
     * @param length the length of the board
     */
    public void initializeBoard(int width, int length) {
        unVisited = (width * width);
        width *= 2;
        width++;
        length *= 2;
        length++;
        scale = length;
        entireBoard = new char[width][length];
        size = width;
    }

    /**
     * Creates the initial maze structure by setting up walls and boundaries.
     * This method initializes the maze grid and calls the maze generation algorithm.
     */
    public void codeMaze() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                entireBoard[row][col] = 'u';
            }
        }
        for (int row = 0; row < size; row += 2) {
            for (int col = 0; col < size; col++) {
                entireBoard[row][col] = '=';
                entireBoard[col][row] = '=';
            }
        }
        for (int row = 0; row < size; row++) {
            entireBoard[row][0] = '#';
            entireBoard[row][size - 1] = '#';
            entireBoard[0][row] = '#';
            entireBoard[size - 1][row] = '#';
            
        }
        generate(1, 1);
    }

    public int boardSize() {
        return size;
    }

    public int boardScale() {
        return scale;
    }

    public void setValueBox(int x, int y, char value){
        entireBoard[x][y] = value;
        repaint();
    }

    public char getValue(int x, int y) {
        return entireBoard[x][y];
    }

    public void paint(Graphics g) {
        super.paint(g);
        int width = getWidth();
        int height = getHeight();
        int pixel = Math.min(width, height) / scale; 

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (entireBoard[row][col] == '=') {
                    g.setColor(Color.black);
                    g.fillRect(row * pixel, col * pixel, pixel, pixel);
                }
                else if (entireBoard[row][col] == '#') {
                    g.setColor(Color.black);
                    g.fillRect(row * pixel, col * pixel, pixel, pixel);
                } 
                else if (entireBoard[row][col] == '8') {
                    g.drawImage(exitImage, row * pixel, col * pixel, pixel, pixel, this);
                }
                else if (entireBoard[row][col] == 'X') {
                    g.drawImage(playerImage, row * pixel, col * pixel, pixel, pixel, this);
                } else if (entireBoard[row][col] == '+') {
                    g.drawImage(fruitImage, row * pixel, col * pixel, pixel, pixel, this);
                } else if (entireBoard[row][col] == '!') {
                    g.drawImage(fakeFruitImage, row * pixel, col * pixel, pixel, pixel, this);
                    
                } else if (entireBoard[row][col] == '@') {
                    g.drawImage(trapImage, row * pixel, col * pixel, pixel, pixel, this);
                }
                
                
                    
                }

                    
                }
            

    }
    public void textVersion() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(entireBoard[row][col]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
    public void addGameObject(char symbol, int amount) {
        Random location = new Random();
        int randX; 
        int randY;
        for (int i = 0; i < amount; i++) {
            Position pos = new Position(0, 0);

            while (pos.getX() == 0 || pos.getY() == 0) {
            randX = location.nextInt(size);
            randY = location.nextInt(size);

            if (randX%2 != 0 && randX != 0 && randX != size-1) {
                pos.setX(randX);
            }
            if (randY%2 != 0 && randY != 0 && randY != size-1) {
                pos.setY(randY);
            }
            char value = getValue(pos.getX(), pos.getY());
            if (getValue(pos.getX(), pos.getY()) != 'v') {
                pos.setX(0); 
                pos.setY(0); 
            }
                
                
            }
            setValueBox(pos.getX(), pos.getY(), symbol);
        }
            
            
        }
    public void addTraps(int trapCount) {
        for ( int x = 1; x < size; x +=2) {
            for (int y = 1; y < size; y += 2) {
                char value = getValue(x, y);
                if (!accessible[x][y] && value != 'v' && value != '#' && value != '=' && value != 'X' && value != '8') {
                    validPositions.add(new Position(x,y));
                    
                }
            }
        }
        Collections.shuffle(validPositions);
        
        for (int i = 0; i < Math.min(trapCount,validPositions.size());i++) {
            Position pos = validPositions.get(i);
            setValueBox(pos.getX(), pos.getY(), '@');
        }
    }
    
 


    public char[] directionUpdate(Position currentCell){
		char north=0,south=0,east=0,west=0;
		
		if (getValue(currentCell.getX(),currentCell.getY()+1) != '#')
			east = getValue(currentCell.getX(), currentCell.getY()+2);
		if (getValue(currentCell.getX(),currentCell.getY()-1) != '#')
			west = getValue(currentCell.getX(), currentCell.getY()-2);
		if (getValue(currentCell.getX()-1,currentCell.getY()) != '#')
			north = getValue(currentCell.getX()-2, currentCell.getY());
		if (getValue(currentCell.getX()+1,currentCell.getY()) != '#')
			south = getValue(currentCell.getX()+2, currentCell.getY());		
		char direction[] = {west,east,south,north};
		return direction;
	}
Position posList[] = new Position[(2*(getX()/2))];
 Position currentCell = new Position(5,5);

/*A class responsible for generating a random maze 
 * 
*/
public void generate(int posX, int posY){
    accessible = new boolean[size][size];
		currentCell = new Position(posX,posY);
		setValueBox(currentCell.getX(),currentCell.getY(), 'v');
        accessible[currentCell.getX()][currentCell.getY()] = true;
		unVisited-=1;
		
		char north=0,south=0,east=0,west=0;
		char direction[] = {west,east,south,north};
		
		direction = directionUpdate(currentCell);

		while(unVisited != 0){
			int free = 0;
			if((direction[0] == 'u') || (direction[1] == 'u') || (direction[2] == 'u') || (direction[3] == 'u')) {
				free = 1;

            }
			
			Random generator = new Random();
			int random = generator.nextInt(4);
			setValueBox(currentCell.getX(),currentCell.getY(), 'v');
            int x = currentCell.getX();
            int y = currentCell.getY();
		
			if((random == 0) && (direction[0] == 'u')){ 
				if (getValue(x,y-1) != '#'){
					setValueBox(x, y-1, 'v');
                    accessible[x][y-1] = true;
					currentCell = new Position(x, y-2);
					positions.push(currentCell);
					
					direction = directionUpdate(currentCell);
					unVisited--;
					
				}
			}
			else if((random == 1) && (direction[1] == 'u')){ 
				if (getValue(x,y+1) != '#'){
					setValueBox(x, y+1, 'v');
                    accessible[x][y+1] = true;
					currentCell = new Position(x, y+2);
					positions.push(currentCell);
					
					direction = directionUpdate(currentCell);
					unVisited--;
				}
			}
			
			else if((random == 2) && (direction[2] == 'u')){ 
				if (getValue(x+1,y) != '#'){
					setValueBox(x+1, y, 'v');
                    accessible[x+1][y] = true;
					currentCell = new Position(x+2, y);
					positions.push(currentCell);
					
					direction = directionUpdate(currentCell);
					unVisited--;
					
				}
			}
			else if((random == 3) && (direction[3] == 'u')) { 
				if (getValue(x-1,y) != '#'){
					setValueBox(x-1, y, 'v');
                    accessible[x-1][y] = true;
					currentCell = new Position(x-2, y);
					positions.push(currentCell);
					
					direction = directionUpdate(currentCell);
					unVisited--;
					
				}
			} else {
				if(free == 0 && positions.size() != 0){
					currentCell = positions.getLast();
					positions.removeLast();
					direction = directionUpdate(currentCell);
					
					
				}
			}
		}
		setValueBox(currentCell.getX(),currentCell.getY(),'8');
		setValueBox(1,1,'X');
	}
/*public void generate(int xCord, int yCord) {
    currentCell = new Position(xCord,yCord);
    setValueBox(currentCell.getX(), currentCell.getY(), 'v');
    unVisited = unVisited - 1;
    
    int full;
    Random randomGenerator; 
    char north = 0;
    char south = 0;
    char west = 0;
    char east = 0;
    char direction[] = {west,east,south,north};

    

    direction = directionUpdate(currentCell);

    while (unVisited != 0) {
        full = 0;
        if ((direction[0] == 'u' || direction[1] == 'u' || direction[2] == 'u' || direction[3] == 'u')) 
            full = 1;
        
        
        randomGenerator = new Random();
        int randomDirection = randomGenerator.nextInt(4);
        
        if (randomDirection == 0 && direction[0] == 'u') {
            if (getValue(currentCell.getX(), currentCell.getY()-1) != '#') {
                setValueBox(currentCell.getX(), currentCell.getY()-1, 'v');
                currentCell = new Position(currentCell.getX(),currentCell.getY()-2);
                positions.push(currentCell);
                direction = directionUpdate(currentCell);
                unVisited--;
                
            } 
         }  else if ((randomDirection == 1) && (direction[1] == 'u')) {
                if (getValue(currentCell.getX(), currentCell.getY()+1) != '#') {
                    setValueBox(currentCell.getX(), currentCell.getY()+1, 'v');
                    currentCell = new Position(currentCell.getX(),currentCell.getY()+2);
                    positions.push(currentCell);
                    direction = directionUpdate(currentCell);
                    unVisited--;
                    }
        } else if ((randomDirection == 2) && (direction[2] == 'u')) {
                if (getValue(currentCell.getX()+1, currentCell.getY()) != '#') {
                    setValueBox(currentCell.getX()+1, currentCell.getY(), 'v');
                    currentCell = new Position(currentCell.getX()+2,currentCell.getY());
                    positions.push(currentCell);
                    
                    direction = directionUpdate(currentCell);
                    unVisited--;
                    
                }
                
         } else if ((randomDirection == 3) && (direction[3] == 'u')) {
                if (getValue(currentCell.getX()+1, currentCell.getY()) != '#') {
                    setValueBox(currentCell.getX()+1, currentCell.getY(), 'v');
                    currentCell = new Position(currentCell.getX()-2,currentCell.getY());
                    positions.push(currentCell);

                    direction = directionUpdate(currentCell);
                    unVisited--;
                    
                }
        } else {
                if (full == 0 && positions.size() != 0) {
                    currentCell = positions.getLast();
                    positions.removeLast();

                    direction = directionUpdate(currentCell);
                    
                }
            }
            
            
        }
        setValueBox(currentCell.getX(),currentCell.getY(), '8');
        setValueBox(1, 1, 'X');
        
        
    } */





    
        
    }


    

