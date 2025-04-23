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
	public void takeDamage() {
		// super.reduceHp(damage); 와 같음. 자식에서 오버라이드 하지 않음
		reduceHp(this.attackDamage);

		System.out.println(
				"😵 몬스터 " + this.getName() + "이(가) " + this.attackName + "공격으로 " + this.attackDamage + " 데미지를 입었습니다.");
		System.out.println("🩸 남은 체력: " + this.getHp());
	}

}
