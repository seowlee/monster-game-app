package game.monster;

public class SchoolMonster extends Monster {

	public SchoolMonster(int id, String name, int tier, int maxEnergy) { // 자식클래스(몬스터의 종류별 특징 구현) - 3학교몬스터
		super(id, name, tier);
		this.habitat = "school";
		this.attackName = "지식의 파도";
		this.attackDamage = 50;
	}

	// TODO: takeDamage 메소드 오버라이드
	@Override
	public void takeDamage() {
		// super.reduceHp(damage)
		reduceHp(this.attackDamage);

		System.out.println("📚 " + getName() + "이(가) " + attackName + "에 맞아 " + attackDamage + " 데미지를 입었습니다!");
		System.out.println("🧠 남은 체력: " + getHp());

	}

	// 자식 클래스만의 고유 기술 추가 // SchoolMonster
	public void specialSkill() {
		System.out.println("📚 " + getName() + "이(가) 컴퓨터를 던졌습니다! 지식 데미지 발동!");
	}
}
