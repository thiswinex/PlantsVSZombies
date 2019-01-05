package zombies;

public class FootballZombie extends Zombies{
	public FootballZombie(int x, int y) {
		type = Z_TYPE.FootballZombie;
		HP = 250;
		atk = 15;
		counter = 0;
		interval = 10;
		x_pos = x;
		y_pos = y;
		speed = 3;
	}
}
