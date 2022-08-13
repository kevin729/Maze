package game_engine.view;

import game_engine.Runner;
import game_engine.entities.Entity;
import game_engine.level.Level;

public class Camera {
    private int x;
    private int y;

    public void center(Entity e) {
        int width = Runner.get_context().get_game_width();
        int height = Runner.get_context().get_game_height();
        Level level = Runner.get_context().getLevel();

        x = e.x - Runner.get_context().get_game_width()/2 + e.width/2;
        y = e.y - Runner.get_context().get_game_height()/2 + e.height/2;

        x = Math.max(0, x);
        y = Math.max(0, y);

        if (x + width > level.getWidth()) {
            x = level.getWidth() - width;
        }

        if (y + height > level.getHeight()) {
            y = level.getHeight() - height;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
