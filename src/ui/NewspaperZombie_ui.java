package ui;

import lib.*;

public class NewspaperZombie_ui extends Zombies_ui{
	NewspaperZombie_ui(int x, int y){
		super(Resource.newspaperzombie_walk);
		pos_x = x;
		pos_y = y;
	}
	
	public int pos_x;
	public int pos_y;

}
