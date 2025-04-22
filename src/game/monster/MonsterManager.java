package game.monster;

import java.util.Arrays;

public class MonsterManager {
	private Monster[] allMonsters;

	public MonsterManager() {
		this.allMonsters = MonsterData.getInitialMonsters();
	}

	public Monster[] getAllMonsters() {
		return allMonsters;
	}

	public Monster[] getUncapturedMonstersByRegion(String region) {
		Monster[] resultList = Arrays.stream(this.allMonsters)
				.filter(m -> !m.isCaptured() && m.getHabitat().equals(region)).toArray(Monster[]::new);
		for (Monster monster : resultList) {
			System.out.println(monster.getName());
		}
		return resultList;
	}

	public static Monster getRandomMonster(Monster[] uncapturedMonstersByRegion) {
		// TODO Auto-generated method stub
		return uncapturedMonstersByRegion[0];
	}

}
