package game.player;

import game.monster.Monster;

public class ViewMonsterDex {
    public String viewMonsterDex(Monster[] monsterList, String name) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("========== %s님 몬스터 도감 목록 ==========\n", name));

        // 컬럼명 헤더 출력 (공격명 제거)
        sb.append(String.format("%-3s %-10s %-5s %-8s %-8s\n", "ID", "이름", "HP", "상태", "서식지"));

        // 각 몬스터 정보 출력
        for (Monster monster : monsterList) {
            String captureStr = monster.isCaptured() ? "잡힘" : "안잡힘";
            sb.append(String.format("%-3d %-10s %-5d %-8s %-8s\n",
                    monster.getId(),
                    monster.getName(),
                    monster.getHp(),
                    captureStr,
                    monster.getHabitat()));
        }

        return sb.toString();
    };
}
