package game_engine.controller;

import game_engine.model.Enemy;
import game_engine.model.Living;
import game_engine.model.Player;
import game_engine.model.Wall;

public class Runner {
	
	private static I_Game_Manager game;
	
	public static I_Game_Manager get_context() {
		if (game == null) {
			game = new Game_Manager();
		}
		
		return game;
	}
	
	public static void restart() {
		Living e = game.get_enemy();
		
		
		game.stop();
		
		game.add_player(new Player(30, 100, 50, 50));
		
		if (e == null)
		{
			game.add_enemy(new Enemy(270, 100, 50, 50));
		} else {
			e.set_X(270);
			e.set_Y(100);
			e.set_Health(20);
			game.add_enemy((Enemy)e);
		}
		
		
		game.add_wall(new Wall(0, 0, game.get_resolution_width(), 20));
		game.add_wall(new Wall(0, 280, game.get_resolution_width(), 20));
		game.add_wall(new Wall(0, 0, 20, game.get_resolution_height()));
		game.add_wall(new Wall(game.get_resolution_width()-20, 0, 20, game.get_resolution_height()));
		
		game.start();
	}
	
	public static void main(String[] args) {
		game = Runner.get_context();
		restart();
		game.start();
	}
}
