package game.player;

public class printHP {
    public void PrintHP(int hp, int conHp, String name) {
        System.out.println("체력이 " + conHp + " 감소하였습니다.");
        System.out.println("현재 " + name + "님의 체력은 " + hp + "입니다.");
    }
}
