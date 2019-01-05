package plants;

import plants.Plants;

public class WallNut extends Plants{
	public WallNut(int X, int y) {
		type = P_TYPE.WallNut;
		HP = 250;
		atk = 0;
		counter = 0;
		interval = 1;
		cooldown = 5;
		price = 50;
		this.x = X;
		this.y = y;
	}

}
