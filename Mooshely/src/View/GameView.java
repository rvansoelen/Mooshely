package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Model.Sprite;

@SuppressWarnings("serial")
public final class GameView extends JPanel {

    public Set<Sprite> sprites;

    public GameView(Set<Sprite> sprites) {
        super();
        this.sprites = sprites;

    }

    @Override
    public void paint(Graphics g) {
    	Graphics2D g2d = (Graphics2D) g;
    	for (Sprite sprite : sprites) {
    		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());  //temporary background
        	g2d.drawImage(sprite.getImage(), sprite.x, sprite.y, null);
    	}
    }

}
