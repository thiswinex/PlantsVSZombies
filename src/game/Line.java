package game;

import plants.*;
import zombies.*;
import zombies.Zombies.Z_TYPE;
import sundries.*;
import plants.Plants;
import plants.Plants.P_TYPE;
import lib.*;

public class Line {
	private int y_pos;
	public Plants[] plants = new Plants[Lib.max_plants_num];
	public Bullet[] bullets = new Bullet[Lib.max_bullets_num];
	public Zombies[] zombies = new Zombies[10];
	private Zombies leader_zombie;
	private Bullet leader_bullet;
	
	public Line() {
		
	}
	
	public Zombies findLeaderZombie() {
		int min_x = 999;
		int min_index = -1;
		for(int i=0;i<Lib.max_zombies_num;i++) {
			if(zombies[i] != null) {
				if(zombies[i].get_x() < min_x) {
					min_x = zombies[i].get_x();
					min_index= i;
				}
			}
		}
		if(min_index != -1) {
		}
		else this.leader_zombie = null;
		return leader_zombie;
	}
	
	public Bullet findLeaderBullet() {
		int max_x = -999;
		int max_index = -1;
		for(int i=0;i<Lib.max_bullets_num;i++) {
			if(bullets[i].get_x() > max_x) {
				max_x = bullets[i].get_x();
				max_index = i;
			}
		}
		if(max_index != -1) {
		}
		else this.leader_zombie = null;
		return leader_bullet;
	}
	
	public int findZombieVacancy() {
		for(int i=0;i<Lib.max_zombies_num;i++) {
			if(zombies[i] == null) {
				return i;
			}
		}
		return -2;
	}
	
	public int findBulletVacancy() {
		for(int i=0;i<Lib.max_bullets_num;i++) {
			if(bullets[i] == null) {
				return i;
			}
		}
		return -2;
	}
	
	public boolean isZombiesFull() {
		if(findZombieVacancy() == -2) return true;
		else return false;
	}
	
	public void newZombies(Z_TYPE type) {
		if(!isZombiesFull()) {
			if(type == Z_TYPE.Zombie)
				zombies[findZombieVacancy()] = new Zombie(800, y_pos*100);
			if(type == Z_TYPE.NewspaperZombie)
				zombies[findZombieVacancy()] = new NewspaperZombie(800, y_pos*100);
			if(type == Z_TYPE.FootballZombie)
				zombies[findZombieVacancy()] = new FootballZombie(800, y_pos*100);
			if(type == Z_TYPE.BucketheadZombie)
				zombies[findZombieVacancy()] = new BucketheadZombie(800, y_pos*100);
		}
	}
	
	public boolean newPlants(P_TYPE type, int X) {
		if(plants[X] != null) {
			return false;
		}
		if(type == P_TYPE.PeaShooter)
			plants[X] = new PeaShooter(X, y_pos*100);
		if(type == P_TYPE.SnowPea)
			plants[X] = new SnowPea(X, y_pos*100);
		if(type == P_TYPE.WallNut)
			plants[X] = new WallNut(X, y_pos*100);
		if(type == P_TYPE.SunFlower)
			plants[X] = new SunFlower(X, y_pos*100);
		return true;
	}
	
	public void removePlants(int X) {
		if(plants[X] != null)
			plants[X] = null;
	}
	
	public void checkPerFrame() {
		for(int i=0;i<9;i++) {
			if(plants[i] != null) {
				plants[i].checkPerFrame();
				if(plants[i].isReadyAct()) {
					if(plants[i].get_type() == P_TYPE.PeaShooter) {
						for(int j=0;j<10;j++) {
							if(zombies[j] != null) {
								if(zombies[j].get_x() >= plants[i].get_x()*80){
									bullets[findBulletVacancy()] = new Bullet(false, plants[i].get_x()*80);
									plants[i].toAct();
									Resource.playSound(Resource.firepea_sound);
								}
							}
						}
					}
					if(plants[i].get_type() == P_TYPE.SnowPea) {
						for(int j=0;j<10;j++) {
							if(zombies[j] != null) {
								if(zombies[j].get_x() >= plants[i].get_x()*80){
									bullets[findBulletVacancy()] = new Bullet(true, plants[i].get_x()*80);
									plants[i].toAct();
									Resource.playSound(Resource.firepea_sound);
								}
							}
						}
					}
					if(plants[i].get_type() == P_TYPE.SunFlower) {
						plants[i].isHaveSun = true;
						//plants[i].toAct();
					}
				}
			}
		}
		
		// cal attack
		
		// plants under attack
		for(int i=8;i>=0;i--) {
			for(int j=0;j<10;j++) {
				if(zombies[j] != null && plants[i] != null) {
					// zombies start attacking plants
					if(zombies[j].get_x() <= plants[i].get_x()*80 + Lib.plants_width &&
							zombies[j].get_x() >= plants[i].get_x()*80) {
						zombies[j].startAtk();
						if(zombies[j].isReadyAtk) {
							plants[i].underAttack(zombies[j].atk);
							Resource.playSound(Resource.chomp_sound);
							zombies[j].isReadyAtk = false;
						}
					}
				}
			}
			
			for(int j=0;j<10;j++) {
				if(zombies[j] != null && plants[i] != null) {
				// zombies stop attacking plants
				if(plants[i].isDead) zombies[j].endAtk();
				}
			}
			if(plants[i] != null) {
				// plants death count
				if(plants[i].isDead) {
					plants[i] = null;
				}
			}
		}
		
		// zombies under attack
		for(int i=0;i<Lib.max_bullets_num;i++) {
			if(bullets[i] != null) {
				bullets[i].checkPerFrame();
				for(int j=0;j<10;j++) {
					if(zombies[j] != null && bullets[i] != null) {
						if(bullets[i].get_x() > zombies[j].get_x() &&
								bullets[i].get_x() < zombies[j].get_x() + Lib.zombies_width) {
							zombies[j].underAttack(bullets[i].get_damage(), bullets[i].isFroze);
							bullets[i] = null;
							Resource.playSound(Resource.bleep_sound);
						}
					}
				}
			}
		}
		for(int i=0;i<10;i++) {
			if(zombies[i] != null) {
				zombies[i].checkPerFrame();
				if(zombies[i].isDead) {
					zombies[i] = null;
				}
			}
		}
		
		
	}
	
	public void calAttack() {
		
	}
	
	public Plants getPlant(int x) {
		return plants[x];
	}
	
}
