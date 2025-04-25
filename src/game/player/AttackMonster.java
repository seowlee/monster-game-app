package game.player;

import game.monster.Monster;

import java.util.Random;

public class AttackMonster {
    Random r = new Random();

    // 몬스터를 잡았을 때 처리하는 메서드
    private void captureMonster(Monster monster) {
        monster.setIsCaptured(true);
        System.out.println(monster.getName() + "를 성공적으로 잡았습니다.");
    }

    public void attackMonster(Monster monster) {
        int hp = monster.getHp();
        // 몬스터 체력이 30 이하 이면 무조건 잡을 수 있음
        if (hp <= 30) {
            captureMonster(monster);
            // 몬스터 체력이 70 이하 이면 50% 확률로 잡을 수 있음
        } else if (hp <= 70 && r.nextInt(2) == 0) {
            captureMonster(monster);
            // 몬스터 체력이 70 초과면 25% 확률로 잡을 수 있음
        } else if (hp > 70 && r.nextInt(4) == 0) {
            captureMonster(monster);
        } else {
            System.out.println(monster.getName() + "를 잡지 못했습니다.");
        }
    };
}
