package com.angad.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel {
 Plane plane = new Plane();
 
 private Timer timer;
 private final int DELAY_TIME=10;
 private ArrayList<Enemy> enemyList = new ArrayList<>();
 private final int MAX_ENEMY=20;
 private boolean gameOver = false;
 private boolean gameOver1 = false;
 int positionOfElements[][]={
		 {1000,30},{1209,90},{600,130},{1040,230},{1200,40},
		 {1100,130},{1400,430},{1070,330},{1030,100},{1020,250},
		 {1100,109},{1100,130},{1070,30},{1040,30},{1020,30},
		 {1100,409},{1100,230},{1200,40},{1100,440},{1006,130}
 };
 
 private void prepareEnemy(){
	 
	 for(int i=1; i<positionOfElements.length ; i++){
		 enemyList.add(new Enemy(positionOfElements[i][0],positionOfElements[i][1])); 
	 }
 }
 
 
 public Board(){
	 this.setFocusable(true);
	 this.setBackground(Color.CYAN);
	 this.prepareEnemy();
	 
	 this.addKeyListener(new KeyAdapter() {
		 @Override
		 public void keyPressed(KeyEvent E){
			 plane.planeMove(E);
		 }
		 @Override
		 public void keyReleased(KeyEvent e){
			 plane.planeNotMove(e);
			 
		 }
	});
	 	timer= new Timer(DELAY_TIME, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				plane.move();
				repaint();
			}
		});
	 	timer.start();
 }
 @Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D twod = (Graphics2D) g;
		twod.drawImage(new ImageIcon(Board.class.getResource("sky-edited.gif")).getImage(), 0, 0, this);
		twod.drawString("Enemies Left "+enemyList.size(), 10, 20);
		if(plane.isVisible()){
		twod.drawImage(plane.getImage(), plane.getX(), plane.getY(), this);
		}
		
		// Check Collision (Missile)
		for(int i = 0 ; i<plane.getMissileList().size();i++){
			for(int j = 0; j<enemyList.size();j++){
				Missile missile = plane.getMissileList().get(i);
				Enemy enemy = enemyList.get(j);
				if(missile.getRectangle().intersects(enemy.getRectangle())){
					missile.setVisible(false);
					enemy.setVisible(false);
					enemyList.remove(j);
				}
			}
		}
		
		for(int j = 0; j<enemyList.size();j++){
			
			Enemy enemy = enemyList.get(j);
			if(plane.getRectangle().intersects(enemy.getRectangle())){
				gameOver = true;
				plane.setVisible(false);
				enemy.setVisible(false);
				enemyList.remove(j);
				
			}
		}
		
		
		
		
		for(int i = 0 ; i<plane.getMissileList().size(); i++){
			Missile missile = plane.getMissileList().get(i);
		//for(Missile missile: plane.getMissileList()){
			if(missile.isVisible()){
				missile.moveMissile();
				twod.drawImage(missile.getImage(), missile.getX(), missile.getY(), this);
				//System.out.println("Plane "+plane);
			}
			else{
				plane.getMissileList().remove(i);
			}
		}
		if(enemyList.size()==0){
			gameOver1 = true;
		}
		if(gameOver){
			timer.stop();
			twod.setFont(new Font("Arial",Font.BOLD,40));
			twod.drawString("GAME OVER", 400, 250);
			twod.drawString("YOU LOST", 420, 300);
			enemyList.clear();
		}
		else
		if(gameOver1){
			timer.stop();
			twod.setFont(new Font("Arial",Font.BOLD,40));
			twod.drawString("GAME OVER", 400, 250);
			twod.drawString("YOU WON", 420, 300);

			enemyList.clear();
		}
		for(int i = 0; i<enemyList.size();i++){
			Enemy enemyObject = enemyList.get(i);
			if(enemyObject.isVisible() ){
				
				enemyObject.move();
				twod.drawImage(enemyObject.getImage(), enemyObject.getVelX(), enemyObject.getVelY(), this);
			}
			else{
				
			}
		}
		Toolkit.getDefaultToolkit().sync();
		 
	}
	}