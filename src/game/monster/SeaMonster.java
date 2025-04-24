package game.monster;

public class SeaMonster extends Monster { // 자식클래스(몬스터의 종류별 특징 구현) - 2바다 몬스터

	public SeaMonster(int id, String name, int tier, int maxEnergy) {
		super(id, name, tier, maxEnergy);
		this.habitat = "sea";
		this.attackName = "물대포";
		this.hpLoss = 40;
	}

	// TODO: takeDamage 메소드 오버라이드
	@Override
	public void takeDamage() {
		// super.reduceHp(damage)
		reduceHp(this.hpLoss);

		System.out.println("🌊 몬스터 " + getName() + "이(가) " + attackName + "으로 " + hpLoss + " 데미지를 입었습니다!");
		System.out.println("💧 남은 체력: " + getHp());

	}

	// 자식 클래스만의 고유 기술 추가 // SeaMonster
	public void specialSkill() {
		System.out.println(getName() + "이(가) 거대한 파도를 일으킨다!");
	}

}
