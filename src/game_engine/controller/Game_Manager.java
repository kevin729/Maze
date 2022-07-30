package game_engine.controller;

import java.util.ArrayList;

import game_engine.model.Enemy;
import game_engine.model.Entity;
import game_engine.model.Living;
import game_engine.model.Player;
import game_engine.model.Wall;

public class Game_Manager implements I_Game_Manager {
	private  Game_Engine game_Engine;
	private  Entity_Manager entity_Manager;
	private int resolution_Width = 600;
	private int resolution_Height = 300;
	private int game_Width = 600;
	private int game_Height = 300;
	private boolean testing = false;
	
	public Game_Manager() {
		game_Engine = new Game_Engine(this);
		entity_Manager = new Entity_Manager();
	}
	
	@Override
	public void start() {
		game_Engine.start();
	}
	
	@Override
	public void stop() {
		entity_Manager.remove_entities();
		game_Engine.stop();
	}

	@Override
	public void add_player(Player p) {
		entity_Manager.add_entity(p);
	}

	@Override
	public void add_enemy(Enemy e) {
		entity_Manager.add_entity(e);
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
		return entity_Manager.get_entities();
	}

	@Override
	public void add_wall(Wall w) {
		entity_Manager.add_entity(w);
	}

	@Override
	public Entity_Manager get_entity_manager() {
		return entity_Manager;
	}

	@Override
	public void render_entity(double x, double y, double w, double h, String text) {
		game_Engine.get_Canvas().draw_Entity((int)x, (int)y, (int)w, (int)h, text);
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
	public Game_Engine get_game_engine() {
		return game_Engine;
	}

	@Override
	public boolean get_Testing() {
		return testing;
	}

	@Override
	public void set_Testing(boolean _testing) {
		testing = _testing;
	}
}
