package game.player;

import java.util.*;

import game.monster.Monster;

public class HitMonster {
    public int attack() {
        int r = new Random().nextInt(4);
        return switch (r) {
            case 0 -> 50;
            case 1 -> 30;
            case 2 -> 20;
            default -> 0;
        };
    }
}
