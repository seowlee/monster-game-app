package game.habitat;

public class HabitatService {

	public static void exploreRegion(String region) {
		switch (region) {
		case "산":
			exploreMountain();
			break;
		case "바다":
			exploreSea();
			break;
		case "학교":
			exploreSchool();
			break;
		default:
			throw new IllegalArgumentException("지역 없음: " + region);
		}
	}

	private static void exploreMountain() {
		System.out.println("⛰️ 산에 들어섰습니다. 거대한 바위 몬스터가 출몰합니다!");
		// MountainMonster monster = new MountainMonster(...);
		// monster.describe();
	}

	private static void exploreSea() {
		System.out.println("🌊 바다에 도착했습니다. 깊은 곳에서 몬스터가 솟아오릅니다!");
		// SeaMonster monster = new SeaMonster(...);
		// monster.describe();
	}

	private static void exploreSchool() {
		System.out.println("🏫 학교 안으로 들어갑니다. 의외의 장소에서 몬스터가 나타납니다!");
		// SchoolMonster monster = new SchoolMonster(...);
		// monster.describe();
	}
}
