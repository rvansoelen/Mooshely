package Control;

import java.util.Set;

import javax.swing.JFrame;

import Model.GameManager;
import Model.Sprite;
import View.GameView;

public class GameEngine implements Runnable{
	JFrame frame;
    GameView view;
    GameManager manager;
    public Set<Sprite> sprites;
	private int FPS = 60;
	private int wait;
	private boolean running = false;

	public GameEngine() {
		super();
		//Set up the frame, view and manager
		frame = new JFrame("Mooshely!");
		view = new GameView(sprites);
		frame.setBounds(150,150,800,600);
		frame.setResizable(false);
		frame.add(view);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		manager = new GameManager();
		frame.setVisible(true);
		//Start the game
		start();
	}
	
	public synchronized void start() {
		running = true;
		run();
	}
	
	public synchronized void stop() {
		running = false;
	}
	
	@Override
	public void run() {
		//The loop that constantly updates and redraws the game
		while (running) {
			long starttime = System.currentTimeMillis();
			long wait = 1000/FPS; //millis
			
			//Update game variables
			manager.update();
	 
			//Draw view
			view.repaint();

			long stoptime = System.currentTimeMillis();
			long lapsed = stoptime-starttime;
			if (lapsed < wait) {
				try {
					Thread.sleep(wait - lapsed);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {		
	    new GameEngine();
	}
}

