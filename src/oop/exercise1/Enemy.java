//Yarin Rozilyo, 206519928 | Atawna Belal, 326309770 
package oop.exercise1;

public class Enemy extends Character {
	private int damage;
	
	public Enemy(String name, int health, int level, int damage) {
		super(name, health, level);
		if (damage < 1 || damage > 5)
			this.damage = 0;
		else
			this.damage = damage;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nDamage: " + damage;
	}
}
