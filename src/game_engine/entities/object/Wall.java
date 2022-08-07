package game_engine.entities.object;

import java.awt.Color;

import game_engine.Runner;
import game_engine.entities.Entity;

public class Wall extends Entity {

	public Wall(int _x, int _y, int width, int height) {
		super(_x, _y, width, height, "Wall");
	}

	@Override
	public void update() {

	}

	@Override
	public void render() {
		Runner.get_context().render_entity(x, y, width, height, Color.MAGENTA.getRGB());
	}
}
