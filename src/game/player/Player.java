package game.player;

import game.monster.Monster;
import java.util.*;

public class Player {
	private String name;
	private int hp;
	private int conHP = 10;

	Random r = new Random();

	// 도감 목록 보기- 잡은 몬스터 목록, 잡아야할 몬스터 목록 모두 포함
	// 아래 함수들에 대한 몬스터 상태에 대한 것은 몬스터 패키지에서 처리
	public void viewMonsterDex(Monster[] monsterList) {
		System.out.printf("========== %s님 몬스터 도감 목록 ==========\n", this.name);
//		System.out.println("제발 부탁인데 이승엽은 좌우놀이 좀 그만해라");
		for (Monster monster : monsterList) {
			String catureStr = monster.isCaptured ? "잡힘" : "안 잡힘";
			System.out.printf("%d. %s %d %s\n", monster.id, monster.name, monster.hp, catureStr);
		}
	};

	// 몬스터 잡기 - 잡혔는지 안잡혔는지 결과에 따라 처리하기
	public void attackMonster(Monster monster) {
		if (monster.hp <= 10) System.out.println("몬스터를 성공적으로 잡았습니다.");
		else System.out.println("몬스터를 잡지 못했습니다.");
	};

	// 몬스터 때리기 - 플레이어, 포켓몬 에너지 깎임
	public void hitMonster(Monster monster) {

	}

	// 도망가기 - 이미 잡은 몬스터(이름으로 체크)
	public void movePlayer(Monster monster) {
		if (monster.isCaptured) System.out.println(monster.name + "은 이미 잡은 몬스터입니다.");
	}

	// 휴식 - 에너지 복구
	public void rest() {
		this.hp = 100;
	};

	// 체력 감소 - 행동할 때 마다 플레이어 체력이 깍임
	private void minusHP() {
		this.hp -= this.conHP;
		System.out.println("체력이 " + this.conHP + " 감소하였습니다.");
		System.out.println(this.name + "님의 체력은 " + this.hp + "입니다.");
	}
}