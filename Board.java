import java.awt.*;
import javax.swing.*;
import javax.swing.text.Position;
import javax.swing.text.html.parser.Entity;

import java.math.*;


import java.util.*;

public class Board extends JPanel {
    private char[][] entireBoard;
    private int size;
    private int unVisited;
    private int scale;
    private Position currentCell;
    private Position positionList[];
    private Image innerWall;
    private Image outerWall;
    private Image character;
    private Image floor;
    private Image fruit;
    private Image fakeFruit;
    private Image exit;
    private Image trap;
    
    ArrayDeque<Position> positions = new ArrayDeque<>();

    public Board(int x, int y, int fruitC, int fakeFruitC, int trapC) {
        initializeBoard(x, y);
        codeMaze();

        Fruit fruits = new Fruit();
        FakeFruit fakeFruits = new FakeFruit();
        Trap traps = new Trap();

        fruits.add(this, fruitC);
        fakeFruits.add(this, fakeFruitC);
        fruits.add(this, trapC);


        

        


    }
    public void codeMaze() {
        for ( int row = 0; row < size; row++) {
            for(int col = 0; col < scale; col++) {
                entireBoard[row][col] = 'u';
            }
        }
        for ( int row = 0; row < size; row += 2) {
            for(int col = 0; col < scale; col++) {
                entireBoard[row][col] = '=';
                entireBoard[col][row] = '=';
            }
        }
        for (int row = 0; row < size; row++) {
            entireBoard[row][0] = '#';
            entireBoard[row][size -1] = '#';
            entireBoard[0][row] = '#';
            entireBoard[size - 1][row] = '#';
            
            generate(1, 1);
        }
    }



    public void initializeBoard(int width, int length) {
        unVisited = width*length;
        width = width*2 + 1;
        length = length*2 +1;
        scale = length;
        entireBoard = new char[width][length];
        size = width;
        currentCell = new Position(5,5);
        positionList = new Position[size];

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
        int currentWidth = getWidth();
        int currentHeight = getHeight();
        int pixel = Math.min(currentWidth/size, currentHeight/size);

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < scale; col++) {
                if (entireBoard[row][col] == '=') {
                    g.setColor(Color.BLACK);
                    
                    
                }
                else if (entireBoard[row][col] == '=') {
                    g.setColor(Color.BLACK);
                    
                } 
                else if (entireBoard[row][col] == '8') {
                    g.setColor(Color.RED);
                }
                else {
                    g.setColor(Color.BLUE);
                    
                }
                g.fillRect(row*pixel, col*pixel, pixel, pixel);
                if (entireBoard[row][col] =='+') {
                    g.setColor(Color.YELLOW);
             

                } else if (entireBoard[row][col] == '!') {
                    g.setColor(Color.RED);
                    
                } else {
                    g.setColor(Color.PINK);
                    
                }
                g.fillOval(pixel*row, col*col, pixel, pixel);
                
                
                    
                }

                    
                }
            

    }
    public void textVersion() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < scale; col++) {
                System.out.print(entireBoard[row][col]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
    public class Position {
    private int xCord;
    private int yCord; 
    public Position(int x, int y) {
        this.xCord = x;
        this.yCord = y;
    }
    public Position() {
        this.xCord = 0;
        this.yCord = 0;
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

public char[] directionUpdate(Position currentCell) {
    char north = 0;
    char south = 0;
    char west = 0;
    char east = 0;
    if (getValue(currentCell.getX(), currentCell.getY() +1) != '#');
    north = getValue(currentCell.getX(),currentCell.getY() +2);
    if (getValue(currentCell.getX() +1, currentCell.getY()) != '#');
    north = getValue(currentCell.getX() +2 ,currentCell.getY() );
    if (getValue(currentCell.getX()-1 , currentCell.getY()) != '#');
    north = getValue(currentCell.getX() -1,currentCell.getY());
    if (getValue(currentCell.getX(), currentCell.getY() -2) != '#');
    north = getValue(currentCell.getX(),currentCell.getY() -2);
    char[] direction = {west,east,north,south};
    return direction;
}

/*A class responsible for generating a random maze 
 * 
*/
public void generate(int xCord, int yCord) {
    currentCell = new Position(xCord,yCord);
    setValueBox(xCord, yCord, 'v');
    unVisited = unVisited - 1;
    
    int full;
    Random randomGenerator; 
    char north = 0;
    char south = 0;
    char west = 0;
    char east = 0;
    char[] direction = new char[4];
    direction[0] = north;
    direction[1] = south;
    direction[2] = west;
    direction[3] = east;

    direction = directionUpdate(currentCell);

    while (unVisited != 0) {
        full = 0;
        if (direction[0] == 'u' || direction[1] == 'u' || direction[2] == 'u' || direction[3] == 'u') {
            full = 1;
        }
        randomGenerator = new Random();
        int randomDirection = randomGenerator.nextInt(4);

        if (randomDirection == 0 && direction[0] == 'u') {
            if (getValue(currentCell.getX()-1, currentCell.getY()) != '#') {
                setValueBox(currentCell.getX()-1, currentCell.getY(), 'v');
                currentCell = new Position(currentCell.getX()-2,currentCell.getY());
                positions.push(currentCell);
                direction = directionUpdate(currentCell);
                unVisited--;
                
            } else if (randomDirection == 1 && direction[1] == 'u') {
                if (getValue(currentCell.getX()+1, currentCell.getY()) != '#') {
                    setValueBox(currentCell.getX()+1, currentCell.getY(), 'v');
                    currentCell = new Position(currentCell.getX()+2,currentCell.getY());
                    positions.push(currentCell);
                    direction = directionUpdate(currentCell);
                    unVisited--;
                    }
            } else if (randomDirection == 2 && direction[2] == 'u') {
                if (getValue(currentCell.getX(), currentCell.getY()-1) != '#') {
                    setValueBox(currentCell.getX(), currentCell.getY()-1, 'v');
                    currentCell = new Position(currentCell.getX(),currentCell.getY()-2);
                    positions.push(currentCell);
                    
                    direction = directionUpdate(currentCell);
                    unVisited--;
                    
                }
                
            } else if (randomDirection == 3 && direction[3] == '#') {
                if (getValue(currentCell.getX(), currentCell.getY()+1) != '#') {
                    setValueBox(currentCell.getX(), currentCell.getY()+1, 'v');
                    currentCell = new Position(currentCell.getX(),currentCell.getY()+2);
                    positions.push(currentCell);

                    direction = directionUpdate(currentCell);
                    unVisited--;
                    
                }
            } else {
                if (full == 0 && positions.size() != 0) {
                    currentCell = positions.pop();

                    direction = directionUpdate(currentCell);
                    
                }
            }
            
            
        }
        setValueBox(size-1, scale -1, '8');
        setValueBox(1, 1, 'X');
        
        
    }





    
        
    }
}

    

