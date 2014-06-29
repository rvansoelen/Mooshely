package View;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Set;

import javax.swing.JPanel;

import Model.Sprite;

public abstract class GameView extends JPanel {

    Set<Sprite> sprites;
    private final GameViewFactory viewFactory;

    public GameView(GameViewFactory viewFactory) {
        super();
        this.viewFactory = viewFactory;
        this.setBackground(Color.RED);
        System.out.println("ddHHdd");
    }

    public abstract void onCreate();

    public abstract void onUpdate();

    public abstract void onDraw(Graphics2D g2d);

    public GameViewFactory getViewFactory() {
        return this.viewFactory;
    }
}
