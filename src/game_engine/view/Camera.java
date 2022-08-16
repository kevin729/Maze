package game_engine.view;

import game_engine.Runner;
import game_engine.entities.Entity;
import game_engine.level.Level;

public class Camera {
    private int x;
    private int y;

    public void center(Entity e) {
        Level level = Runner.get_context().getLevel();

        x = e.x - level.getViewWidth()/2 + e.width/2;
        y = e.y - level.getViewHeight()/2 + e.height/2;

        x = Math.max(0, x);
        y = Math.max(0, y);

        if (x + level.getViewWidth() > level.getWidth()) {
            x = level.getWidth() - level.getViewWidth();
        }

        if (y + level.getViewHeight() > level.getHeight()) {
            y = level.getHeight() - level.getViewHeight();
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
