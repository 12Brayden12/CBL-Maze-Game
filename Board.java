import java.awt.*;
import javax.swing.*;
import javax.swing.text.Position;
import javax.swing.text.html.parser.Entity;

import java.math.*;


import java.util.*;

public class Board extends JPanel {
    private char[][] entireBoard;
    private int size;
    private boolean[][] visited;
    private int unVisited;
    private int scale;
    private Image innerWall;
    private Image outerWall
    private Image character;
    private Image floor;
    private Image fruit;
    private Image fakeFruit;
    private Image exit;
    private Image trap;
    
    ArrayDeque<Position> positions = new ArrayDeque<Position>();

    public Board(int x, int y, int obj) {
        initializeBoard(x, y);

    }
    public void codeMaze() {
        for ( int row = 0; row < size; row++) {
            for(int col = 0; col < scale)
        }
     
    }

    public void initializeBoard(int width, int length) {
        unVisited = width*width;
        width = width*2 + 1;
        length = length*2 +1;
        scale = length;
        entireBoard = new char[width][length];
        size = width;

    }
    public void setValueBox(int x, int y, char value){
        entireBoard[x][y] = value;
        repaint();
    }
    public char getValue(int x, int y) {
        return entireBoard[x][y];
    }
    public void addObject(int amount) {
        Random location = new Random();
        Position pos = new Position();
        for ( int i = 0; i < amount; i++); {
            while (pos.getX() == 0 || pos.getY() == 0){
                int randX = location.nextInt(size);
                int randY = location.nextInt(size);

                if ((randX%2 != 0) && (randX != 0 ||randX != size)) {
                    pos.setX(randX);                    
                }
                if ((randY%2 != 0) && (randY != 0 ||randY != size)) {
                    pos.setY(randY);                  
                }
                if (getValue(pos.getX(), pos.getY()) == 'X' || getValue(pos.getX(), pos.getY()) == '8') {
                    pos.setX(0);
                    pos.setY(0);
                    
                }
                

            }
            setValueBox(pos.getX(), pos.getY(), '+');
        }
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
                    g.fillOval(pixel *row, col*pixel, pixel, pixel); 

                }
                    
                }

                    
                }
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

    
}
