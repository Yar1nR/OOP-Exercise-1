package oop.exercise1;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Item sword = new Item("Sword",2,true);
		Item bow = new Item("Bow",4,false);
		Item rock = new Item("Rock",4,true);
		
		Player player1 = new Player("Dani", 10, 2);
		player1.addItem(rock);
		player1.addItem(sword);
		
		Player player2 = new Player("Josh", 10, 1);
		player2.addItem(rock);
		player2.addItem(bow);
		
		Enemy enemy1 = new Enemy("Monster", 5,1,1);
		Enemy enemy2 = new Enemy("Alien", 5,1,2);
		
		Enemy[] enemies = new Enemy[5];
		enemies[0] = enemy1;
		enemies[1] = enemy2;
		
		Player[] players = new Player[5];
		players[0] = player1;
		players[1] = player2;
		
		GameWorld gameWorld = new GameWorld("Earth",players,enemies, 1);
		
		gameWorld.printAllPlayers();
		for (int i = 0; i<gameWorld.getPlayers().length; i++) {
			if (gameWorld.getPlayers()[i] != null)
				System.out.println(gameWorld.getPlayers()[i].getName() + ": " 
								 + gameWorld.getPlayers()[i].calculateInventoryValue());
		}
		simulateBattle(gameWorld.getPlayers()[0], gameWorld.getEnemies()[0]);
		simulateBattle(gameWorld.getPlayers()[1], gameWorld.getEnemies()[1]);
		simulateBattle(gameWorld.getPlayers()[0], gameWorld.getEnemies()[1]);
		simulateBattle(gameWorld.getPlayers()[1], gameWorld.getEnemies()[0]);
	}
	public static void simulateBattle(Player player, Enemy enemy) {
		int playerLevel = player.getLevel();
		int enemyLevel = enemy.getLevel();
		System.out.println(player.getName() + " - level:" + playerLevel + " VS "
							+ enemy.getName() + " - Level: " + enemyLevel);
		if (playerLevel > enemyLevel) {
			System.out.println(player.getName() + " wins!");
			player.levelUp();	
		}
		else if (enemyLevel > playerLevel) {
			System.out.println(enemy.getName() + " wins!");
			enemy.levelUp();
		}
		else
			System.out.println("Draw!");
	}
}
