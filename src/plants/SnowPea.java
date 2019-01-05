package plants;

import plants.Plants;

public class SnowPea extends Plants{
	public SnowPea(int X, int y) {
		type = P_TYPE.SnowPea;
		HP = 80;
		atk = 10;
		counter = 0;
		interval = 15;
		cooldown = 50;
		price = 175;
		this.x = X;
		this.y = y;
	}
	
}
