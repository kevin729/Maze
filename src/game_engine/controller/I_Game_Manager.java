package game_engine.controller;

import java.util.ArrayList;

import game_engine.model.Enemy;
import game_engine.model.Entity;
import game_engine.model.Living;
import game_engine.model.Player;
import game_engine.model.Wall;

public interface I_Game_Manager {
	public int get_game_width();
	public int get_game_height();
	public int get_resolution_width();
	public int get_resolution_height();
	public Entity_Manager get_entity_manager();
	public ArrayList<Entity> get_entities();
	public Game_Engine get_game_engine();
	public boolean get_Testing();
	public Living get_player();
	public Living get_enemy();
	
	public void set_game_width(int w);
	public void set_game_height(int h);
	public void set_Testing(boolean _testing);
	
	public void add_player(Player p);
	public void add_enemy(Enemy e);
	public void add_wall(Wall w);
	
	public void start();
	public void stop();
	public void render_entity(double x, double y, double w, double h, int c);
	public void render_entity(double x, double y, double w, double h, String t);

	public Level getLevel();
	public void setLevel(Level level);
}
