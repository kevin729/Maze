package game_engine.controller;

public class Timer {
	
	public boolean running = false;
	public boolean over = false;
	private long timer, lastTime = 0;
	private int delay = 0;
	
	public Timer(int _delay) {
		delay = _delay;
	}
	
	public void tick() {
		if (!running) {
			running = true;
			Thread thread = new Thread() {
				@Override
				public void run() {
						while (running) {
							lastTime = System.currentTimeMillis();
							timer += System.currentTimeMillis() - lastTime;
							
							if (timer > delay) {
								timer = 0;
								running = false;
								over = true;
							}
			        	}
					}
				};
			
			thread.start();
		}
	}
}
