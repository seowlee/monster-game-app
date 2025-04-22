package game.monster;

public class SchoolMonster extends Monster {

	public SchoolMonster(int id, String name, int tier, int maxEnergy) {
		super(id, name, tier);
		this.habitat = "school";
		this.attackName = "지식의 파도";
		this.attackDamage = 50;
	}

	// TODO: attackPlayer 메소드 오버라이드

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
