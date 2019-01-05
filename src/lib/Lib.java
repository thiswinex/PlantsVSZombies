package lib;

import zombies.Zombies.Z_TYPE;

public class Lib {
	Lib(){};
	public static int plants_width = 68;
	public static int zombies_width = 78;
	public static int zombies_height = 127;
	public static int frame_per_sec = 10; 
	
	public static int max_bullets_num = 20;
	public static int max_zombies_num = 10;
	public static int max_plants_num = 9;
	
	public static int transX(int pos_x) {
		int X = pos_x - 44;
		X = X/80;
		return X;
	}
	
	public static int transx(int X) {
		int x = X*80;
		return x + 84;
	}
	
	public static int transY(int pos_y) {
		if(pos_y > 83 && pos_y < 83+87) return 0;
		if(pos_y>183 && pos_y<183+87) return 1;
		if(pos_y>284 && pos_y<284+87) return 2;
		if(pos_y>380 && pos_y<380+87) return 3;
		if(pos_y>476 && pos_y<476+87) return 4;
		return -1;
	}
	
	public static Z_TYPE randomZombies() {
		int x = (int)(Math.random() * 4);
		if(x == 0) return Z_TYPE.Zombie;
		if(x == 1) return Z_TYPE.BucketheadZombie;
		if(x == 2) return Z_TYPE.FootballZombie;
		return Z_TYPE.NewspaperZombie;
	}
}
