package game.habitat;

import java.util.Scanner;

import game.context.GameContext;
import game.monster.Monster;
import game.monster.MonsterManager;

public class HabitatService {

	public static void exploreRegion(Scanner scanner, String region, GameContext gameContext) {
		Monster[] uncapturedMonstersByRegion = gameContext.getMonsterManager().getUncapturedMonstersByRegion(region);
		if (uncapturedMonstersByRegion.length == 0) {
			System.out.println("⚠️ 이 지역에서 더 이상 잡을 수 있는 몬스터가 없습니다.");
			return;
		}

		System.out.println("💡 행동을 선택하세요: 1.잡기  2.때리기  3.휴식  0.지역 선택으로 돌아가기");
		String action = scanner.nextLine().trim();
		Monster target = MonsterManager.getRandomMonster(uncapturedMonstersByRegion);

		switch (action) {
			case "1":
				gameContext.getPlayer().attackMonster(target);
				break;
			case "2":
				gameContext.getPlayer().hitMonster(target);
				break;
			case "3":
				gameContext.getPlayer().rest();
				break;
			case "0":
				return;
			default:
				System.out.println("⚠️ 올바른 입력이 아닙니다.");
		}

		// 이미 잡혔다면 종료
		if (target.isCaptured()) {
			System.out.println("🎉 몬스터를 잡았습니다! 지역 탐험을 종료합니다.");
		}

	}

	private static void exploreMountain(String region, GameContext gameContext) {
		System.out.println("⛰️ 산에 들어섰습니다. 거대한 바위 몬스터가 출몰합니다!");

		// MountainMonster monster = new MountainMonster(...);
		// monster.describe();
	}

	private static void exploreSea(GameContext gameContext) {
		System.out.println("🌊 바다에 도착했습니다. 깊은 곳에서 몬스터가 솟아오릅니다!");
		// SeaMonster monster = new SeaMonster(...);
		// monster.describe();
	}

	private static void exploreSchool(GameContext gameContext) {
		System.out.println("🏫 학교 안으로 들어갑니다. 의외의 장소에서 몬스터가 나타납니다!");
		// SchoolMonster monster = new SchoolMonster(...);
		// monster.describe();
	}
}
