package game.monster;

import java.util.Random;

public class MonsterManager {
	private Monster[] allMonsters;

	public MonsterManager() {
		this.allMonsters = MonsterData.getInitialMonsters(); // 초기 몬스터 배열 받아서 저장. 게임 시작되면 가능한 몬스터들 준비하는 단게
	}

	public Monster[] getAllMonsters() {
		return allMonsters; // 몬스터 조회
	}

	public Monster[] getUncapturedMonstersByRegion(String region) { // 해당 지역 몬스터만 불러내기
		// 임시 배열은 최대 크기를 전체 몬스터 수로 설정
		Monster[] tempArray = new Monster[this.allMonsters.length];
		int count = 0; // 조건에 맞는 몬스터 수를 셈

		for (int i = 0; i < this.allMonsters.length; i++) {
			Monster m = this.allMonsters[i];
			if (!m.isCaptured() && m.getHabitat().equals(region)) {
				tempArray[count] = m;
				count++;
			}
		}
		// 실제 크기만큼 새 배열 생성 후 복사
		Monster[] resultList = new Monster[count];
		for (int i = 0; i < count; i++) {
			resultList[i] = tempArray[i];
		}

		return resultList;
	}

	// 몬스터 목록 출력. 그 목록을 출력하는 메서드 - 함수에
	public static void showMonstersByRegion(Monster[] allMonsters) {
		for (int i = 0; i < allMonsters.length; i++) { // i 가 인덱스지
			allMonsters[i].printMonster();
		}
		System.out.println("----------------------------------------------------------------------------------------");
	}

	// public static

	public Monster getRandomMonster(Monster[] monsters) {
		if (monsters == null || monsters.length == 0) {
			throw new IllegalArgumentException("선택 가능한 몬스터가 없습니다.");
		}
		Random r = new Random();
		int index = r.nextInt(monsters.length); // 0 ~ monsters.length - 1
		return monsters[index];
	}
}
