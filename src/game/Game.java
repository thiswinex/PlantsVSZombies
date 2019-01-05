package game;

import plants.Plants.P_TYPE;
import zombies.Zombies.Z_TYPE;
import lib.*;

public class Game {
	public Line[] line = new Line[5];
	public int sunlight_point;
	private int counter;
	private int frames;
	private int interval = 20 * Lib.frame_per_sec; // 20s
	public boolean isLosed = false;
	
	public Game() {
		for(int i=0;i<5;i++) line[i] = new Line();
		counter = 0;
		frames = 0;
		sunlight_point = 200;
	}
	
	public void checkPerFrame() {
		for(int i=0;i<5;i++) {
			line[i].checkPerFrame();
			if(line[i].findLeaderZombie() != null)
				if(line[i].findLeaderZombie().get_x() < -Lib.zombies_width) {
					isLosed = true;
				}
		}
		counter++;
		frames++;
		produceZombies();
	}
	
	public void produceZombies() {
		if(counter >= interval / (Math.log1p((double)(frames) / 100.0))) {
			counter -= interval;
			newZombies((int)(Math.random() * 5), Lib.randomZombies());
		}
	}
	
	public void newZombies(int y, Z_TYPE type) {
		line[y].newZombies(type);
	}
	
	public void newPlants(int x, int y, P_TYPE type) {
		if(line[y].newPlants(type, x)) {
			this.sunlight_point -= line[y].getPlant(x).get_price();
		}
	}
	
	public void removePlants(int x, int y) {
		line[y].removePlants(x);
	}
}
