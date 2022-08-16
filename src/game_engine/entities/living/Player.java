package game_engine.entities.living;

import java.awt.Color;

import game_engine.Runner;
import game_engine.entities.living.Living;
import game_engine.input.Keyboard;
import game_engine.entities.object.Door;
import game_engine.util.Timer;
import game_engine.view.Camera;

public class Player extends Living {
	
	public Player(int x, int y) {
		super(x, y, 20, 50, "Player");

	}
	
	@Override
	public void update() {
		super.update();

		input();

		Runner.get_context().get_camera().center(this);

		Timer timer = Runner.get_context().get_timer();
		collided_entities.stream().forEach(entity -> {
			if (entity.get_name().equals("Door") && !timer.running) {
				((Door)entity).enter();
				timer.tick();
			}
		});
	}

	
	private void input() {
		if (hit_Timer.running) {
			return;
		}

		if (Keyboard.UP) {
			jump();
			
			if (Keyboard.RIGHT) {
				right();
			} else if (Keyboard.LEFT) {
				left();
			}
		}
		if (Keyboard.BLOCK)
			block();
		if (Keyboard.ATTACK)
			attack();
		if (Keyboard.LONG)
			long_attack();
		if (Keyboard.RIGHT)
			right();
		if (Keyboard.LEFT)
			left();
	}
	
	@Override
	public void render() {
		Camera camera = Runner.get_context().get_camera();

		Runner.get_context().render_entity(x - camera.getX(), y-10 - camera.getY(), 50, 50, String.valueOf(health));
		Runner.get_context().render_entity(block_x - camera.getX(), block_y - camera.getY(), block_width, block_height, Color.GRAY.getRGB());
		Runner.get_context().render_entity(attack_x - camera.getX(), attack_y - camera.getY(), attack_width, height, Color.GREEN.getRGB());
		Runner.get_context().render_entity(x - camera.getX(), y - camera.getY(), width, height, Color.CYAN.getRGB());
	}
}
