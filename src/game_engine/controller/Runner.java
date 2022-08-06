package game_engine.controller;

public class Runner {
	
	private static I_Game_Manager game;
	
	public static I_Game_Manager get_context() {
		if (game == null) {
			game = new Game_Manager();
		}
		
		return game;
	}
	
	public static void restart() {
		Level level = Level1.getInstance(game);

		game.setLevel(level);
		game.start();
	}
	
	public static void main(String[] args) {
		game = Runner.get_context();
		restart();
	}
}
