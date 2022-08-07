package game_engine.engine;

import game_engine.Runner;
import game_engine.input.Keyboard;
import game_engine.util.Timer;
import game_engine.view.Game_Canvas;
import game_engine.view.Game_Window;

public class Game_Engine {
	
	public static Timer game_over;
	
	private int fps = 30;
	
	private boolean is_running = false;
	private Game_Canvas game_Canvas;
	private Keyboard keyboard;
	
	public static double delta_Time = 0;


	public Game_Engine(Game_Manager game) {
		game_Canvas = new Game_Canvas(game);
		new Game_Window(game_Canvas);
		
		keyboard = Keyboard.get_Instance();
		game_Canvas.addKeyListener(keyboard);
		game_over = new Timer(2);
	}
	
	public void set_fps(int _fps) {
		fps = _fps;
	}
	
	public synchronized void start() {
		is_running = true;
		loop();
	}
	
	public synchronized void stop() {
		is_running = false;
	}
	
	private void loop() {
		double delta = 0; // time between tick
		long previous_time = System.nanoTime();
		long previous_frame_time = System.nanoTime();
		
		while (is_running) {
			double max_time = 1000000000 / fps;
			long current_time = System.nanoTime();
			
			delta += (current_time - previous_time) / max_time;
			
			if (delta >= 1) {
				delta = 0;
				
				long current_frame_time = System.nanoTime();
				delta_Time = (current_frame_time - previous_frame_time);
				previous_frame_time = current_frame_time;
				
				update();
				render();
			}
			
			previous_time = current_time;
		}
	}
	
	private void update() {
		keyboard.update();
		Runner.get_context().get_entity_manager().update();
		game_Canvas.update();
		
		if (game_over.over) {
			game_over.over = false;
			Runner.restart();
		}
	}
	
	private void render() {
		game_Canvas.render();
	}
	
	public Game_Canvas get_Canvas() {
		return game_Canvas;
	}
}
