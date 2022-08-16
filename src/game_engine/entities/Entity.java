package game_engine.entities;

import game_engine.Runner;

import java.util.ArrayList;

public abstract class Entity {
		
	
	
	private String name;
	
	public int x, y, width, height;
	public double x_speed, y_speed;
	public boolean grounded = false;
	public boolean bottom;
	public boolean alive = false;

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

	public ArrayList<Entity> collision_detect(int x, int y, int width, int height, boolean living, boolean combat) {
		ArrayList<Entity> entities = new ArrayList<>();

		if (width == 0 || height == 0) {
			return entities;
		}

		for (Entity entity : Runner.get_context().get_entities()) {
			if (entity == this)
				continue;

			int _x = x;
			int _y = y;

			int eX = entity.x;
			int eY = entity.y;

			//predicted location
			if (living) {
				_x += x_speed;
				_y += y_speed;
				eX += entity.x_speed;
				eY += entity.y_speed;
			}

			//up
			if ((_y >= eY  && _y <= eY + entity.height) &&
					(x < entity.x + entity.width && x + width > entity.x)) {
				entities.add(entity);
				if (!living && entity.alive && !combat) {
					entity.y = (int) (y - entity.height - Math.abs(y_speed));
					entity.bottom = true;
				} else {
					y_speed = 0;
				}
			}

			//bottom
			if ((_y + height >= eY && _y + height <= eY + entity.height) &&
					(x <= eX + entity.width && x + width >= eX)) {
				if (living) {
					grounded = true;
					y_speed = 0;
					bottom = true;
				}
			}

			//right
			if ((_x + width >= entity.x && _x + width < entity.x + entity.width) &&
					(y < entity.y + entity.height && y + height > entity.y)) {
				entities.add(entity);
				if (living && !bottom && !combat) {
					this.x = entity.x - width;
					x_speed = 0;
				} else if (!combat) {
					x_speed = 0;
					y_speed = 0;
					grounded = true;
				} else if (combat && entity.alive) {
					entity.x_speed = 4;
				}
			}

			//left
			if ((_x >= entity.x && _x < entity.x + entity.width) &&
					(y < entity.y + entity.height && y + height > entity.y)) {
				entities.add(entity);
				if (living && !bottom && !combat) {
					this.x = entity.x + entity.width;
					x_speed = 0;
				} else if (!combat) {
					x_speed = 0;
					y_speed = 0;
					grounded = true;
				} else if (combat && entity.alive) {
					entity.x_speed = -4;
				}
			}
		}
		bottom = false;
		return entities;
	}
}
