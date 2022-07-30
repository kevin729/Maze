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

import game_engine.controller.Game_Engine;
import game_engine.controller.Game_Manager;
import game_engine.controller.I_Game_Manager;
import game_engine.controller.Runner;
import game_engine.controller.Timer;
import game_engine.controller.input.Keyboard;

public class Game_Canvas extends Canvas {
	
	private BufferedImage image;
	private int[] pixels;
	private String result = "";
	
	public Game_Canvas(I_Game_Manager game) {	
		Toolkit.getDefaultToolkit().setDynamicLayout(false);
		requestFocus();
		addKeyListener(Keyboard.get_Instance());
		
		image = new BufferedImage(game.get_resolution_width(), game.get_resolution_height(), BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
		
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
		
		//Clear
		clear();
		
		Timer game_over = Game_Engine.game_over;
		if (!game_over.over) {
			if (Runner.get_context().get_player().get_Health() <= 0 && !game_over.running) {
				result = "LOSE";
				game_over.tick();
			}
			
			if (Runner.get_context().get_enemy().get_Health() <= 0 && !game_over.running) {
				result = "WIN";
				game_over.tick();
			}
		}
		
		//Draw
		if (game_over.running) {
			draw_Entity(250, 150, 100, 100, result);
		} else {
			Runner.get_context().get_entity_manager().render();
		}
			
		//Render
		Graphics graphics = buffer_Strategy.getDrawGraphics();
		graphics.drawImage(image, 0, 0, getWidth(), getHeight(), null);
				
		//Display
		Toolkit.getDefaultToolkit().sync();
		buffer_Strategy.show();
		graphics.dispose();
	}
	
	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void draw_Entity(int _x, int _y, int _width, int _height, int color) {
		Graphics2D g = image.createGraphics();
		g.setColor(new Color(color));
		g.fillRect(_x, _y, _width, _height);
		
//		for (int y = _y; y < _y+_height; y++) {
//			for (int x = _x; x < _x+_width; x++) {
//				
//				
//				if (x + y * Runner.get_context().get_resolution_width() > pixels.length || 
//					x < 0 || y < 0 || 
//					x > Runner.get_context().get_resolution_width() || 
//					y > Runner.get_context().get_resolution_height()) {
//					continue;
//				}
//				
//				pixels[x + y * Runner.get_context().get_resolution_width()] = color;
//			}
//		}
	}
	
	public void draw_Entity(int _x, int _y, int _width, int _height, String text) {
		Graphics2D g = image.createGraphics();
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.BOLD, _width/2));
		
		int line_index = 0;
		for (String line : text.split("\n")) {
			g.drawString(line, _x, _y + line_index * _height);
			line_index++;
		}
	}
}
