//Yarin Rozilyo, 206519928 | Atawna Belal, 326309770 
package oop.exercise1;

public class Item {
	private String name;
	private int value;
	private boolean isMagical;
	
	public Item() {
		name = "Unknown";
		value = 0;
		isMagical = false;
	}
	
	public Item(String name, int value, boolean isMagical) {
		this.name = name;
		if (value > 0)
			this.value = value;
		this.isMagical = isMagical;
	}
	
	@Override
	public String toString() {
		String result = "Name: " + name + "\nValue: " + value;
		if (isMagical)
			result += "\nMagical item";
		return result;
	}
	
	public int getValue() {
		return this.value;
	}
	public void setValue(int value) {
		if (value < 0) 
			this.value = 0;
		else
			this.value = value;
	}
	
	public boolean isMagical() {
		return this.isMagical;
	}
	public String getName() {
		return this.name;
	}

}

