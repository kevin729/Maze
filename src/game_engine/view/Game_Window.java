package game_engine.view;

import javax.swing.JFrame;


public class Game_Window extends JFrame {

	public Game_Window(Game_Canvas game_Canvas) {

		setResizable(true);
		setTitle("Maze");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		add(game_Canvas);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
