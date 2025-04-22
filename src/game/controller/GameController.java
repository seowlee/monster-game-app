package game.controller;

import java.util.Scanner;

import game.habitat.HabitatService;
import game.utils.Converter;

/*
 * 전체 게임 관리 클래스
 */
public class GameController {
	Scanner scanner = new Scanner(System.in);

	public void run() {
		while (true) {
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
				System.out.println("\n## 게임 시작");
				System.out.println("어디로 가겠습니까? 1.산  2.바다  3.학교");
				String regionInput = scanner.nextLine().trim();

				String region = Converter.convertInputToRegion(regionInput);

				if (region == null) {
					System.out.println("⚠️ 잘못된 입력입니다.");
					continue;
				}

				System.out.println("🧭 선택된 장소: " + region);

				HabitatService.exploreRegion(region); // 지역별 탐험 시작

			} else {
				System.out.println("⚠️ 존재하지 않는 명령어입니다.");
			}
		}
	}

}