package game.monster;

public class Monster {
	private int id;
	private String name;
	private int hp; // 에너지. 체력
	private int tier;
	private int maxEnergy;
	private boolean isCaptured; // 잡힘 상태. 잡혔으면 true 아니면 false
	protected String habitat;

	public Monster(int id, String name, int tier) {
		this.id = id;
		this.name = name;
		this.maxEnergy = 100;
		this.hp = maxEnergy;
		this.habitat = "서식지";
	}

	public void printMonster() {
		System.out.println("name: " + this.name + "hp: " + this.hp + "티어: " + this.tier);
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
