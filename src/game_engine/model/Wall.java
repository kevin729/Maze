package game_engine.model;

import java.awt.Color;

import game_engine.controller.Runner;

public class Wall extends Entity {

	public Wall(int _x, int _y, int width, int height) {
		super(_x, _y, width, height, "Wall");
	}
	
	@Override
	public void update() {
		y -= 1;
	}

	@Override
	public void render() {
		Runner.get_context().render_entity(x, y, width, height, Color.MAGENTA.getRGB());
	}
}
