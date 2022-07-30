package game_engine.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import game_engine.controller.Runner;



public class Game_Window extends JFrame {
	
	private JButton testBtn = new JButton("Test Mode");
	
	public Game_Window(Game_Canvas game_Canvas) {
		testBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Runner.get_context().get_Testing()) {
					Runner.get_context().set_Testing(false);
				} else {
					Runner.get_context().set_Testing(true);
				}
			}
		});
		
		setResizable(true);
		setTitle("Combat Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		add(game_Canvas);
		add(testBtn, BorderLayout.SOUTH);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		
	}
}
