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
        this.setBackground(Color.RED);
        this.sprites = sprites;

    }

    @Override
    public void paint(Graphics g) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/man.png"));
        Image image = ii.getImage();
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, 0, 0, null);
    }

//whats up
}
