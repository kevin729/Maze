package game_engine.entities.living.enemies;

import game_engine.Runner;
import game_engine.entities.living.Living;
import game_engine.view.Camera;

import java.awt.*;

public class Bird extends Living {

    public Bird(int _x, int _y) {
        super(_x, _y, 0, 0, "Bird");

    }

    @Override
    public void update() {
        attack();
        attack_width = 10;
        attack_height = 10;
        detect_attack();
    }

    @Override
    public void render() {
        Camera camera = Runner.get_context().get_camera();
        Runner.get_context().render_entity(attack_x - camera.getX(), attack_y - camera.getY(), attack_width, attack_height, Color.YELLOW.getRGB());
    }
}
