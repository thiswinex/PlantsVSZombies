package zombies;


public class BucketheadZombie extends Zombies{
	public BucketheadZombie(int x, int y) {
		type = Z_TYPE.BucketheadZombie;
		HP = 200;
		atk = 10;
		counter = 0;
		interval = 10;
		x_pos = x;
		y_pos = y;
		speed = 2;
	}
}
