//Yarin Rozilyo, 206519928 | Atawna Belal, 326309770 
package oop.exercise1;

public class Player extends Character {
	private Item[] inventory;
	
	public Player(String name, int health, int level) {
		super(name,health,level);
		inventory = new Item[5];
	}
	public Player(String name, int health, int level, Item[] inventory) {
		super(name,health,level);
		if (inventory.length > 0)
			this.inventory = new Item[inventory.length];
		else
			this.inventory = new Item[1];
		//Deep copy
		for (int i = 0 ; i < inventory.length; i++) {
			this.inventory[i] = inventory[i];
		}
	}
	public void addItem(Item item) {
		int index = -1;
		//Looking for empty slot
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] == null) {
				index = i;
				break;
			}
		}
		//Double the array length if is full
		if (index == -1) {
			Item[] temp = new Item[inventory.length*2];
			for (int i = 0; i < inventory.length; i++) {
				temp[i] = inventory[i];
			}
			index = inventory.length;
			inventory = temp;
		}
		//Add the item
		inventory[index] = item;
	}
	public int calculateInventoryValue() {
		int result = 0;
		for (int i = 0; i < inventory.length; i++ ) {
			if (inventory[i] != null)
				result += inventory[i].getValue();
		}
		return result;
	}
	public boolean hasMagicalItem() {
		for (int i = 0; i < inventory.length; i++ ) {
			if (inventory[i] != null)
				if (inventory[i].isMagical())
					return true;
		}
		return false;
	}
	@Override
	public String toString() {
	    java.util.StringJoiner names = new java.util.StringJoiner(" | ");
	    names.setEmptyValue("empty");

	    for (Item item : inventory) {
	        if (item != null) {
	            names.add(item.getName());
	        }
	    }

	    return super.toString() + "\nInventory: " + names;
	}
}



















