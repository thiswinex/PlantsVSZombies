package ui;

import javax.swing.*;

import plants.Plants.P_TYPE;

import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import game.*;
import lib.*;
import java.util.Timer;
import java.util.TimerTask;

import zombies.Zombies.Z_TYPE;

public class Field extends JPanel{
	public Field() {
		this.background_image = (new ImageIcon("resource/images/interface/background1.jpg")).getImage();
		this.setOpaque(true);
		this.setLayout(null);
		
		line[0] = new Line_ui(83);
		line[0].setLocation(44, 43);
		line[0].setSize(900, 127); // 87
		this.add(line[0]);
		
		line[1] = new Line_ui(183);
		line[1].setLocation(44, 143);
		line[1].setSize(900, 127);
		this.add(line[1]);
		
		line[2] = new Line_ui(284);
		line[2].setLocation(44, 244);
		line[2].setSize(900, 127);
		this.add(line[2]);
		
		line[3] = new Line_ui(380);
		line[3].setLocation(44, 340);
		line[3].setSize(900, 127);
		this.add(line[3]);
		
		line[4] = new Line_ui(476);
		line[4].setLocation(44, 436);
		line[4].setSize(900, 127);
		this.add(line[4]);
		
		bank.setLocation(193,0);
		bank.sunlight.setText(String.valueOf(game.sunlight_point));
		plants.setLocation(0, 0);
		this.add(bank);
		
		loseSign.setLocation(100, 100);
		loseSign.setSize(498, 439);
		this.add(loseSign);
		loseSign.setVisible(false);
		
		this.addMouseListener(listener_f1);
		this.addMouseMotionListener(listener_f2);
		bank.addMouseListener(listener_b1);
		
		// run the init function of class Resource
		try {
			Resource resource = new Resource();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	Image background_image;
	Line_ui[] line = new Line_ui[5];
	SeedBank bank = new SeedBank();
	JLabel loseSign = new JLabel(Resource.lose_png);
	
	// game logic
	Game game = new Game();
	Timer timer = new Timer();
	boolean isPaused = false;
	
	
	public void checkPerFrame() throws MalformedURLException {
		game.checkPerFrame();
		bank.sunlight.setText(String.valueOf(game.sunlight_point));
		if(game.isLosed == true) {
			Resource.playSound(Resource.scream_sound);
			timer.cancel();
			isPaused = false;
			loseSign.setVisible(true);
			
			return;
		}
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<Lib.max_plants_num;j++) {
				
				// if plants[j] in game and in UI are different, refresh:
				if(game.line[i].plants[j] != null && line[i].plants[j] == null) {
					line[i].newPlants(game.line[i].plants[j].get_type(), j);
					Resource.playSound(Resource.plant_sound);
				}
				if(game.line[i].plants[j] == null && line[i].plants[j] != null) {
					line[i].remove(line[i].plants[j]);
					line[i].plants[j] = null;
				}
				
				// sunflower
				if(game.line[i].plants[j] != null) {
					if(game.line[i].plants[j].isHaveSun == true && line[i].suns[j] == null) {
						line[i].newSunlight(j);
					}
					if(game.line[i].plants[j].isHaveSun == false && line[i].suns[j] != null) {
						line[i].remove(line[i].suns[j]);
						line[i].suns[j] = null;
					}
				}
				if(game.line[i].plants[j] == null && line[i].suns[j] != null) {
					line[i].remove(line[i].suns[j]);
					line[i].suns[j] = null;
				}
				
			}
			for(int j=0;j<Lib.max_zombies_num;j++) {
				
				// if zombies[j] in game and in UI are different, refresh:
 				if(game.line[i].zombies[j] != null && line[i].zombies[j] == null) {
					line[i].newZombies(game.line[i].zombies[j].get_type(), j);
					if(j % 3 == 0)
						Resource.playSound(Resource.groan1_sound);
					if(j % 3 == 1)
						Resource.playSound(Resource.groan2_sound);
					if(j % 3 == 2)
						Resource.playSound(Resource.groan3_sound);
				}
				if(game.line[i].zombies[j] == null && line[i].zombies[j] != null) {
					line[i].remove(line[i].zombies[j]);
					line[i].zombies[j] = null;
				}
				
				if(game.line[i].zombies[j] != null) {
					// change icon for attacking
					if(game.line[i].zombies[j].isAttacking) {
						if(game.line[i].zombies[j].get_type() == Z_TYPE.Zombie)
							line[i].zombies[j].setIcon(Resource.zombie_atk);
						if(game.line[i].zombies[j].get_type() == Z_TYPE.BucketheadZombie)
							line[i].zombies[j].setIcon(Resource.bucketheadzombie_atk);
						if(game.line[i].zombies[j].get_type() == Z_TYPE.NewspaperZombie)
							line[i].zombies[j].setIcon(Resource.newspaperzombie_atk);
						if(game.line[i].zombies[j].get_type() == Z_TYPE.FootballZombie)
							line[i].zombies[j].setIcon(Resource.footballzombie_atk);
					}
					else {
						if(game.line[i].zombies[j].get_type() == Z_TYPE.Zombie)
							line[i].zombies[j].setIcon(Resource.zombie_walk);
						if(game.line[i].zombies[j].get_type() == Z_TYPE.BucketheadZombie)
							line[i].zombies[j].setIcon(Resource.bucketheadzombie_walk);
						if(game.line[i].zombies[j].get_type() == Z_TYPE.NewspaperZombie)
							line[i].zombies[j].setIcon(Resource.newspaperzombie_walk);
						if(game.line[i].zombies[j].get_type() == Z_TYPE.FootballZombie)
							line[i].zombies[j].setIcon(Resource.footballzombie_walk);
					}
					
					// relocate
					line[i].zombies[j].setLocation(game.line[i].zombies[j].get_x(),
												   line[i].zombies[j].x_pos);
				}
			}
			for(int j=0;j<Lib.max_bullets_num;j++) {
				if(game.line[i].bullets[j] != null && line[i].bullets[j] != null) {
					// relocate
					line[i].bullets[j].setLocation(game.line[i].bullets[j].get_x(),
												   line[i].bullets[j].getY());

					// bullet miss
					if(game.line[i].bullets[j].get_x() > 800) game.line[i].bullets[j] = null;
				}
				
				// if bullets[j] in game and in UI are different, refresh:
 				if(game.line[i].bullets[j] != null && line[i].bullets[j] == null) {
					line[i].newBullets(game.line[i].bullets[j].isFroze, j, game.line[i].bullets[j].get_x());
				}
				if(game.line[i].bullets[j] == null && line[i].bullets[j] != null) {
					line[i].remove(line[i].bullets[j]);
					line[i].bullets[j] = null;
				}
			}
		}
	}
	
	// status var
	public boolean ifClickedBank;
	public boolean ifClickedShovel;
	public P_TYPE clickType;
	public JLabel plants = new JLabel();
	private int originX;
	private int originY;
	
	mListener_field listener_f1 = new mListener_field();
	mListener_2_field listener_f2 = new mListener_2_field();
	mListener_bank listener_b1 = new mListener_bank();
	
	
	
	public void paintComponent(Graphics g){  
        super.paintComponents(g);  
        g.drawImage(background_image,0 ,0,this.getWidth(),this.getHeight(),this);
    }
	
	// timer task
	private class CheckTimer extends TimerTask{

		@Override
		public void run() {
			try {
				checkPerFrame();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void beginGame() {
		timer.schedule(new CheckTimer(), 0, 100);
	}
	
	// listener
	private class mListener_field implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON3 && ifClickedBank == true) {
				ifClickedBank = false;
				ifClickedShovel = false;
			}
			if(e.getButton() == MouseEvent.BUTTON1 && ifClickedBank == true && ifClickedShovel == false) {
				int x = e.getX();
				int y = e.getY();
				if(x>44 && x<722) {
					int X = Lib.transX(x);
					int Y = Lib.transY(y);
					if(Y != -1)
						if(game.line[Y].plants[X] == null) {
						game.line[Y].newPlants(clickType, X);
						game.sunlight_point -= game.line[Y].plants[X].price;
						if(game.sunlight_point < 0) {
							game.sunlight_point += game.line[Y].plants[X].price;
							game.line[Y].removePlants(X);
						}
					}
				}
			}
			if(e.getButton() == MouseEvent.BUTTON1 && ifClickedBank == true && ifClickedShovel == true) {
				int x = e.getX();
				int y = e.getY();
				if(x>44 && x<722) {
					int X = Lib.transX(x);
					int Y = Lib.transY(y);
					if(game.line[Y].plants[X] != null) {
						game.line[Y].removePlants(X);
						Resource.playSound(Resource.shovel_sound);
					}
				}
			}
			if(e.getButton() == MouseEvent.BUTTON1 && ifClickedBank == false) {
				int x = e.getX();
				int y = e.getY();
				if(x>44 && x<772 && y>77 && y<570) {
					int X = Lib.transX(x-50);
					int Y = Lib.transY(y);
					if(game.line[Y].plants[X] != null) {
						if(game.line[Y].plants[X].isHaveSun == true) {
							game.sunlight_point += 25;
							game.line[Y].plants[X].isHaveSun = false;
							game.line[Y].plants[X].toAct();
							line[Y].remove(line[Y].suns[X]);
							line[Y].suns[X] = null;
							line[Y].repaint();
						}
					}
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
		
	}
	
	private class mListener_bank implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON1 && ifClickedBank == false) {
				int x = e.getX();
				int y = e.getY();
				if((x>80 && y>7) && (x<80+52 && y<7+70) && (game.sunlight_point >= 100)) {
					ifClickedBank = true;
					clickType = P_TYPE.PeaShooter;
					plants.setIcon(Resource.peashooter_png);
					originX = x - 68;
					originY = y;
				}
				if((x>140 && y>7) && (x<140+52 && y<7+70) && (game.sunlight_point >= 175)) {
					ifClickedBank = true;
					clickType = P_TYPE.SnowPea;
					plants.setIcon(Resource.snowpea_png);
					originX = x - 128;
					originY = y;
				}
				if((x>200 && y>7) && (x<200+52 && y<7+70) && (game.sunlight_point >= 50)) {
					ifClickedBank = true;
					clickType = P_TYPE.SunFlower;
					plants.setIcon(Resource.sunflower_png);
					originX = x - 188;
					originY = y;
				}
				if((x>260 && y>7) && (x<260+52 && y<7+70) && (game.sunlight_point >= 50)) {
					ifClickedBank = true;
					clickType = P_TYPE.WallNut;
					plants.setIcon(Resource.wallnut_png);
					originX = x - 248;
					originY = y;
				}
				if((x>356 && y>0) && (x<356+90 && y<0+87)) {
					ifClickedBank = true;
					ifClickedShovel = true;
					plants.setIcon(Resource.shove_png);
					originX = x - 344;
					originY = y;
				}
				if((x>15 && x>13) && (x<15+48 && y<13+43)) {
					if(isPaused == false) {
						timer.cancel();
						isPaused = true;
						return;
					}
					if(isPaused == true) {
						timer = new Timer();
						timer.schedule(new CheckTimer(), 0, 100);
						isPaused = false;
						return;
					}
				}
			}
			if(e.getButton() == MouseEvent.BUTTON3 && ifClickedBank == true) {
				ifClickedBank = false;
			}
			if(e.getButton() == MouseEvent.BUTTON1 && ifClickedBank == true) {
				
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
	}
	
	private class mListener_2_field implements MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent e) {	
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			if(ifClickedBank == true) {
				int x = e.getX();
			    int y = e.getY();
			    int disX = x - originX;
			    int disY = y - originY;

			    plants.setLocation(plants.getX() + disX,
			    					   plants.getY() + disY);
			    plants.setSize(68, 88);
			    add(plants);
			   
			    originX = x;
			    originY = y;
			}
			if(ifClickedBank == false) {
				plants.setLocation(0, 0);
				remove(plants);
				repaint();
			}
		}
	}
}
