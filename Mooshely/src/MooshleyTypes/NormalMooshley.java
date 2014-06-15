package MooshleyTypes;

import java.awt.Image;

import javax.swing.ImageIcon;

import Model.Mooshley;


public class NormalMooshley extends Mooshley{
	
	public NormalMooshley(int x, int y) {
		super(x, y);
	}

	@Override
	protected void init() {
		img_name = "/man.png";
		ImageIcon ii = new ImageIcon(this.getClass().getResource("/man.png"));
        image = ii.getImage();
	}
	
	@Override
	public void update() {
		x++;
		y++;
	}


}
