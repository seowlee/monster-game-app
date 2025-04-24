package game.player;

import java.util.*;

public class HitMonster {
    public int attack() {
        int randNm = new Random().nextInt(4);
        int result;
        switch (randNm) {
            case 0:
                result = 50;
                break;
            case 1:
                result = 30;
                break;
            case 2:
                result = 20;
                break;
            default:
                result = 0;
        }
        return result;
    }
}
