package zombies;

public class NewspaperZombie extends Zombies{
	public NewspaperZombie(int x, int y) {
		type = Z_TYPE.NewspaperZombie;
		HP = 150;
		atk = 20;
		counter = 0;
		interval = 10;
		x_pos = x;
		y_pos = y;
		speed = 3;
	}

}
