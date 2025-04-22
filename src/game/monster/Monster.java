package game.monster;

public class Monster {
	protected int id;
	protected String name;
	protected int hp; // 에너지. 체력
	protected int maxEnergy;
	protected boolean isCaptured; // 잡힘 상태. 잡혔으면 true 아니면 false
	protected HabitatType habitat;

	public Monster(String name, int tier, HabitatType habitat) {
		this.name = name;
		this.maxEnergy = 100;
		this.hp = maxEnergy;
		this.habitat = habitat;
	}

	public void reduceEnergy(int amount) {
		hp = Math.max(0, hp - amount);
	}

	public void recoverEnergy(int amount) {
		hp = Math.min(maxEnergy, hp + amount);
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