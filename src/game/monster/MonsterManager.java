package game.monster;

import java.util.Arrays;
import java.util.Random;

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

	public static Monster getRandomMonster(Monster[] monsters) {
		if (monsters == null || monsters.length == 0) {
			throw new IllegalArgumentException("선택 가능한 몬스터가 없습니다.");
		}
		Random r = new Random();
		int index = r.nextInt(monsters.length); // 0 ~ monsters.length - 1
		return monsters[index];
	}
}
