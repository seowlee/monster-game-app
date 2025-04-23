package game.player;

import java.util.*;

import game.monster.Monster;

public class playerAttack {
	public int attack() {
		
		int r = new Random().nextInt(4);
		
		switch(r) {
			case 0 : return 50;
			case 1 : return 30;
			case 2 : return 20;
			default : return 0;
		}
	}
	
	public int remainHp(Monster m) {
		return m.hp - attack();
	}
}
