package lib;

import javax.swing.*;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Resource {
	public Resource() throws MalformedURLException{
		plant_sound = (new File("resource/audio/plant1.wav")).toURI().toURL();
		bleep_sound = (new File("resource/audio/bleep.wav")).toURI().toURL();
		chomp_sound = (new File("resource/audio/chomp.wav")).toURI().toURL();
		firepea_sound = (new File("resource/audio/firepea.wav")).toURI().toURL();
		groan1_sound = (new File("resource/audio/groan1.wav")).toURI().toURL();
		groan2_sound = (new File("resource/audio/groan2.wav")).toURI().toURL();
		groan3_sound = (new File("resource/audio/groan3.wav")).toURI().toURL();
		shovel_sound = (new File("resource/audio/shovel.wav")).toURI().toURL();
		scream_sound = (new File("resource/audio/scream.wav")).toURI().toURL();
	};
	
	public static ImageIcon sun_gif = new ImageIcon("resource/images/interface/Sun.gif");
	public static ImageIcon shovel_png = new ImageIcon("resource/images/interface/Shovel.png");
	public static ImageIcon shove_png = new ImageIcon("resource/images/interface/shove.png");
	
	public static ImageIcon card_norbeen = new ImageIcon("resource/images/Card/Plants/card_norbeen_on.jpg");
	public static ImageIcon card_icebeen = new ImageIcon("resource/images/Card/Plants/card_icebeen_on.jpg");
	public static ImageIcon card_potato = new ImageIcon("resource/images/Card/Plants/potato_on.jpg");
	public static ImageIcon card_sunflower = new ImageIcon("resource/images/Card/Plants/sunflower_on.jpg");
	
	public static ImageIcon peashooter_gif = new ImageIcon("resource/images/Plants/Peashooter/Peashooter.gif");
	public static ImageIcon peashooter_png = new ImageIcon("resource/images/Plants/Peashooter/0.gif");
	public static ImageIcon snowpea_gif = new ImageIcon("resource/images/Plants/SnowPea/SnowPea.gif");
	public static ImageIcon snowpea_png = new ImageIcon("resource/images/Plants/SnowPea/0.gif");
	public static ImageIcon sunflower_gif = new ImageIcon("resource/images/Plants/SunFlower/SunFlower1.gif");
	public static ImageIcon sunflower_png = new ImageIcon("resource/images/Plants/SunFlower/0.gif");
	public static ImageIcon wallnut_gif = new ImageIcon("resource/images/Plants/WallNut/WallNut.gif");
	public static ImageIcon wallnut_png = new ImageIcon("resource/images/Plants/WallNut/0.gif");
	
	public static ImageIcon zombie_atk = new ImageIcon("resource/images/Zombies/Zombie/ZombieAttack.gif");
	public static ImageIcon zombie_walk = new ImageIcon("resource/images/Zombies/Zombie/Zombie.gif");
	public static ImageIcon bucketheadzombie_walk = new ImageIcon("resource/images/Zombies/BucketheadZombie/BucketheadZombie.gif");
	public static ImageIcon bucketheadzombie_atk = new ImageIcon("resource/images/Zombies/BucketheadZombie/BucketheadZombieAttack.gif");
	public static ImageIcon footballzombie_atk = new ImageIcon("resource/images/Zombies/FootballZombie/FootballZombieAttack.gif");
	public static ImageIcon footballzombie_walk = new ImageIcon("resource/images/Zombies/FootballZombie/FootballZombie.gif");
	public static ImageIcon newspaperzombie_atk = new ImageIcon("resource/images/Zombies/NewspaperZombie/HeadAttack1.gif");
	public static ImageIcon newspaperzombie_walk = new ImageIcon("resource/images/Zombies/NewspaperZombie/HeadWalk1.gif");
	
	public static ImageIcon peabullet_png = new ImageIcon("resource/images/Plants/PB011.png");
	public static ImageIcon frozebullet_png = new ImageIcon("resource/images/Plants/PB-101.png");
	public static ImageIcon bullethit_png = new ImageIcon("resource/images/Plants/PeaBulletHit.png");
	
	public static ImageIcon lose_png = new ImageIcon("resource/images/interface/ZombiesWon.png");
	
	public static URL plant_sound;
	public static URL bleep_sound;
	public static URL chomp_sound;
	public static URL firepea_sound;
	public static URL groan1_sound;
	public static URL groan2_sound;
	public static URL groan3_sound;
	public static URL shovel_sound;
	public static URL scream_sound;
	
	
	public static AudioClip audio;
	public static void playSound(URL url) {
		audio = Applet.newAudioClip(url);
		audio.play();
	}
}
