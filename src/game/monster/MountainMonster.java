package game.monster;

public class MountainMonster extends Monster { // 자식클래스(몬스터의 종류별 특징 구현) - 1산몬스터

	public MountainMonster(int id, String name, int tier, int maxEnergy) {
		super(id, name, tier, maxEnergy);
		this.habitat = "mountain";
		this.attackName = "바위던지기";
		this.hpLoss = 20;
	}

	@Override
	public void takeDamage() {
		// super.reduceHp(damage); 와 같음. 자식에서 오버라이드 하지 않음
		reduceHp(this.hpLoss); // 현재 클래스에 없으므로 부모 거 호출

		// reduceHP(->체력을 깎는 메서드), 몬스터가 받는 데미지 만큼의 값을 메서드에 넣어준다.

		System.out.println(
				"😵 몬스터 " + this.getName() + "이(가) " + this.attackName + "공격으로 " + this.hpLoss + " 데미지를 입었습니다.");
		System.out.println("🩸 남은 체력: " + this.getHp());

	}

	// 자식 클래스만의 고유 기술 추가
	public void specialSkill() {
		System.out.println("⛰️ " + getName() + "이(가) 산사태를 일으켰습니다! 모든 적에게 강력한 바위 데미지를 입힙니다!");
	}

}
