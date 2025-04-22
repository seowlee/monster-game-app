package game.monster;

public class SchoolMonster extends Monster {

	public SchoolMonster(String name, int tier, int maxEnergy) {
		super(name, tier, HabitatType.SCHOOL);
	}

	public double getEscapeRate() {
		return 0.2;
	}

	public double getCaptureRate() {
		return 0.8;
	}

	public String getSpecialAbility() {
		return "CheatSheet";
	}
}
