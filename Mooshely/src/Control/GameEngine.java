package Control;

<<<<<<< HEAD
=======
import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

>>>>>>> branch 'master' of https://github.com/rvansoelen/Mooshely.git
import javax.swing.JFrame;

import View.GameViewFactory;

<<<<<<< HEAD
public class GameEngine {
    private final JFrame frame = new JFrame();
    private final GameViewFactory viewFactory;
    private final KeyBoardListener keyBoardListener;
    private final GameEngineRun gameRun;
=======
public class GameEngine implements Runnable{
	JFrame frame;
    GameView view;
    GameManager manager;
    public Set<Sprite> sprites = new HashSet<Sprite>();
	private int FPS = 60;
	private int wait;
	private boolean running = false;
>>>>>>> branch 'master' of https://github.com/rvansoelen/Mooshely.git

<<<<<<< HEAD
    public GameEngine(int frameX, int frameY, String title) {
        this.frame.setSize(frameX, frameY);
        this.frame.setTitle(title);
        this.frame.setResizable(false);
        this.frame.setFocusable(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        this.frame.setLocationRelativeTo(null);

        this.viewFactory = new GameViewFactory(this);
        this.keyBoardListener = new KeyBoardListener();
        this.gameRun = new GameEngineRun(this);
        this.frame.addKeyListener(this.keyBoardListener);
        this.frame.add(this.gameRun);
        new Thread(this.gameRun).start();
    }

    public KeyBoardListener getKeyBoardListener() {
        return this.keyBoardListener;
    }

    public GameViewFactory getViewFactory() {
        return this.viewFactory;
    }

    public JFrame getFrame() {
        return this.frame;
    }

=======
	public GameEngine() {
		super();
		//Set up the frame, view and manager
		frame = new JFrame("Mooshely!");
		view = new GameView(sprites);
		frame.setBounds(150,150,800,600);
		frame.setResizable(false);
		frame.setBackground(Color.RED);
		frame.add(view);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		manager = new GameManager(sprites);
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
>>>>>>> branch 'master' of https://github.com/rvansoelen/Mooshely.git
}
