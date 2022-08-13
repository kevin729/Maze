package game_engine.entities.living;

import java.awt.Color;
import java.text.DecimalFormat;

import game_engine.Runner;
import game_engine.view.Camera;

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
		Camera camera = Runner.get_context().get_camera();

		Runner.get_context().render_entity(x+12 - camera.getX(), y-10 - camera.getY(), width, height, String.valueOf(health));
		Runner.get_context().render_entity(block_x - camera.getX(), block_y - camera.getY(), block_width, block_height, Color.GRAY.getRGB());
		Runner.get_context().render_entity(attack_x - camera.getX(), attack_y - camera.getY(), attack_width, height, Color.GREEN.getRGB());
		Runner.get_context().render_entity(x - camera.getX(), y - camera.getY(), width, height, Color.RED.getRGB());
	}
}

