public class Position {

    private int xCord;
    private int yCord;

    public Position(int x, int y) {
        this.xCord = x;
        this.yCord = y;
        
    }
    
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
