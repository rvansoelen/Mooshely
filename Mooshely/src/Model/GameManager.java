package Model;

import java.util.Map;
import java.util.Set;

import MooshleyTypes.NormalMooshley;


public class GameManager{
	private int currentLevel;
	private Map<Integer, String> levels; //level index, level filename
	public Set<Sprite> sprites;

	
	public void loadLevel(int level) {
		currentLevel = level;
		/*
		 * Load map information using the variable "levels"
		 * 
		 */
		//for now:
		sprites.add(new NormalMooshley());
	}
	
	public void update() {

	}

}
