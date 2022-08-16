package game_engine.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import game_engine.engine.Game_Engine;
import game_engine.engine.I_Game_Manager;
import game_engine.Runner;
import game_engine.entities.living.Living;
import game_engine.entities.living.Player;
import game_engine.level.Level;
import game_engine.util.Timer;
import game_engine.input.Keyboard;

public class Game_Canvas extends Canvas {

	private String result = "";
	
	public Game_Canvas(I_Game_Manager game) {	
		Toolkit.getDefaultToolkit().setDynamicLayout(false);
		requestFocus();
		addKeyListener(Keyboard.get_Instance());

		Dimension size = new Dimension(game.get_resolution_width(), game.get_resolution_height());
		setPreferredSize(size);
	}
	
	public void update() {
		
	}
	
	public void render() {
		BufferStrategy buffer_Strategy = getBufferStrategy();
		
		if (buffer_Strategy == null) {
			createBufferStrategy(3);
			return;
		}

		clear();
		
		Timer game_over = Game_Engine.game_over;

		Living player = Runner.get_context().get_player();
		Level level = Runner.get_context().getLevel();

		if ((player.get_Health() <= 0 || player.y > level.getHeight()) && !game_over.running) {
			result = "GAME OVER";
			level.setupLevel(Runner.get_context());
			game_over.tick();
		} else if (game_over.running) {
			draw_Entity((level.getViewWidth()/2)-150, (level.getViewHeight()/2), 100, 100, result);
		} else {
			Runner.get_context().getLevel().render();
		}

		Graphics graphics = buffer_Strategy.getDrawGraphics();
		graphics.drawImage(Runner.get_context().getLevel().getImage(), 0, 0, getWidth(), getHeight(), null);
				
		//Display
		Toolkit.getDefaultToolkit().sync();
		buffer_Strategy.show();
		graphics.dispose();
	}
	
	public void clear() {
		for (int i = 0; i < Runner.get_context().getLevel().getPixels().length; i++) {
			Runner.get_context().getLevel().getPixels()[i] = 0;
		}
	}
	
	public void draw_Entity(int _x, int _y, int _width, int _height, int color) {
		Graphics2D g = Runner.get_context().getLevel().getImage().createGraphics();
		g.setColor(new Color(color));
		g.fillRect(_x, _y, _width, _height);
	}
	
	public void draw_Entity(int _x, int _y, int _width, int _height, String text) {
		Graphics2D g = Runner.get_context().getLevel().getImage().createGraphics();
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.BOLD, _width/2));
		
		int line_index = 0;
		for (String line : text.split("\n")) {
			g.drawString(line, _x, _y + line_index * _height);
			line_index++;
		}
	}
}
