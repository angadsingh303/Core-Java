package com.angad.game;
 
import javax.swing.JFrame;

import java.awt.BorderLayout;

public class GameLauncher extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int BOARD_WIDTH = 1000;
	public static final  int BOARD_HEIGHT = 500;
	public GameLauncher(){
		Board board = new Board();
		this.add(board);
		this.setSize(BOARD_WIDTH, BOARD_HEIGHT);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    
		GameLauncher gameLauncher = new GameLauncher();
	} 

}
