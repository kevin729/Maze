package game_engine.model.object;

import game_engine.controller.Level;
import game_engine.controller.Runner;
import game_engine.model.Entity;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        Runner.get_context().render_entity(x, y, width, height, Color.PINK.getRGB());
    }
}
