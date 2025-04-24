package game.player;

import game.monster.Monster;

public class Player {
	private String name;
	private int hp = 100;

	ViewMonsterDex vmd = new ViewMonsterDex();
	AttackMonster am = new AttackMonster();
	HitMonster hm = new HitMonster();
	PrintHP ph = new PrintHP();

	// 이름 입력하기
	public void enterName(String name) {
		this.name = name;
	}

	// 도감 목록 보기- 잡은 몬스터 목록, 잡아야할 몬스터 목록 모두 포함
	// 아래 함수들에 대한 몬스터 상태에 대한 것은 몬스터 패키지에서 처리
	public void viewMonsterDex(Monster[] monsterList) {
		System.out.println(vmd.viewMonsterDex(monsterList, this.name));
	};

	// 몬스터 잡기 - 잡혔는지 안잡혔는지 결과에 따라 처리하기
	public void attackMonster(Monster monster) {
		if (this.hp <= 0) {
			ph.recoveryHP(name);
			return;
		}

		System.out.println("🎯 " + this.name + "이(가) 몬스터를 잡으려 합니다!");
		am.attackMonster(monster);
		this.consumeHP();
	};

	// 몬스터 공격하기 - 플레이어, 포켓몬 에너지 깎임
	public void hitMonster(Monster monster) {
		if (this.hp <= 0) {
			ph.recoveryHP(name);
			return;
		}
		this.consumeHP();
		hm.printAttackReaction(monster.getAttackName());
		monster.takeDamage();
	}

	// 휴식 - 에너지 복구
	public void rest() {
		if (this.hp <= 0) {
			System.out.println("❤️ 체력을 회복합니다! 이제 행동할 수 있습니다!");
			this.hp = 100;
		} else {
			System.out.println("휴식 금지 다시 몬스터를 잡으러 가세요.");
		}
		System.out.println();
	};

	// 체력 감소 - 행동할 때 마다 플레이어 체력이 깍임(10 감소)
	private void consumeHP() {
		final int conHP = 10;
		this.hp -= conHP;
		ph.printHP(hp, conHP, name);
	}

}
