package game.monster;

public class SeaMonster extends Monster {

	public SeaMonster(String name, int tier, int maxEnergy) {
		super(name, tier, HabitatType.SEA);
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
