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
		// 랜덤 몬스터 먼저 뽑고 
		Monster target = gameContext.getMonsterManager().getRandomMonster(uncapturedMonstersByRegion);

        System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("[" + region + "에서 잡을 수 있는 몬스터 목록]");
		MonsterManager.showMonstersByRegion(uncapturedMonstersByRegion);

		// 몬스터 출현 메시지 출력
		System.out.println("\"" + target.getName() + "\" 몬스터가 출현했다!");
		System.out.println();
		System.out.println("행동을 선택하세요: 1.잡기  2.공격하기  3.휴식 0.지역 선택으로 돌아가기");
		
		String action = scanner.nextLine().trim();
		System.out.println();
		System.out.println("[몬스터 상태]");
		target.printMonster();

		// TODO: player hp < 0 처리 그냥 넘기기
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



	// 영어 지역명 -> 한글로 변환 메소드
// 	private static String convertRegionToKorean(String region) {
//     switch (region) {
//         case "mountain":
//             return "산";
//         case "sea":
//             return "바다";
//         case "school":
//             return "학교";
//         default:
//             return region; // 예외 처리: 그냥 원본 리턴
//     }
// }





}
