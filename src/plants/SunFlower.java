package plants;

import plants.Plants;

public class SunFlower extends Plants{
	public SunFlower(int X, int y) {
		type = P_TYPE.SunFlower;
		HP = 50;
		atk = 0;
		counter = 0;
		interval = 150;
		cooldown = 500;
		price = 50;
		this.x = X;
		this.y = y;
		isHaveSun = false;
	}
	
}
