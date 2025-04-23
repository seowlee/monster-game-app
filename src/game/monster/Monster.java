package game.monster;

import game.player.Player;

public class Monster {
	private int id;
	private String name;
	private int hp; // 에너지. 체력
	private int tier; // 아직사용x
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

	public void takeDamage() {
		System.out.println("😵 몬스터 " + this.name + "이(가) " + this.attackDamage + " 만큼의 데미지를 입었습니다.");
	}

	public void reduceHp(int amount) {
		this.hp -= amount;
		if (this.hp < 0)
			this.hp = 0;
	}

	public void markAsCaptured() {
		this.isCaptured = true;
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

	public int getMaxEnergy() {
		return maxEnergy;
	}

	public boolean isCaptured() {
		return isCaptured;
	}

	public String getHabitat() {
		return habitat;
	}

    // 공통 setter
    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setIsCaptured(boolean isCaptured) {
        this.isCaptured = isCaptured;
    }
}
