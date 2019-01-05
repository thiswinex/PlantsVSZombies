package plants;

import plants.Plants;

public class PeaShooter extends Plants{
	public PeaShooter(int X, int y) {
		type = P_TYPE.PeaShooter;
		HP = 80;
		atk = 10;
		counter = 0;
		interval = 15;
		cooldown = 50;
		price = 100;
		this.x = X;
		this.y = y;
	}
	
}
