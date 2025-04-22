package game.controller;

import java.util.Scanner;

import game.habitat.HabitatService;
import game.monster.Monster;
import game.monster.MonsterData;
import game.utils.Converter;

/*
 * 전체 게임 관리 클래스
 */
public class GameController {
	Scanner scanner = new Scanner(System.in);

	public void run() {
		Monster[] allMonsters = null;
		boolean isGameStarted = false;

		while (true) {
			if (!isGameStarted) {
				System.out.println("--------------------------------");
				System.out.println("📝 명령어 예시:");
				System.out.println("  start         → 게임 시작");
				System.out.println("  exit          → 프로그램 종료");
				System.out.println("--------------------------------");

				String inputString = scanner.nextLine();

				if (inputString.equalsIgnoreCase("exit")) {
					System.out.println("\n===============================");
					System.out.println("게임 종료!");
					System.out.println("===============================\n");
					break;

				} else if (inputString.equalsIgnoreCase("start")) {
					allMonsters = MonsterData.getInitialMonsters();
					isGameStarted = true;

					System.out.println("\n## 게임 시작!");
					System.out.println("🔥 몬스터 초기화 완료 (" + allMonsters.length + "마리 등장)");

				} else {
					System.out.println("⚠️ 존재하지 않는 명령어입니다.");
				}

			} else {
				System.out.println("\n어디로 가겠습니까? 1.산  2.바다  3.학교 (또는 exit)");

				String regionInput = scanner.nextLine().trim();

				if (regionInput.equalsIgnoreCase("exit")) {
					System.out.println("\n===============================");
					System.out.println("  👋 게임을 종료합니다. 수고하셨습니다!");
					System.out.println("===============================\n");
					break;
				}

				String region = Converter.convertInputToRegion(regionInput);

				if (region == null) {
					System.out.println("⚠️ 잘못된 입력입니다.");
					continue;
				}

				System.out.println("🧭 선택된 장소: " + region);

				HabitatService.exploreRegion(region); // 지역별 탐험
			}
		}
	}

}