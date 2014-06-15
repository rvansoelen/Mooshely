package Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener{
	
	private Entity entity;
	private boolean listenerOn = false;
	
	public Controller(Entity entity) {
		this.entity = entity;
		if (entity.getClass().equals(Mooshley.class)) {
			listenerOn = true;
			System.out.println("classes match");
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.println("Key Pressed");
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
