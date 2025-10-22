import java.util.Random;

public class GameObject {

    public char symbol; 
    public Random location;
    public Position pos;

    public GameObject(char symbol) {
        this.symbol = symbol; 
        location = new Random();
        pos = new Position(0,0);
        
    }

    public void add(Board board, int amount) {
        int randX; 
        int randY;
        for (int i =0; i < amount; i++) {
            while (pos.getX() == 0 || pos.getY() == 0) {
            randX = location.nextInt(board.boardSize());
            randY = location.nextInt(board.boardSize());
            if (randX%2 != 0 && (randX != 0 || randX != board.boardSize())) {
                pos.setX(randX);
            }
            if (randY%2 != 0 && (randY != 0 || randY != board.boardSize())) {
                pos.setY(randY);
            }
            if (board.getValue(pos.getX(), pos.getY()) == 'X' || board.getValue(pos.getX(), pos.getY()) == '8') {
                pos.setX(0);
                pos.setY(0);
            }
        }
            
            board.setValueBox(pos.getX(), pos.getY(),symbol);
        }
    }
    
}