package game_engine.model;

import java.util.ArrayList;

import game_engine.controller.Runner;
import game_engine.controller.Timer;


public abstract class Living extends Entity {
	
	private Timer hit_Timer = new Timer(1000);
	
	public String action = "STILL";
	
	protected int health = 20;
	protected int speed = 5;
	
	public int attack_x;
	public int attack_y;
	public int attack_width = 0;
	public int attack_height = 0;

	public int block_x;
	public int block_y;
	public int block_width = 0;
	public int block_height = 0;
	
	public int long_x;
	public int long_y;
	public int long_width = 0;
	public int long_height = 0;
	
	public Living(int _x, int _y, int _width, int _height, String _name) {
		super(_x, _y, _width, _height, _name);
	}
	
	public ArrayList<String> collision_detect(boolean movement) {
		return collision_detect(x, y, width, height, movement);
	}
	
	public ArrayList<String> collision_detect(int x, int y, int width, int height, boolean movement_detection) {			
		ArrayList<String> entities = new ArrayList<String>();
		
		if (width == 0 || height == 0) {
			return entities;
		}
		
		for (Entity entity : Runner.get_context().get_entities()) {
			if (entity == this)
				continue;
			
			int _x = x;
			int _y = y;
			
			//predicted location
			if (movement_detection) {
				_x += x_speed;
				_y += y_speed;
			}
			
			//up
			if ((_y > entity.y  && _y < entity.y + entity.height) && 
				(x < entity.x + entity.width && x + width > entity.x)) {
				entities.add(entity.get_name());
				if (movement_detection) {
					move_y_axis(-y_speed);
				}
			}
			
			//right
			if ((_x + width >= entity.x && _x + width < entity.x + entity.width) && 
				(y < entity.y + entity.height && y + height > entity.y)) {
				entities.add(entity.get_name());
				if (movement_detection) {
					this.x = entity.x - width;
					move_x_axis(-x_speed);
				} else {
					entity.x_speed = speed;
				}
			}
			
			//left
			if ((_x >= entity.x && _x < entity.x + entity.width) && 
				(y < entity.y + entity.height && y + height > entity.y)) {
				entities.add(entity.get_name());
				if (movement_detection) {
					this.x = entity.x + entity.width;
					move_x_axis(-x_speed);
				} else {
					entity.x_speed = -speed;
				}
			}
			
			//bottom
			if ((_y + height > entity.y && _y + height < entity.y + entity.height) &&
				(x <= entity.x + entity.width && x + width >= entity.x)) {
				//entities.add(entity.get_name());
				if (movement_detection) {
					grounded = true;
					move_y_axis(-y_speed);
				}
			}
		}
		
		return entities;
	}
	
	private void limit_x_speed(int max_speed_x) {
		if (x_speed > max_speed_x) {
			x_speed = max_speed_x;
		} 
		
		if (x_speed < -max_speed_x) {
			x_speed = -max_speed_x;
		}
	}

	private void apply_gravity(double g) {
		move_y_axis(g);
	}

	private void apply_friction(double f) {	
		if (x_speed > f) {
			x_speed -= f;
		} else if (x_speed < -f) {
			x_speed += f;
		} else {
			x_speed = 0;
		}
	}
	
	protected void move() {
		limit_x_speed(speed);
		apply_gravity(0.5);
		
		collision_detect(true);
		
		x += x_speed > 0 ? Math.ceil(x_speed) : x_speed;
		y += y_speed;
		
		apply_friction(2);
		
		attack_width = 0;
		attack_height = 0;
		
		block_width = 0;
		block_height = 0;
		
		action = "STILL";
	}

	public void attack() {
		action = "ATTACK";
		
		attack_x = x - 20;
		attack_y = y;
		
		attack_width = width + 40;
		attack_height = height;
	}
	
	public void long_attack() {
		action = "LONG";
		
		attack_x = x - 50;
		attack_y = y;
		
		attack_width = width + 100;
		attack_height = height;
	}
	
	public void block() {
		action = "BLOCK";
		
		block_x = x - 20;
		block_y = y;
		
		block_width = width + 40;
		block_height = height;
	}
	
	public void jump() {
		action = "JUMP";
		if (grounded) {
			grounded = false;
			move_y_axis(-10);
		}
	}
	
	public boolean take_damage(int damage) {
		if (damage <= 0)
			return hit_Timer.running;
		
		Boolean hit = hit_Timer.running;
		
		if (!hit_Timer.running) {
			health -= damage;
			hit_Timer.tick();
		}
		
		return hit;
	}
	
	public void left() {
		action = action == "JUMP" ? action : "LEFT";
		move_x_axis(-speed);
	}
	
	public void right() {
		action = action == "JUMP" ? action : "RIGHT";
		move_x_axis(speed);
	}
	
	public void move_x_axis(double new_x_speed) {
		x_speed += new_x_speed;
	}
	
	public void move_y_axis(double new_y_speed) {
		y_speed += new_y_speed;
	}
	
	public int get_X() {
		return x;
	}
	
	public int get_Y() {
		return y;
	}
	
	public void set_X(int _x) {
		 x = _x;
	}
	
	public void set_Y(int _y) {
		y = _y;
	}
	
	public int get_Health() {
		return health;
	}
	
	public void set_Health(int _health) {
		health = _health;
	}
}