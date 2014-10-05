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
    ImageIcon ij = new ImageIcon(this.getClass().getResource("/gamedesk.png"));
    Image desk = this.ij.getImage();
    private int x = 0, y = 500 - this.height;
    double yVelocity;
    boolean jump1, jump2;
    final double g = .3;
    double time;
    int worldSizeX = 1300, viewSizeX = 800, viewSizeY = 600;

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
                .isKeyPressed(KeyEvent.VK_LEFT)
                && this.x - 2 >= 200) {
            this.x -= 2;
        }
        if (this.getViewFactory().getGameEngine().getKeyBoardListener()
                .isKeyPressed(KeyEvent.VK_RIGHT)
                && this.x + 2 <= 1150 - 6 - this.width) {
            this.x += 2;
        }
        if (this.getViewFactory().getGameEngine().getKeyBoardListener()
                .isKeyPressed(KeyEvent.VK_UP)) {
            this.jump1 = true;
            this.jump2 = false;
            this.yVelocity = 8;
            this.time = .01;
            while (this.jump1) {
                //double jump
                if (this.getViewFactory().getGameEngine().getKeyBoardListener()
                        .isKeyPressed(KeyEvent.VK_A)
                        && this.jump2 == false) {
                    this.jump2 = true;
                    this.yVelocity = 8;
                }
                //moving while jumping
                if (this.getViewFactory().getGameEngine().getKeyBoardListener()
                        .isKeyPressed(KeyEvent.VK_LEFT)
                        && this.x - 2 >= 200) {
                    this.x -= 2;
                }
                if (this.getViewFactory().getGameEngine().getKeyBoardListener()
                        .isKeyPressed(KeyEvent.VK_RIGHT)
                        && this.x + 2 <= 1150 - 6 - this.width) {
                    this.x += 2;
                }

                //boundaries
                if ((int) (this.y - this.yVelocity * this.time - .5 * this.g
                        * this.time * this.time) >= 500 - this.height) {
                    this.jump1 = false;
                    this.jump2 = false;
                    this.y = 500;
                } else {
                    this.y = (int) (this.y - this.yVelocity * this.time - .5
                            * this.g * this.time * this.time);
                }

                this.time += .01;
                this.yVelocity -= this.g * this.time;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }

        if (this.x >= this.worldSizeX - this.width - 6) {
            this.x = this.worldSizeX - this.width - 6;
        }
        if (this.x <= 200) {
            this.x = 200;
        }
        if (this.y >= 500 - this.height) {
            this.y = 500 - this.height;
        }
    }

    @Override
    public void onDraw(Graphics2D g2d) {
        //moving camera
        int camX = this.x - this.viewSizeX / 2;
        if (camX > this.worldSizeX - this.viewSizeX) {
            camX = this.worldSizeX - this.viewSizeX;
        }
        if (camX < 0) {
            camX = 0;
        }
        g2d.translate(-camX, 0);

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, this.worldSizeX, this.viewSizeY);
//        g2d.setColor(Color.BLACK);
//        g2d.fillRect(20, 400, 20, 100);
//        g2d.fillRect(120, 400, 20, 100);
//        g2d.fillRect(420, 400, 20, 100);
//        g2d.fillRect(820, 400, 20, 100);

        g2d.drawImage(this.desk, 0, 190, null);
        g2d.drawImage(this.image, this.x, this.y, null);

//        g2d.setColor(Color.gray);
//        g2d.fillRect(0, 500, this.worldSizeX, 100);
//        g2d.setColor(Color.GREEN);
//        g2d.fillRect(0, 500, this.worldSizeX, 10);
    }

}
