public class Fruit extends Entity {
    private int value;

    public Fruit(int x, int y, int value) {
        super(x, y);
        this.value = value;
    }

    @Override
    public void onPlayerCollision(Player player, GamePanel panel) {
        if (!active) return;
        active = false;
        player.addScore(value);
        panel.playSound("");
    }
}
