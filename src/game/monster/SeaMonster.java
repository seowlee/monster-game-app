package game.monster;

public class SeaMonster extends Monster {

	public SeaMonster(int id, String name, int tier, int maxEnergy) {
		super(id, name, tier);
		this.habitat = "sea";
	}

	public double getEscapeRate() {
		return 0.6;
	}

	public double getCaptureRate() {
		return 0.4;
	}

	public String getSpecialAbility() {
		return "WaterBlast";
	}
}
