package Control;

import java.awt.Graphics2D;

import View.GameView;
import View.GameViewFactory;

public class LevelCreator extends GameView {

    public LevelCreator(GameViewFactory viewFactory) {
        super(viewFactory);
    }

    @Override
    public void onCreate() {
        System.out.println("creating!!");
    }

    @Override
    public void onUpdate() {

    }

    @Override
    public void onDraw(Graphics2D g2d) {
        // TODO Auto-generated method stub

    }

}
