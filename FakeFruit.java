public class FakeFruit extends GameObject{
    
    public FakeFruit() {
        super('!');
        if (board.getValue(playerX, playerY) == '!') {
            ControlReversal.activate();
        }

    }
}
