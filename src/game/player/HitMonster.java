package game.player;

import java.util.*;

/**
 * ✅ 플레이어가 몬스터를 "공격"할 때 반응 출력
 */
public class HitMonster {

    public void printAttackReaction(String attackName) {
        switch (attackName) {
            case "바위던지기":
                System.out.println("💥 바위가 머리를 강타했다! 정신이 아득해진다...");
                break;
            case "물대포":
                System.out.println("🌊 물줄기가 당신을 강타한다! 숨이 턱 막힌다!");
                break;
            case "지식의 파도":
                System.out.println("📚 지식의 파도에 휘말렸다! 머리가 터질 것 같다!");
                break;
            default:
                System.out.println("💢 강한 공격을 받았다!");
        }
    }
}
