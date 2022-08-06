package game_engine.model.object;

import game_engine.controller.Runner;
import game_engine.model.living.Living;

import java.awt.*;

public class MovingWall1 extends Living {
    int angle = 0;

    public MovingWall1(int _x, int _y, int width, int height) {
        super(_x, _y, width, height, "Wall");
        alive = false;
    }

    @Override
    public void update() {
        y_speed = Math.cos(Math.toRadians(angle)) > 0 ? 1 : -1;
        set_Position(false);
        angle++;
    }

    @Override
    public void render() {
        Runner.get_context().render_entity(x, y, width, height, Color.MAGENTA.getRGB());
    }
}
