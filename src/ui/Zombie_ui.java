package ui;

import lib.*;

public class Zombie_ui extends Zombies_ui{
	Zombie_ui(int x, int y){
		super(Resource.zombie_walk);
		pos_x = x;
		pos_y = y;
	}
	
	public int pos_x;
	public int pos_y;

}
