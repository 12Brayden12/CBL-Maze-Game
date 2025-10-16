/*public class Move {
   
    private Position chpos;
    private int fruitsCollected;
    private int traps;
    private int fakeFruits;
    private GameActions gameActions;
   

    

    public Move(Board board, int dx,int dy) {
        this.chpos = new Position();
        chpos.setX(1);
        chpos.setY(1);
        this.gameActions = new GameActions();
   
        
        if (board.getValue(chpos.getX() + dx, chpos.getY() + dy) != '#' && board.getValue(chpos.getX() +dx , chpos.getY() +dy) != '=') {
            board.setValueBox(chpos.getX(), chpos.getY(), 'o');
            if (board.getValue(chpos.getX()+dx, chpos.getY() +dy) == '8') {
                gameActions.Win(fruitsCollected);
                
            } else if (board.getValue(chpos.getX(), chpos.getY())  == '+') {
                fruitsCollected++;
                gameActions.fruitAction();
                
            } else if (board.getValue(chpos.getX(), chpos.getY()) == '!') {
                gameActions.fakeFruitAction();
                fakeFruits++;
                
            } else if (board.getValue(chpos.getX(), chpos.getY()) == '@') {
                gameActions.GameOver();
                
            } else {
                board.setValueBox(chpos.getX(), chpos.getY(), 'X');
            }
            
        }

    }
}
