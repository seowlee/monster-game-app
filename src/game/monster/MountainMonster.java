package game.monster;

public class MountainMonster extends Monster {

	public MountainMonster(int id, String name, int tier, int maxEnergy) {
		super(id, name, tier);
		this.habitat = "mountain";
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
