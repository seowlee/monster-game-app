package game.monster;

public class SchoolMonster extends Monster {

	public SchoolMonster(int id, String name, int tier, int maxEnergy) {
		super(id, name, tier);
		this.habitat = "school";
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
