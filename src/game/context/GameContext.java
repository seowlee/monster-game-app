package game.context;

import game.monster.MonsterManager;
import game.player.Player;

public class GameContext {
	private Player player;
	private MonsterManager monsterManager;

	public GameContext() {
		this.player = new Player();
		this.monsterManager = new MonsterManager();
	}

	public Player getPlayer() {
		return player;
	}

	public MonsterManager getMonsterManager() {
		return monsterManager;
	}

}
