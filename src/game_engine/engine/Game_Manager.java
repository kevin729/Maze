package game_engine.engine;

import java.util.ArrayList;

import game_engine.level.Level;
import game_engine.entities.Entity_Manager;
import game_engine.entities.living.enemies.Enemy;
import game_engine.entities.Entity;
import game_engine.entities.living.Living;
import game_engine.entities.living.Player;
import game_engine.entities.object.Wall;
import game_engine.util.Timer;
import game_engine.view.Camera;

public class Game_Manager implements I_Game_Manager {
	private  Game_Engine game_Engine;

	private int resolution_Width = 1200;
	private int resolution_Height = 600;
	private int game_Width = 300;
	private int game_Height = 300;

	private Level level;
	private Camera camera;
	private Timer timer;
	
	public Game_Manager() {
		game_Engine = new Game_Engine(this);
		timer = new Timer(2);
		camera = new Camera();
		level = Level.getInstance(this, 1);
	}
	
	@Override
	public void start() {
		game_Engine.start();
	}
	
	@Override
	public void stop() {
		level.getEm().remove_entities();
		game_Engine.stop();
	}

	@Override
	public void add_player(Player p) {
		level.getEm().add_entity(p);
	}

	@Override
	public void add_enemy(Enemy e) {
		level.getEm().add_entity(e);
	}

	@Override
	public int get_game_width() {
		return game_Width;
	}

	@Override
	public int get_game_height() {
		return game_Height;
	}
	
	@Override
	public void set_game_width(int w) {
		game_Width = w;
	}

	@Override
	public void set_game_height(int h) {
		game_Height = h;
	}

	@Override
	public int get_resolution_width() {
		return resolution_Width;
	}

	@Override
	public int get_resolution_height() {
		return resolution_Height;
	}
	
	@Override
	public ArrayList<Entity> get_entities() {
		return level.getEm().get_entities();
	}

	@Override
	public void add_wall(Wall w) {
		level.getEm().add_entity(w);
	}

	@Override
	public Entity_Manager get_entity_manager() {
		return level.getEm();
	}

	@Override
	public void render_entity(double x, double y, double w, double h, String text) {
		game_Engine.get_Canvas().draw_Entity((int)x, (int)y, (int)w, (int)h, text);
	}

	@Override
	public Level getLevel() {
		return level;
	}

	@Override
	public void setLevel(Level level) {
		this.level = level;
	}

	@Override
	public void render_entity(double x, double y, double w, double h, int c) {
		game_Engine.get_Canvas().draw_Entity((int)x, (int)y, (int)w, (int)h, c);
	}

	@Override
	public Living get_player() {
		for (Entity e : get_entities()) {
			if (e.get_name().equals("Player")) {
				return (Living)e;
			}
		}
		return null;
	}
	
	@Override
	public Living get_enemy() {
		for (Entity e : get_entities()) {
			if (e.get_name().equals("Enemy")) {
				return (Living)e;
			}
		}
		return null;
	}

	@Override
	public Timer get_timer() {
		return timer;
	}

	@Override
	public Camera get_camera() {
		return camera;
	}

	@Override
	public Game_Engine get_game_engine() {
		return game_Engine;
	}
}
