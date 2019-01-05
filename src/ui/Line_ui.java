package ui;

import javax.swing.*;

import plants.Plants.P_TYPE;
import lib.*;
import zombies.Zombies.Z_TYPE;

public class Line_ui extends JPanel{
	public Line_ui(int Y) {
		this.Y = Y;
		this.setOpaque(false);
		this.setLayout(null);
		
		//TODO other plant
	}
	
	public Plants_ui[] plants = new Plants_ui[Lib.max_plants_num];
	public JLabel[] bullets = new JLabel[Lib.max_bullets_num];
	public Zombies_ui[] zombies = new Zombies_ui[Lib.max_zombies_num];
	public Sun[] suns = new Sun[10];
	
	public int Y;
	
	public void newPlants(P_TYPE type, int X) {
		if(type == P_TYPE.PeaShooter) {
			plants[X] = new PeaShooter_ui(80*X, 0);
		}
		if(type == P_TYPE.SnowPea) {
			plants[X] = new SnowPea_ui(80*X, 0);
		}
		if(type == P_TYPE.SunFlower) {
			plants[X] = new SunFlower_ui(80*X, 0);
		}
		if(type == P_TYPE.WallNut) {
			plants[X] = new WallNut_ui(80*X, 0);
		}
		plants[X].setLocation(80*X, 40);
		plants[X].setSize(68, 88);
		this.add(plants[X]);
	}
	
	public void newZombies(Z_TYPE type, int X) {  // X stands for the index
		if(type == Z_TYPE.Zombie) {
			zombies[X] = new Zombie_ui(800, 0);
		}
		if(type == Z_TYPE.BucketheadZombie) {
			zombies[X] = new BucketheadZombie_ui(800, 0);
		}
		if(type == Z_TYPE.FootballZombie) {
			zombies[X] = new FootballZombie_ui(800, 0);
		}
		if(type == Z_TYPE.NewspaperZombie) {
			zombies[X] = new NewspaperZombie_ui(800, 0);
		}
		zombies[X].setLocation(800, 0);
		zombies[X].setSize(Lib.zombies_width, Lib.zombies_height);
		this.add(zombies[X]);
	}
	
	public void newSunlight(int X) {
		suns[X] = new Sun();
		suns[X].setLocation(plants[X].getX()+50, plants[X].getY());
		suns[X].setSize(78, 78);
		this.add(suns[X]);
	}
	
	public void newBullets(boolean ifFroze, int X, int x) { // X stands for the index
		if(ifFroze) {
			bullets[X] = new JLabel(Resource.frozebullet_png);
		}
		if(!ifFroze) {
			bullets[X] = new JLabel(Resource.peabullet_png);
		}
		bullets[X].setLocation(x, 50);
		bullets[X].setSize(26, 26);
		this.add(bullets[X]);
	}
}
