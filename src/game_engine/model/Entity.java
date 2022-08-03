package game_engine.model;

import java.util.HashMap;

public abstract class Entity {
		
	
	
	private String name;
	
	protected int x, y, width, height;
	protected double x_speed, y_speed;
	protected boolean grounded = false;
	protected boolean bottom;
	protected boolean alive = true;

	public Entity(int _x, int _y, int _width, int _height, String _name) {
		name = _name;
		x = _x;
		y = _y;
		width = _width;
		height = _height;
	}
		
	public String get_name() {
		return name;
	}
	
	public double get_speed_x() {
		return x_speed;
	}
	
	public double get_speed_y() {
		return y_speed;
	}
		
		
	public abstract void update();
	public abstract void render();
}
