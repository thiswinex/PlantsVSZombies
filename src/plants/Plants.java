package plants;

public abstract class Plants {
	public enum P_TYPE{
		PeaShooter,
		SnowPea,
		SunFlower,
		WallNut
	}
	
	protected P_TYPE type;
	public int HP;
	public int atk;
	public int interval;
	public int cooldown;
	public int counter;
	public int price;
	public boolean isDead;
	public boolean isHaveSun = false;
	protected int x;
	protected int y;
	
	public Plants() {}
	
	public void checkPerFrame() {
		if(!isReadyAct())
			counter++;
	}
	
	public int get_x() {
		return this.x;
	}
	
	public P_TYPE get_type() {
		return this.type;
	}
	
	public int get_price() {
		return this.price;
	}
	
	public boolean isReadyAct() {
		return (counter > interval);
	}
	
	public void toAct() {
		counter -= interval;
	}
	
	public void underAttack(int damage) {
		this.HP -= damage;
		if(this.HP <= 0) this.deathCount();
	}
	
	public void deathCount() {
		isDead = true;
	}
}
