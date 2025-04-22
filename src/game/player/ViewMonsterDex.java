package game.player;

import game.monster.Monster;

public class ViewMonsterDex {
    public String viewMonsterDex(Monster[] monsterList, String name) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("========== %s님 몬스터 도감 목록 ==========\n", name));
        for (Monster monster : monsterList) {
            String captureStr = monster.isCaptured() ? "잡힘" : "안 잡힘";
            sb.append(String.format("%d. %s %d %s\n", monster.getId(), monster.getName(), monster.getHp(), captureStr));
        }
        return sb.toString();
    };
}
