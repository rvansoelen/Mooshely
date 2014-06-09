package Control;

import java.util.Set;

import javax.swing.JFrame;

import Model.GameManager;
import Model.Sprite;
import View.GameView;

public class GameEngine implements Runnable{
	static JFrame frame;
    static GameView view;
    static GameManager manager;
    Set<Sprite> sprites;
	private int FPS = 60;
	private int wait;
	private boolean running = false;

	public GameEngine(GameView view) {
		super();
		this.view = view;
		manager = new GameManager();
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
		while (running) {
			long starttime = System.currentTimeMillis();
			long wait = 1000000/FPS; //millis
			
			//Update game variables
			manager.update();
	 
			//Draw view
			view.repaint();
			
			long stoptime = System.currentTimeMillis();
			long lapsed = stoptime-starttime;
			if (lapsed < wait) {
				try {
					System.out.println(wait);
					Thread.sleep(wait - lapsed);
					System.out.println("ffff");
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
		frame = new JFrame("Mooshely!");
		view = new GameView();
		frame.setBounds(150,150,800,600);
		frame.setResizable(false);
		frame.add(view);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	    new GameEngine(view);
	}
}

