package game_engine.entities.object;

import java.awt.Color;

import game_engine.Runner;
import game_engine.entities.Entity;
import game_engine.view.Camera;

public class Wall extends Entity {

	public Wall(int _x, int _y, int width, int height) {
		super(_x, _y, width, height, "Wall");
	}

	@Override
	public void update() {

	}

	@Override
	public void render() {
		Camera camera = Runner.get_context().get_camera();
		Runner.get_context().render_entity(x - camera.getX(), y - camera.getY(), width, height, Color.MAGENTA.getRGB());
	}
}
