package View;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public abstract class GameView extends JPanel {

    private final GameViewFactory viewFactory;

    public GameView(GameViewFactory viewFactory) {
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
