package game_engine;

import game_engine.engine.Game_Manager;
import game_engine.engine.I_Game_Manager;
import game_engine.level.Level;

public class Runner {
	
	private static I_Game_Manager game;
	
	public static I_Game_Manager get_context() {
		if (game == null) {
			game = new Game_Manager();
		}
		
		return game;
	}
	
	public static void restart() {
		game.start();
	}
	
	public static void main(String[] args) {
		game = Runner.get_context();
		restart();
	}
}
