package game.controller;

import java.util.Scanner;

import game.context.GameContext;
import game.habitat.HabitatService;
import game.player.Player;
import game.utils.Converter;

/*
 * 전체 게임 관리 클래스
 */
public class GameController {
	Scanner scanner = new Scanner(System.in);
	GameContext gameContext;
	boolean isGameStarted = false;

	public void run() {
		this.printWelcomeMessage();

		while (true) {
			String inputString = scanner.nextLine().trim();
			// exit 입력 시 게임 종료
			if (inputString.equalsIgnoreCase("exit")) {
				this.printExitMessage();
				break;
			}
			// 게임 시작 전
			if (!isGameStarted) {
				// 게임 시작
				if (inputString.equalsIgnoreCase("start")) {
					this.startGame();
				} else {
					System.out.println("⚠️ 존재하지 않는 명령어입니다. (start 또는 exit 입력 가능)");
				}
				continue;
			}
			// 도감 보기
			if (inputString.equalsIgnoreCase("dex")) {
				this.gameContext.getPlayer()
						.viewMonsterDex(this.gameContext.getMonsterManager().getAllMonsters());
				continue;
			}
			// 몬스터 잡기
			// 몬스터 출몰지 선택
			if (inputString.toLowerCase().startsWith("go ")) {
				String regionName = inputString.substring(3).trim();
				String region = Converter.convertInputToRegion(regionName);

				if (region == null) {
					System.out.println("⚠️ 잘못된 탐험지 입니다. (go 1 / go 2 / go 3)");
					continue;
				}
				System.out.println("🧭 선택된 장소: " + region);
				HabitatService.exploreRegion(scanner, region, this.gameContext); // 지역별 탐험
				System.out.println("📍 어디로 가겠습니까? 1.산  2.바다  3.학교 (종료는 exit)");
			}
		}
	}

	private void startGame() {
		// Monster[] allMonsters = MonsterData.getInitialMonsters();
		Player player = new Player();
		this.gameContext = new GameContext(player);
		this.isGameStarted = true;
		this.printStartGuide();
	}

	private void printWelcomeMessage() {
		System.out.println("--------------------------------");
		System.out.println("📝 명령어 예시:");
		System.out.println("  start         → 게임 시작");
		System.out.println("  exit          → 프로그램 종료");
		System.out.println("--------------------------------");
	}

	private void printStartGuide() {
		System.out.println("\n## 게임 시작!");
		System.out.println("🔥 몬스터 초기화 완료 ("
				+ gameContext.getMonsterManager().getAllMonsters().length + " 마리 등장)");
		System.out.println("📌 명령어 예시:");
		System.out.println("  dex        → 몬스터 도감 보기");
		System.out.println("  go 1       → 산으로 탐험 가기");
		System.out.println("  go 2       → 바다로 탐험 가기");
		System.out.println("  go 3       → 학교로 탐험 가기");
		System.out.println("  exit       → 게임 종료");
	}

	private void printExitMessage() {
		System.out.println();
		System.out.println("🌟==============================🌟");
		System.out.println("   게임 종료! 다음에 또 만나요 😊");
		System.out.println("🌟==============================🌟\n");
	}

}
