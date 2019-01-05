package zombies;

public abstract class Zombies {
	public enum Z_TYPE{
		Zombie,
		FootballZombie,
		NewspaperZombie,
		BucketheadZombie
	}
	
	protected Z_TYPE type;
	public int HP;
	public int atk;
	public boolean isAttacking;
	public boolean isFrozed = false;
	public boolean isReadyAtk;
	public int froze_time;
	public boolean isDead;
	public int interval;
	public int counter;
	protected int x_pos;
	protected int y_pos;
	public int speed;
	
	public Zombies() {}
	
	public void checkPerFrame() {
		if(isAttacking)
			counter++;
		if(counter >= interval) {
			counter -= interval;
			isReadyAtk = true;
		}
		
		if(!isAttacking) {
			if(!isFrozed)
				x_pos -= speed;
			else 
				x_pos -= speed/2;
		}
		if(isFrozed) {
			froze_time--;
			if(froze_time==0) isFrozed = false;
		}
	}
	
	public int get_x() {
		return this.x_pos;
	}
	
	public Z_TYPE get_type() {
		return this.type;
	}
	
	public void startAtk() {
		isAttacking = true;
	}
	
	public void endAtk() {
		isAttacking = false;
		isReadyAtk = false;
		counter = 0;
	}
	
	public void underAttack(int damage, boolean froze) {
		this.HP -= damage;
		if(this.HP < 0) deathCount();
		if(froze) {
			froze_time = 100;
			isFrozed = true;
		}
	}
	
	public void deathCount() {
		isDead = true;
	}
}
