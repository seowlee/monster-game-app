package game.monster;

import game.player.Player;

public class MountainMonster extends Monster {

	public MountainMonster(int id, String name, int tier, int maxEnergy) {
		super(id, name, tier);
		this.habitat = "mountain";
		this.attackName = "바위던지기";
		this.attackDamage = 20;
	}

	@Override
	public void attackPlayer(Player player) {
		System.out.println(this.habitat + " 몬스터 " + this.getName() + "의 " + this.attackName + "공격");
		player.reduceHP(this.attackDamage);
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
