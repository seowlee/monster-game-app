package game.player;

public class Player {
	private String name;
	private int energy;

	/**
	 * 도감 목록 보기- 잡은 몬스터 목록, 잡아야할 몬스터 목록 모두 포함
	 */
	public void viewMonsterDex() {
	};

	/**
	 * 아래 함수들에 대한 몬스터 상태에 대한 것은 몬스터 패키지에서 처리
	 */

	/**
	 * 몬스터 잡기 - 잡혔는지 안잡혔는지 결과에 따라 처리하기
	 * 
	 */
	public void attackMonster() {
	};

	/**
	 * 몬스터 때리기 - 플레이어, 포켓몬 에너지 깎임
	 */

	/**
	 * 도망가기 - 이미 잡은 몬스터(이름으로 체크)
	 */

	/**
	 * 휴식 - 에너지 복구
	 */
	public void rest() {
		this.energy = 100;
	};

}