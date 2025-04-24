package game.player;

import game.monster.Monster;

public class Player {
	private final String name = "모험자";
	private int hp = 100;

	ViewMonsterDex vmd = new ViewMonsterDex();
	AttackMonster am = new AttackMonster();
	HitMonster hm = new HitMonster();
	printHP ph = new printHP();

	// 도감 목록 보기- 잡은 몬스터 목록, 잡아야할 몬스터 목록 모두 포함
	// 아래 함수들에 대한 몬스터 상태에 대한 것은 몬스터 패키지에서 처리
	public void viewMonsterDex(Monster[] monsterList) {
		System.out.println(vmd.viewMonsterDex(monsterList, this.name));
	};

	// 몬스터 잡기 - 잡혔는지 안잡혔는지 결과에 따라 처리하기
	public void attackMonster(Monster monster) {
		if (this.hp <= 0) {
            recoveryHP();
            return;
        }
		am.attackMonster(monster);
		consumeHP();
	};

	// 몬스터 공격하기 - 플레이어, 포켓몬 에너지 깎임
	public void hitMonster(Monster monster) {
		if (this.hp <= 0) {
            recoveryHP();
            return;
        }
		consumeHP();
		monster.setHp(Math.max(0, monster.getHp() - hm.attack()));
	}

	// 휴식 - 에너지 복구
	public void rest() {
		if (this.hp <= 0) {
            System.out.println("❤️ 체력을 회복합니다! 이제 행동할 수 있습니다!");
            this.hp = 100;
        }
        System.out.println();
	};

	// 체력 감소 - 행동할 때 마다 플레이어 체력이 깍임(10 감소)
	private void consumeHP() {
		final int conHP = 10;
		this.hp -= conHP;
		ph.PrintHP(hp, conHP, name);
	}

    private void recoveryHP() {
        System.out.println("❤️ 플레이어가 지쳐 있어 체력을 회복해야 합니다!");
    }
}
