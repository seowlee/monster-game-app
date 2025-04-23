package game.player;

public class Rest {
	public int playerRest(int hp) {
		if (hp <= 0) return 100;
		else return hp;
	}
}
