package ui;

import lib.*;

public class BucketheadZombie_ui extends Zombies_ui{
	BucketheadZombie_ui(int x, int y){
		super(Resource.bucketheadzombie_walk);
		pos_x = x;
		pos_y = y;
	}
	
	public int pos_x;
	public int pos_y;

}
