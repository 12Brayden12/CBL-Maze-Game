public class Move {
   
    private Position chpos;
    private int dx;
    private int dy;
    private int fruitsCollected;
    private int traps;
    private int fakeFruits;

    

    public Move(int dx,int dy) {
        chpos.setX(1);
        chpos.setY(1);
        this.dx = dx;
        this.dy = dy;
        
        

    }
    public void moveDirection(Board board) {
        if (board.getValue(chpos.getX() + dx, chpos.getY() + dy) != '#' && board.getValue(chpos.getX() +dx , chpos.getY() +dy) != '=') {
            board.setValueBox(chpos.getX(), chpos.getY(), 'o');
            if (board.getValue(chpos.getX()+dx, chpos.getY() +dy) == '8') {
                Win();
                
            } else if (board.getValue(chpos.getX()+dx, chpos.getY() +dy)  == '+') {
                fruitsCollected++;
                
            } else if (board.getValue(chpos.getX()+dx, chpos.getY() +dy) == '!') {
                fakeFruitAction();
                fakeFruits++;
                
            } else if ( board.getValue(chpos.getX()+dx, chpos.getY() +dy) == '@') {
                trapAction();
                traps++;
            } else {
                board.setValueBox(chpos.getX(), chpos.getY(), 'X');
            }
            
        }

    }
}
