public class FakeFruit extends Entity {
    private int reverseSeconds;

    public FakeFruit(int x, int y, int reverseSeconds) {
        super(x, y);
        this.reverseSeconds = reverseSeconds;
    }

    @Override
    public void onPlayerCollision(Player player, GamePanel panel) {
        if (!active) return;
        active = false;
        player.reverseControls(reverseSeconds);
        panel.playSound("");
    }
}
