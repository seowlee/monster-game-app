package game.player;

import game.monster.Monster;
import java.util.*;

public class Player {
	private String name;
	private int hp;
	private int conHP = 10;
	// TODO: name, hp 입력값 할당하는 생성자 추가?
	Random r = new Random();
	ViewMonsterDex vmd = new ViewMonsterDex();
	AttackMonster am = new AttackMonster();
	MovePlayer mm = new MovePlayer();
	printHP ph = new printHP();

	// 도감 목록 보기- 잡은 몬스터 목록, 잡아야할 몬스터 목록 모두 포함
	// 아래 함수들에 대한 몬스터 상태에 대한 것은 몬스터 패키지에서 처리
	public void viewMonsterDex(Monster[] monsterList) {
		System.out.println(vmd.viewMonsterDex(monsterList, this.name));
	};

	// 몬스터 잡기 - 잡혔는지 안잡혔는지 결과에 따라 처리하기
	public void attackMonster(Monster monster) {
		System.out.println(am.attackMonster(monster));
	};

	// 몬스터 때리기 - 플레이어, 포켓몬 에너지 깎임
	public void hitMonster(Monster monster) {

	}

	// TODO: 논의. 도망가기에 왜 이미 잡은 몬스터 출력?
	// 도망가기 - 이미 잡은 몬스터(이름으로 체크)
	public void movePlayer(Monster monster) {
		System.out.println(mm.movePlayer(monster));
	}

	// 휴식 - 에너지 복구
	public void rest() {
		this.hp = 100;
	};

	// 체력 감소 - 행동할 때 마다 플레이어 체력이 깍임
	private void consumeHP() {
		this.hp -= this.conHP;
		ph.PrintHP(hp, conHP, name);
	}

	// TODO: hp < 0일 때 처리. 게임 종료? 이야기 나누기
	// 몬스터가 공격할 때마다 플레이어 체력 감소
	public void reduceHP(int attackDamage) {
		this.hp -= attackDamage;
	}
}
