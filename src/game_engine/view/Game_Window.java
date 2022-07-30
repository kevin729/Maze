package game_engine.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import game_engine.controller.Runner;



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
