package game.monster;

public class MonsterRepository {
	private Monster[] allMonsters;

	public MonsterRepository() {
		this.allMonsters = MonsterData.getInitialMonsters();
	}

	public void printAllMonsters() {
		for (int i = 0; i < allMonsters.length; i++) {
			allMonsters[i].printMonster();
		}
	}

}
