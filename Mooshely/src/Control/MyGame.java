package Control;

import Model.GameManager;

public class MyGame {
    private GameEngine game;

    public MyGame() {
        this.game = new GameEngine(800, 600, "Mooshley!");
        this.game.getViewFactory().showView(
                new GameManager(this.game.getViewFactory()));
    }

    public static void main(String[] args) {
        new MyGame();
    }
}
