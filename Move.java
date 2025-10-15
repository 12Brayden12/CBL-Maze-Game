public class Move {
   
    private Position chpos;
    private int dx;
    private int dy;
    private int fruitsCollected;
    private int traps;
    private int fakeFruits;
    private GameActions gameActions;
   

    

    public Move(int dx,int dy) {
        this.chpos = new Position();
        chpos.setX(1);
        chpos.setY(1);
        this.dx = dx;
        this.dy = dy;
        this.gameActions = new GameActions();
        
        
        

    }
    public void moveDirection(Board board) {
        
        if (board.getValue(chpos.getX() + dx, chpos.getY() + dy) != '#' && board.getValue(chpos.getX() +dx , chpos.getY() +dy) != '=') {
            board.setValueBox(chpos.getX(), chpos.getY(), 'o');
            if (board.getValue(chpos.getX()+dx, chpos.getY() +dy) == '8') {
                gameActions.Win(fruitsCollected);
                
            } else if (board.getValue(chpos.getX()+dx, chpos.getY() +dy)  == '+') {
                fruitsCollected++;
                gameActions.fruitAction();
                
            } else if (board.getValue(chpos.getX()+dx, chpos.getY() +dy) == '!') {
                gameActions.fakeFruitAction();
                fakeFruits++;
                
            } else if ( board.getValue(chpos.getX()+dx, chpos.getY() +dy) == '@') {
                gameActions.GameOver();
                
            } else {
                board.setValueBox(chpos.getX(), chpos.getY(), 'X');
            }
            
        }

    }
}
