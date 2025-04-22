package game.monster;

import game.player.Player;

public class Monster {
	private int id;
	private String name;
	private int hp; // 에너지. 체력
	private int tier;
	private int maxEnergy;
	private boolean isCaptured; // 잡힘 상태. 잡혔으면 true 아니면 false
	protected String habitat;
	protected String attackName;
	protected int attackDamage;

	public Monster(int id, String name, int tier) {
		this.id = id;
		this.name = name;
		this.maxEnergy = 100;
		this.hp = maxEnergy;
		this.habitat = "서식지";
		this.attackName = "공격이름";
		this.attackDamage = 10;
	}

	public void attackPlayer(Player player) {
		// 플레이어에게 공격
		System.out.println(this.habitat + " 몬스터 " + this.name + "의 공격");
		player.reduceHP(this.attackDamage); // 플레이어 체력 감소
	}

	public void reduceEnergy(int amount) {
		hp = Math.max(0, hp - amount);
	}

	public void recoverEnergy(int amount) {
		hp = Math.min(maxEnergy, hp + amount);
	}

	// 공통 getter
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	public int getTier() {
		return tier;
	}

	public int getCurrentEnergy() {
		return hp;
	}

	public int getMaxEnergy() {
		return maxEnergy;
	}

	public boolean isCaptured() {
		return isCaptured;
	}

	public String getHabitat() {
		return habitat;
	}
}
