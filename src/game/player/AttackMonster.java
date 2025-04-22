package game.player;

import game.monster.Monster;

public class AttackMonster {
    public String attackMonster(Monster monster) {
        if (monster.hp <= 10) return "몬스터를 성공적으로 잡았습니다.";
        else return "몬스터를 잡지 못했습니다.";
    };
}
