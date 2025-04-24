package game.player;

import java.util.*;

public class HitMonster {
    public int attack() {
        int randNm = new Random().nextInt(4);
        int result;
        switch (randNm) {
            case 0:
                result = 50;
            case 1:
                result = 30;
            case 2:
                result = 10;
            default:
                result = 0;
        }
        return result;
    }
}
