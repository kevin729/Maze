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
		new Level2(game);
		game.start();
	}
	
	public static void main(String[] args) {
		game = Runner.get_context();
		restart();
	}
}
