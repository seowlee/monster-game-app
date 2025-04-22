package game.monster;

public class MountainMonster extends Monster {

	public MountainMonster(String name, int tier, int maxEnergy) {
		super(name, tier, HabitatType.MOUNTAIN);
	}

	public double getEscapeRate() {
		return 0.3;
	}

	public double getCaptureRate() {
		return 0.5;
	}

	public String getSpecialAbility() {
		return "RockSkin";
	}
}
