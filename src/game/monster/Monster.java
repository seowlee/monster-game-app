package game.monster;

public class Monster {
	public int id;
	public String name;
	public int hp; // 에너지. 체력
	protected int maxHp;
	public boolean isCaptured; // 잡힘 상태. 잡혔으면 true 아니면 false
	public HabitatType habitat;
	public int tier;
	
	public Monster(String name, int tier, HabitatType habitat) {
		this.name = name;
		this.maxHp = 100;
		this.hp = maxHp;
		this.habitat = habitat;
	}

	public void reduceEnergy(int amount) {
		hp = Math.max(0, hp - amount);
	}

	public void recoverEnergy(int amount) {
		hp = Math.min(maxHp, hp + amount);
	}

	public boolean isCapturable() {
		return hp <= 10;
	}

	// 공통 getter
	public String getName() {
		return name;
	}

	public int getCurrentEnergy() {
		return hp;
	}

	public int getMaxEnergy() {
		return maxEnergy;
	}

	public HabitatType getHabitat() {
		return habitat;
	}
}