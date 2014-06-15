package Model;

import java.util.Map;
import java.util.Set;

import MooshleyTypes.NormalMooshley;


public class GameManager{
	private int currentLevel;
	private Map<Integer, String> levels; //level index, level filename
	public Set<Sprite> sprites;

	public GameManager(Set<Sprite> sprites) {
		this.sprites = sprites;
		loadLevel(0);
	}
	
	
	public void loadLevel(int level) {
		currentLevel = level;
		/*
		 * Load map information using the variable "levels"
		 * 
		 */
		//for now:
		sprites.add(new NormalMooshley(0, 0));
	}
	
	public void update() {
		for (Sprite sprite : sprites) {
			sprite.update();
		}
	}

}
