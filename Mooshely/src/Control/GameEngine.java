package Control;

import javax.swing.JFrame;

import View.GameViewFactory;

public class GameEngine {
    private final JFrame frame = new JFrame();
    private final GameViewFactory viewFactory;
    private final KeyBoardListener keyBoardListener;
    private final GameEngineRun gameRun;

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

}
