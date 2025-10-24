/**public class Trap extends Entity {

    public Trap(int x, int y) {
        super(x, y);
    }

    @Override
    public void onPlayerCollision(Player player, GamePanel panel) {
        if (!active) return;
        active = false;
        player.setDead();
        panel.playSound("lose.wav");
    }
}
