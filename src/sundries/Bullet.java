package sundries;

public class Bullet {
	private int x_pos;
	private int speed;
	private int damage;
	public boolean isFroze;
	
	public Bullet(boolean isFroze, int x){
		this.damage = 10;
		this.isFroze = isFroze;
		this.speed = 10;
		this.x_pos = x;
	}

	public int get_x() { return x_pos; }
	public int get_damage() { return damage; }
	
	public void checkPerFrame() {
		x_pos += speed;
	}
}
