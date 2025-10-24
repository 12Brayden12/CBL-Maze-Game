import java.awt.*;

public abstract class Entity {
    protected int x, y;
    protected boolean active = true;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
        this.active = true;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public boolean isActive() { return active; }

    public abstract void onPlayerCollision(Player player, GamePanel panel);

    public void draw(Graphics g, int tileSize, Color color) {
        if (!active) return;
        g.setColor(color);
        g.fillOval(x * tileSize + 6, y * tileSize + 6, tileSize - 12, tileSize - 12);
    }
}
