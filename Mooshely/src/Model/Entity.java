package Model;

public class Entity extends Sprite{

	public boolean jumping;
	public boolean faceRight;
	public boolean moving;
	public boolean standing;
	private Controller controller;
	
	
	public Entity(int x, int y) {
		super(x, y);
		controller = new Controller(this);
	}
}
