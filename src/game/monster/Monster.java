package game.monster;

public class Monster { // 부모 클래스(몬스터 공통 속성과 기능정의)
	private int id;
	private String name;
	private int hp; // 에너지. 체력
	private int tier; // 아직사용x
	private int maxEnergy;
	private boolean isCaptured; // 잡힘 상태. 잡혔으면 true 아니면 false
	protected String habitat;
	protected String attackName;
	protected int hpLoss;

	public Monster(int id, String name, int tier, int maxEnergy) {
		this.id = id;
		this.name = name;
		this.maxEnergy = maxEnergy;
		this.hp = maxEnergy;
		this.habitat = "서식지";
		this.attackName = "공격이름";
		this.hpLoss = 10;
	}

	public void printMonster() { // 몬스터 정보 출력
		System.out.println("이름: " + this.name + ", 몬스터 HP: " + this.hp + ", 몬스터 서식지: " + this.habitat);
	}

	public void takeDamage() { // 데미지 입은 양 출력
		System.out.println("😵 몬스터 " + this.name + "이(가) " + this.hpLoss + " 만큼의 데미지를 입었습니다.");
	}

	public void reduceHp(int hpLoss) { // reduceHp
		this.hp = Math.max(0, this.hp - hpLoss);
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

	public String getAttackName() {
		return attackName;
	}

	public void setIsCaptured(boolean isCaptured) {
		this.isCaptured = isCaptured;
	}
}
