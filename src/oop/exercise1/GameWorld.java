package oop.exercise1;

public class GameWorld {
	private String name;
	private Player[] players;
	private Enemy[] enemies;
	private int difficulty;
	
	public GameWorld() {
		name = "Crystalpath";
		players = new Player[10];
		enemies = new Enemy[10];
		difficulty = 1;
	}
	
	public GameWorld(String name, Player[] players, Enemy[] enemies, int difficulty) {
		this.name = name;
		if ((difficulty > 0) && (difficulty <= 3))
			this.difficulty = difficulty;
		else
			this.difficulty = 1;
		this.players = new Player[players.length];
		for (int i = 0; i < players.length; i++)
			this.players[i] = players[i];
		this.enemies = new Enemy[enemies.length];
		for (int i = 0; i< enemies.length; i++)
			this.enemies[i] = enemies[i];
	}
	
	public void addPlayer(Player player) {
		int index = -1;
		// Looking for empty slot
		for (int i = 0; i < players.length; i++)
			if (players[i] == null)
				index = i;
		
		if (index == -1) { //there is no empty slot so double the length array
			Player[] temp = new Player[players.length*2];
			for (int i = 0; i< players.length; i++)
				temp[i] = players[i];
			index = players.length;
			players = temp;
		}
		
		players[index] = player;
	}
	
	public void printAllPlayers() {
		String result = "";
		int counter = 1;
		for (int i = 0; i < players.length; i++)
			if (players[i] != null)
				result += "------------- Player " + counter++ + "-------------\n" +
			players[i].toString() + "\n\n\n";
		System.out.println(result);
	}
	public int getTotalValueOfWorld() {
		int totalValue = 0;
		for (int i = 0; i < players.length; i++)
			if (players[i] != null)
				totalValue += players[i].calculateInventoryValue();
		return totalValue;
	}
	public Player[] getPlayers() {
		return players;
	}
	public Enemy[] getEnemies() {
		return enemies;
	}
	@Override
	public String toString() {
		int numberOfPlayers = 0;
		for (int i = 0; i < players.length; i ++)
			if (players[i] != null)
				numberOfPlayers++;
		return "World Name: " + name + "\nDifficulty: " + difficulty +
				"\nNumber of players: " + numberOfPlayers;
	}

}

















