package game_engine.util;

public class Timer {
	
	public boolean running = false;
	public boolean over = false;
	private double timer = 0;
	private double delay;
	
	public Timer(double _delay) {
		delay = _delay;
	}
	
	public void tick() {
		if (!running) {
			running = true;

			Thread thread = new Thread() {
				@Override
				public void run() {
					long prev_time = System.nanoTime();
					long current_time;
					while (running) {
						current_time = System.nanoTime();
						timer += (current_time - prev_time) / (delay * 1000000000);

						if (timer >= 1) {
							timer = 0;
							running = false;
							over = true;
						}

						prev_time = current_time;
					}
				}
			};
			
			thread.start();
		}
	}
}
