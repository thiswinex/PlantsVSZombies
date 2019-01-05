package zombies;

public class Zombie extends Zombies{
	public Zombie(int x, int y) {
		type = Z_TYPE.Zombie;
		HP = 100;
		atk = 10;
		counter = 0;
		interval = 10;
		x_pos = x;
		y_pos = y;
		speed = 2;
	}
}
