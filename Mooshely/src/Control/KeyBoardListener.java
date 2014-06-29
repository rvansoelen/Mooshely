package Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardListener implements KeyListener {

    private boolean[] keys = new boolean[256];

    @Override
    public void keyPressed(KeyEvent event) {
        this.keys[event.getKeyCode()] = true;

    }

    @Override
    public void keyReleased(KeyEvent event) {
        this.keys[event.getKeyCode()] = false;

    }

    @Override
    public void keyTyped(KeyEvent event) {

    }

    public boolean isKeyPressed(int key) {
        return this.keys[key];
    }

    public boolean isKeyReleased(int key) {
        return !this.keys[key];
    }
}
