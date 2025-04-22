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
	Monster[] allMonsters = null;
	boolean isGameStarted = false;

	public void run() {
		this.printWelcomeMessage();

		while (true) {
			String inputString = scanner.nextLine().trim();

			if (inputString.equalsIgnoreCase("exit")) {
				this.printExitMessage();
				break;
			}

			if (!isGameStarted) {
				if (inputString.equalsIgnoreCase("start")) {
					this.startGame();
				} else {
					System.out.println("⚠️ 존재하지 않는 명령어입니다. (start 또는 exit 입력 가능)");
				}
				continue;
			}

			String region = Converter.convertInputToRegion(inputString);

			if (region == null) {
				System.out.println("⚠️ 잘못된 입력입니다.");
				System.out.println("📍 어디로 가겠습니까? 1.산  2.바다  3.학교 (종료는 exit)");
				continue;
			}
			System.out.println("🧭 선택된 장소: " + region);
			HabitatService.exploreRegion(region); // 지역별 탐험
			System.out.println("📍 어디로 가겠습니까? 1.산  2.바다  3.학교 (종료는 exit)");

		}
	}

	private void startGame() {
		this.allMonsters = MonsterData.getInitialMonsters();
		this.isGameStarted = true;
		System.out.println("\n## 게임 시작!");
		System.out.println("🔥 몬스터 초기화 완료 (" + allMonsters.length + " 마리 등장)");
		System.out.println("📍 어디로 가겠습니까? 1.산  2.바다  3.학교 (종료는 exit)");
	}

	private void printWelcomeMessage() {
		System.out.println("--------------------------------");
		System.out.println("📝 명령어 예시:");
		System.out.println("  start         → 게임 시작");
		System.out.println("  exit          → 프로그램 종료");
		System.out.println("--------------------------------");
	}

	private void printExitMessage() {
		System.out.println();
		System.out.println("🌟==============================🌟");
		System.out.println("   게임 종료! 다음에 또 만나요 😊");
		System.out.println("🌟==============================🌟\n");
	}

}
