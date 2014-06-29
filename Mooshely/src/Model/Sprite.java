package Model;

import java.awt.Image;

public class Sprite {
	public int x;
	public int y;
	protected Image image;
	protected String img_name;
	
	protected Sprite(int x, int y) {
		init();
	}
	
	protected void init() {
		
	}
	
	public Image getImage() {
		return image;
	}
	
	public void update() {
		
	}
}
