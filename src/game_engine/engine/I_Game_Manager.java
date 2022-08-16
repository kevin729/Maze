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

public interface I_Game_Manager {
	int get_game_width();
	int get_game_height();
	int get_resolution_width();
	int get_resolution_height();
	Entity_Manager get_entity_manager();
	ArrayList<Entity> get_entities();
	Game_Engine get_game_engine();
	Living get_player();
	Living get_enemy();
	Timer get_timer();
	Camera get_camera();

	void set_game_width(int w);
	void set_game_height(int h);
	
	void add_player(Player p);
	void add_enemy(Enemy e);
	void add_wall(Wall w);
	
	void start();
	void stop();
	void render_entity(double x, double y, double w, double h, int c);
	void render_entity(double x, double y, double w, double h, String t);

	Level getLevel();
	void setLevel(Level level);
}
