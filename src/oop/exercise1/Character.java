package oop.exercise1;

public class Character {
	private String name;
	private int health;
	private int level;
	
	public Character() {
		name = "Unknown";
		health = 0;
		level = 0;
	}
	public Character(String name, int health, int level) {
		this.name = name;
		//Check if health between 0 to 10
		if ((health >= 0) && (health <= 10))
			this.health = health;
		else
			this.health = 0;
		//Check if level between 0 to 5
		if ((level >= 0) && (level <= 5))
			this.level = level;
		else
			this.level = 0;
	}
	public String getName() {
		return this.name;
	}
	public int getHealth() {
		return this.health;
	}
	public int getLevel() {
		return this.level;
	}
	public void levelUp() {
		if (level+1 <= 5)
			this.level++;
	}
	public void heal(int amount) {
		if (health+amount <= 10)
			health += amount;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "\nHealth: " + health + "\nLevel: " + level;
	}

}
















