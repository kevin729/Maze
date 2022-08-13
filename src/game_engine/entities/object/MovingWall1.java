package game_engine.entities.object;

import game_engine.Runner;
import game_engine.entities.living.Living;
import game_engine.view.Camera;

import java.awt.*;

public class MovingWall1 extends Living {
    int angle = 0;

    public MovingWall1(int _x, int _y, int width, int height) {
        super(_x, _y, width, height, "Wall");
        alive = false;
    }

    @Override
    public void update() {
        y_speed = Math.cos(Math.toRadians(angle)) > 0 ? 10 : -10;
        set_Position(false);
        angle += 5;
    }

    @Override
    public void render() {
        Camera camera = Runner.get_context().get_camera();
        Runner.get_context().render_entity(x - camera.getX(), y - camera.getY(), width, height, Color.MAGENTA.getRGB());
    }
}
