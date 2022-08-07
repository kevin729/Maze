package game_engine.entities.living;

import java.awt.Color;

import game_engine.Runner;
import game_engine.input.Keyboard;
import game_engine.entities.object.Door;

public class Player extends Living {
	
	public Player(int x, int y, int width, int height) {
		super(x, y, width, height, "Player");

	}
	
	@Override
	public void update() {
		super.update();
		input();

		collided_entities.stream()
				         .forEach(entity -> {
							 if (entity.get_name().equals("Door")) {
								 ((Door)entity).enter();
							 }
						 });
	}

	
	private void input() {
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
//		Runner.get_context().render_entity(x, y-70, width, height, agent.predict_Action("ATTACK"));
//		Runner.get_context().render_entity(x, y-50, width, height, agent.predict_Action("LONG"));
		Runner.get_context().render_entity(x+20, y-30, width, height, String.valueOf(health));
		Runner.get_context().render_entity(x, y-10, width, height, action);
		Runner.get_context().render_entity(block_x, block_y, block_width, block_height, Color.GRAY.getRGB());
		Runner.get_context().render_entity(attack_x, attack_y, attack_width, height, Color.GREEN.getRGB());
		Runner.get_context().render_entity(x, y, width, height, Color.CYAN.getRGB());
	}
}
