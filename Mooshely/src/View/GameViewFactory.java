package View;

import Control.GameEngine;

public class GameViewFactory {

    private final GameEngine game;
    private GameView view;

    public GameViewFactory(GameEngine game) {
        this.game = game;
    }

    public void showView(GameView view) {
        this.view = view;
        this.view.onCreate();
    }

    public GameView getCurrentView() {
        return this.view;
    }

    public GameEngine getGameEngine() {
        return this.game;
    }
}
