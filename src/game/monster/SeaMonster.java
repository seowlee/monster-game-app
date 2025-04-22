package game.monster;

public class SeaMonster extends Monster {

	public SeaMonster(int id, String name, int tier, int maxEnergy) {
		super(id, name, tier);
		this.habitat = "sea";
		this.attackName = "물대포";
		this.attackDamage = 15;
	}

	// TODO: attackPlayer 메소드 오버라이드

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
