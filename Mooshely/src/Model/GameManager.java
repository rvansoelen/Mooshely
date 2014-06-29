package Model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import View.GameView;
import View.GameViewFactory;

public class GameManager extends GameView {
    private int currentLevel;
    ImageIcon ii = new ImageIcon(this.getClass().getResource("/man.png"));
    Image image = this.ii.getImage();
    int width = this.image.getWidth(null);
    int height = this.image.getHeight(null);
    private int x = 0, y = 500 - this.height;
    int jumpheight = 30, j;

    public GameManager(GameViewFactory viewFactory) {
        super(viewFactory);
    }

    @Override
    public void onCreate() {
        System.out.println("creating!!");
    }

    @Override
    public void onUpdate() {
        if (this.getViewFactory().getGameEngine().getKeyBoardListener()
                .isKeyPressed(KeyEvent.VK_LEFT)) {
            this.x -= 2;
        }
        if (this.getViewFactory().getGameEngine().getKeyBoardListener()
                .isKeyPressed(KeyEvent.VK_RIGHT)) {
            this.x += 2;
        }
        if (this.getViewFactory().getGameEngine().getKeyBoardListener()
                .isKeyPressed(KeyEvent.VK_UP)) {
            while (this.j < this.jumpheight) {
                this.y--;
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e1) {
                }
                this.repaint();
                this.j++;
            }
        }
        this.j = 0;

        if (this.x >= 794 - this.width) {
            this.x = 794 - this.width;
        }
        if (this.x <= 0) {
            this.x = 0;
        }
        if (this.y >= 505 - this.height) {
            this.y = 505 - this.height;
        }
        if (this.y <= 0) {
            this.y = 0;
        }
        if (this.y < 505 - this.height) {
            this.y += 1;
        }
    }

    @Override
    public void onDraw(Graphics2D g2d) {
        g2d.setColor(Color.CYAN);
        g2d.fillRect(0, 0, 800, 600);
        g2d.drawImage(this.image, this.x, this.y, null);
        g2d.setColor(Color.gray);
        g2d.fillRect(0, 500, 800, 100);
        g2d.setColor(Color.GREEN);
        g2d.fillRect(0, 500, 800, 10);
    }

}
