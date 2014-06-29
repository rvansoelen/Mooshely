package Control;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Set;

import javax.swing.JPanel;

import Model.Sprite;

public class GameEngineRun extends JPanel implements Runnable {

    private final GameEngine game;
    Set<Sprite> sprites;
    private int FPS = 60;
    private int wait;

    public GameEngineRun(GameEngine game) {
        this.game = game;
        this.setFocusable(true);
    }

    @Override
    public void run() {
        while (true) {
            long starttime = System.currentTimeMillis();
            long wait = 1000000 / this.FPS; //millis

            long stoptime = System.currentTimeMillis();
            long lapsed = stoptime - starttime;
            //if (lapsed < wait) {
            try {
                if (this.game.getViewFactory().getCurrentView() != null) {
                    this.game.getViewFactory().getCurrentView().onUpdate();
                }
                Thread.sleep(10);
                //Thread.sleep(wait - lapsed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        if (this.game.getViewFactory().getCurrentView() != null) {
            this.game.getViewFactory().getCurrentView().onDraw(g2d);
        }
        this.repaint();
    }

}
