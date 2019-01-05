package ui;

import lib.*;

public class FootballZombie_ui extends Zombies_ui{
	FootballZombie_ui(int x, int y){
		super(Resource.footballzombie_walk);
		pos_x = x;
		pos_y = y;
	}
	
	public int pos_x;
	public int pos_y;

}
