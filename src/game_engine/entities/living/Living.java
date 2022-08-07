package game_engine.entities.living;

import java.util.ArrayList;
import java.util.List;

import game_engine.util.Timer;
import game_engine.entities.Entity;


public abstract class Living extends Entity {
	
	private Timer hit_Timer = new Timer(1);
	
	public String action = "STILL";
	
	protected int health = 20;
	protected int speed = 6;
	
	public int attack_x;
	public int attack_y;
	public int attack_width = 0;
	public int attack_height = 0;

	public int block_x;
	public int block_y;
	public int block_width = 0;
	public int block_height = 0;

	public List<Entity> collided_entities = new ArrayList<>();

	public Living(int _x, int _y, int _width, int _height, String _name) {
		super(_x, _y, _width, _height, _name);
		alive = true;
	}
	
	public ArrayList<Entity> collision_detect(boolean movement) {
		return collision_detect(x, y, width, height, movement, false);
	}

	private void limit_x_speed(int max_speed_x) {
		if (x_speed > max_speed_x) {
			x_speed = max_speed_x;
		} 
		
		if (x_speed < -max_speed_x) {
			x_speed = -max_speed_x;
		}
	}

	protected void apply_gravity(double g) {
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
		set_Position(true);
		apply_friction(1);
		
		attack_width = 0;
		attack_height = 0;
		
		block_width = 0;
		block_height = 0;
		
		action = "STILL";


	}

	protected void set_Position(boolean movement) {
		collided_entities = new ArrayList<>();
		collided_entities = collision_detect(movement);
		x += x_speed > 0 ? Math.ceil(x_speed) : x_speed;
		y += y_speed;
	}

	private void detect_attack() {
		ArrayList<Entity> entities = collision_detect(attack_x, attack_y, attack_width, attack_height, false, true);
		for (Entity e : entities) {
			if (e instanceof Living) {
				((Living) e).take_damage(4);
			}
		}
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
			//jump();
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

	@Override
	public void update() {
		detect_attack();
		move();
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

	public void modify_health(int health) {
		this.health += health;
	}
}