package game.player;

import game.monster.Monster;

public class MovePlayer {
    public String movePlayer(Monster monster) {
        if (monster.isCaptured) return monster.name + "은 이미 잡은 몬스터입니다.";
        return "";
    }
}