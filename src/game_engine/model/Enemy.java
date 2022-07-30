package game_engine.model;

import java.awt.Color;
import java.text.DecimalFormat;

import game_engine.controller.Runner;

public class Enemy extends Living {
	
	private DecimalFormat df = new DecimalFormat("0.00");
	
	public Enemy(int x, int y,  int width, int height) {
		super(x, y, width, height, "Enemy");
	}
	
	@Override
	public void update() {
		super.update();

	}

	@Override
	public void render() {
		Runner.get_context().render_entity(x+20, y-30, width, height, String.valueOf(health));
		Runner.get_context().render_entity(x, y-10, width, height, action);
		Runner.get_context().render_entity(block_x, block_y, block_width, block_height, Color.GRAY.getRGB());
		Runner.get_context().render_entity(attack_x, attack_y, attack_width, height, Color.GREEN.getRGB());
		Runner.get_context().render_entity(x, y, width, height, Color.RED.getRGB());
	}
}

