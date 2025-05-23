package game.controller;

import java.util.*;

import game.context.GameContext;
import game.habitat.HabitatService;
import game.monster.Monster;
import game.utils.Converter;

// ✅ 전체 게임 흐름을 제어하는 컨트롤러
// 사용자 입력에 따라 게임 시작(start), 도감(dex), 지역 탐험(go), 휴식(zz), 종료(exit) 명령을 처리
// 턴 수 관리(turnCount), 승리/패배 조건 검사(playerWinMessage, playerLoseMessage) 담당
public class GameController {
    Scanner scanner = new Scanner(System.in);
    GameContext gameContext;
    boolean isGameStarted = false;
    int turnCount = 0;

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
                    if (turnCount > 120) {
                        playerLoseMessage();
                        break; //
                    }
                    if (Arrays.stream(gameContext.getMonsterManager().getAllMonsters()).allMatch(Monster::isCaptured)) {
                        playerWinMessage();
                        break;
                    }
                    System.out.println("🧭 선택된 장소: " + region);
                    HabitatService.exploreRegion(scanner, region, this.gameContext);
                    turnCount++; //
                    System.out.println(turnCount + "번째 턴 종료!");
                    this.printInGameHelp();
                }

            } else if (inputString.equalsIgnoreCase("zz")) {
                gameContext.getPlayer().rest();
            } else {
                System.out.println("⚠️ 존재하지 않는 명령어입니다. 사용 가능한 명령어:");
                this.printInGameHelp();
            }
        }
    }

    private void startGame() {
        this.gameContext = new GameContext();
        this.isGameStarted = true;
        this.turnCount = 0;
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
        System.out.println("  zz         → 체력 회복하기");
        System.out.println("  exit       → 게임 종료\n");
    }

    private void printExitMessage() {
        System.out.println();
        System.out.println("🌟==============================🌟");
        System.out.println("   게임 종료! 다음에 또 만나요 😊");
        System.out.println("🌟==============================🌟\n");
    }

    private void playerLoseMessage() {
        System.out.println();
        System.out.println("🌟==============================🌟");
        System.out.println("🔥 120턴을 초과했습니다. 몬스터들이 모두 도망갔습니다!");
        System.out.println("게임 오버 😵");
        System.out.println("🌟==============================🌟\n");
    }

    private void playerWinMessage() {
        System.out.println();
        System.out.println("🌟==============================🌟");
        System.out.println("    모든 몬스터를 잡았습니다! 😁");
        System.out.println("    당신은 진정한 트레이너입니다! 😁");
        System.out.println("    승리하였습니다! 🎊");
        System.out.println("총 소요 턴 수: " + turnCount + "턴");

        if (turnCount <= 80) {
            System.out.println("당신의 랭크는 S입니다!");
        } else if (turnCount <= 90) {
            System.out.println("당신의 랭크는 A입니다!");
        } else if (turnCount <= 100) {
            System.out.println("당신의 랭크는 B입니다!");
        } else if (turnCount <= 110) {
            System.out.println("당신의 랭크는 C입니다!");
        } else {
            System.out.println("당신의 랭크는 D입니다!");
        }
        System.out.println("🌟==============================🌟\n");
    }
}
