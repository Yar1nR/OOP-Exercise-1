package oop.exercise1;

public class Player extends Character {
	private Item[] inventory;
	
	public Player(String name, int health, int level) {
		super(name,health,level);
		inventory = new Item[5];
	}
	public Player(String name, int health, int level, Item[] inventory) {
		super(name,health,level);
		this.inventory = new Item[inventory.length];
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
		String result = super.toString() + "\nInventory: ";
		boolean isEmpty = true;
		
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] != null) {
				result += inventory[i].getName() + "|";
				isEmpty = false;
			}
		}
		
		if (isEmpty)
			result += "empty";
		
		//Delete "|" from the end
		if (result.endsWith("|"))
			result = result.substring(0,result.length()-1);
		
		return result;
	}

}



















