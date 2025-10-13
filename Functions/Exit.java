public class Exit extends Entity {
    public Exit(int x, int y) {
        super(x, y);
    }

    @Override
    public void onPlayerCollision(Player player, GamePanel panel) {
        if (!active) return;
        active = false;
        player.setWin();
        panel.stopTimer();
        panel.playSound("");
    }
}
