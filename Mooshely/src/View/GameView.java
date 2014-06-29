package View;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Set;

import javax.swing.JPanel;

import Model.Sprite;

<<<<<<< HEAD
public abstract class GameView extends JPanel {
=======
@SuppressWarnings("serial")
public final class GameView extends JPanel {
>>>>>>> branch 'master' of https://github.com/rvansoelen/Mooshely.git

<<<<<<< HEAD
    Set<Sprite> sprites;
    private final GameViewFactory viewFactory;
=======
    public Set<Sprite> sprites;
>>>>>>> branch 'master' of https://github.com/rvansoelen/Mooshely.git

<<<<<<< HEAD
    public GameView(GameViewFactory viewFactory) {
=======
    public GameView(Set<Sprite> sprites) {
>>>>>>> branch 'master' of https://github.com/rvansoelen/Mooshely.git
        super();
<<<<<<< HEAD
        this.viewFactory = viewFactory;
        this.setBackground(Color.RED);
        System.out.println("ddHHdd");
    }

    public abstract void onCreate();
=======
        this.sprites = sprites;

    }
>>>>>>> branch 'master' of https://github.com/rvansoelen/Mooshely.git

<<<<<<< HEAD
    public abstract void onUpdate();
=======
    @Override
    public void paint(Graphics g) {
    	Graphics2D g2d = (Graphics2D) g;
    	for (Sprite sprite : sprites) {
    		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());  //temporary background
        	g2d.drawImage(sprite.getImage(), sprite.x, sprite.y, null);
    	}
    }
>>>>>>> branch 'master' of https://github.com/rvansoelen/Mooshely.git

<<<<<<< HEAD
    public abstract void onDraw(Graphics2D g2d);

    public GameViewFactory getViewFactory() {
        return this.viewFactory;
    }
=======
>>>>>>> branch 'master' of https://github.com/rvansoelen/Mooshely.git
}
