package Model;

public class Controller {
	
	private Entity entity;
	private boolean listenerOn = false;
	
	public Controller(Entity entity) {
		this.entity = entity;
		if (entity.getClass().equals(Mooshley.class)) {
			listenerOn = true;
			System.out.println("classes match");
		}
	}
	
	

}
