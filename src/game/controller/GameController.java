package game.controller;

import java.util.*;

import game.context.GameContext;
import game.habitat.HabitatService;
import game.monster.Monster;
import game.utils.Converter;

// 전체 게임 관리 컨트롤러
public class GameController {
	Scanner scanner = new Scanner(System.in);
	GameContext gameContext;
	boolean isGameStarted = false;

	public void run() {
		this.printWelcomeMessage();

		while (true) {
			String inputString = scanner.nextLine().trim();

			if (inputString.equalsIgnoreCase("exit")) {
				this.printExitMessage();
				break;

			} else if (!isGameStarted) {
				if (inputString.equalsIgnoreCase("start")) {
					this.startGame();
					this.printInGameHelp();
				} else {
					System.out.println("⚠️ 존재하지 않는 명령어입니다. (start 또는 exit 입력 가능)");
				}

			} else if (inputString.equalsIgnoreCase("dex")) {
				this.gameContext.getPlayer()
						.viewMonsterDex(this.gameContext.getMonsterManager().getAllMonsters());
				this.printInGameHelp();

			} else if (inputString.toLowerCase().startsWith("go ")) {
				String regionName = inputString.substring(3).trim();
				String region = Converter.convertInputToRegion(regionName);

				if (region == null) {
					System.out.println("⚠️ 잘못된 탐험지 입니다. (go 1 / go 2 / go 3)");
				} else {
					System.out.println("🧭 선택된 장소: " + region);
					HabitatService.exploreRegion(scanner, region, this.gameContext);
                    if (Arrays.stream(gameContext.getMonsterManager().getAllMonsters()).allMatch(Monster::isCaptured)) {
                        playerWinMessage();
                        break;
                    }
					this.printInGameHelp();
				}
			} else {
				System.out.println("⚠️ 존재하지 않는 명령어입니다. 사용 가능한 명령어:");
				this.printInGameHelp();
			}
		}
	}

	private void startGame() {
		this.gameContext = new GameContext();
		this.isGameStarted = true;
		this.printStartGuide();
        this.enterName();
	}

    private void enterName() {
        String inputName = scanner.nextLine().trim();
        gameContext.getPlayer().enterName(inputName);
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
        System.out.println("😁 당신의 이름은 무엇입니까?");

	}

	private void printInGameHelp() {
		System.out.println("📌 명령어 예시:");
		System.out.println("  dex        → 몬스터 도감 보기");
		System.out.println("  go 1       → 산으로 탐험 가기");
		System.out.println("  go 2       → 바다로 탐험 가기");
		System.out.println("  go 3       → 학교로 탐험 가기");
		System.out.println("  exit       → 게임 종료\n");
	}

	private void printExitMessage() {
		System.out.println();
		System.out.println("🌟==============================🌟");
		System.out.println("   게임 종료! 다음에 또 만나요 😊");
		System.out.println("🌟==============================🌟\n");
	}

    private void playerWinMessage() {
        System.out.println();
        System.out.println("🌟==============================🌟");
        System.out.println("    모든 몬스터를 잡았습니다! 😁");
        System.out.println("    당신은 진정한 트레이너입니다! 😁");
        System.out.println("    승리하였습니다! 🎊");
        System.out.println("🌟==============================🌟\n");
    }
}
