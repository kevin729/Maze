package game_engine.entities.object;

import game_engine.level.Level;
import game_engine.Runner;
import game_engine.entities.Entity;
import game_engine.view.Camera;

import java.awt.*;

public class Door extends Entity {

    private Level level;

    public Door(int _x, int _y, int _width, int _height, Level level) {
        super(_x, _y, _width, _height, "Door");
        this.level = level;
    }

    public void enter() {
        Runner.get_context().setLevel(level);
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {
        Camera camera = Runner.get_context().get_camera();
        Runner.get_context().render_entity(x - camera.getX(), y - camera.getY(), width, height, Color.PINK.getRGB());
    }
}
