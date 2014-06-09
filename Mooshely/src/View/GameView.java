package View;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.Sprite;

import Control.GameEngine;

public final class GameView extends JPanel {
	
	Set<Sprite> sprites;
	
	public GameView() {
		super();
		this.setBackground(Color.RED);
		System.out.println("ddHHdd");
		
	}
	
	public void draw() {
		//Graphics2D g = (Graphics2D) getGraphics();
		//g.drawString("Hello", 10, 10);
		System.out.println("hhhhh");
		//g.dispose();
	}
	
	@Override
	public void paint(Graphics g) {
		ImageIcon ii = new ImageIcon(this.getClass().getResource("man.png"));
	 	Image image = ii.getImage();
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image, 0, 0, null); 
	}
	
	
	

}
