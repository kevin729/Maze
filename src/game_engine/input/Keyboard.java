package game_engine.input;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
	private static Keyboard keyboard = new Keyboard();
	
	private boolean[] keys = new boolean[256];
	public static boolean UP, DOWN, LEFT, RIGHT, ATTACK, BLOCK, LONG;
	

	private Keyboard() {
		
	}
	
	public static Keyboard get_Instance() {
		if (keyboard == null) {
			keyboard = new Keyboard();
		}
		
		return keyboard;
	}
	
	public void update() {
		UP = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		DOWN = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		LEFT = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		RIGHT = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		ATTACK = keys[KeyEvent.VK_CONTROL];
		BLOCK = keys[KeyEvent.VK_ALT];
		LONG = keys[KeyEvent.VK_BACK_SLASH] || keys[KeyEvent.VK_SLASH];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		keys[e.getKeyCode()] = true;
		e.consume();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}
