package game_engine.model;

import java.awt.Color;

import game_engine.controller.Runner;
import game_engine.controller.input.Keyboard;

public class Player extends Living {
	
	public Player(int x, int y, int width, int height) {
		super(x, y, width, height, "Player");
		
	}
	
	@Override
	public void update() {
		move();
		
		if (Runner.get_context().get_Testing()) {
			update_Agent();
		} else {
			input();
		}
	}
	
	private void update_Agent() {
		Runner.get_context().get_game_engine().set_fps(1000);
	}
	
	private void input() {
		Runner.get_context().get_game_engine().set_fps(15);
		if (Keyboard.UP) {
			jump();
			
			if (Keyboard.RIGHT) {
				right();
			} else if (Keyboard.LEFT) {
				left();
			}
		} else if (Keyboard.BLOCK) {
			block();
		} else if (Keyboard.ATTACK) {
			attack();
		} else if (Keyboard.LONG) {
			long_attack();
		} else if (Keyboard.RIGHT) {
			right();
		} else if (Keyboard.LEFT) {
			left();
		}
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
