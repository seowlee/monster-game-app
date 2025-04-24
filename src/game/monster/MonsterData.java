package game.monster;

public class MonsterData {

	public static Monster[] getInitialMonsters() {

		Monster[] monsters = new Monster[18];
		int index = 0;

		// 🏔 Mountain Monsters (maxEnergy: 100)
		monsters[index++] = new MountainMonster(1, "돌멩이몬", 1, 100); // 초급 바위
		monsters[index++] = new MountainMonster(2, "크렉바위", 2, 100); // 틈새 바위
		monsters[index++] = new MountainMonster(3, "롤링스톤", 1, 100); // 구르는 바위
		monsters[index++] = new MountainMonster(4, "깨진암흑", 3, 100); // 최상급 파괴 바위
		monsters[index++] = new MountainMonster(5, "화산머리", 2, 100); // 용암형 바위
		monsters[index++] = new MountainMonster(6, "지진포효", 3, 100); // 지축을 울리는 돌

		// 🌊 Sea Monsters (maxEnergy: 200)
		monsters[index++] = new SeaMonster(7, "물총알", 1, 200); // 귀여운 물탄환
		monsters[index++] = new SeaMonster(8, "조개찍찍", 2, 200); // 귀여운 조개포
		monsters[index++] = new SeaMonster(9, "해일턱괴", 3, 200); // 바다의 입
		monsters[index++] = new SeaMonster(10, "심해말랑", 1, 200); // 말랑괴물
		monsters[index++] = new SeaMonster(11, "파도질주", 2, 200); // 고속돌진
		monsters[index++] = new SeaMonster(12, "심연상어", 3, 200); // 최강의 포식자

		// 🏫 School Monsters (maxEnergy: 300)
		monsters[index++] = new SchoolMonster(13, "지우개몬", 1, 300); // 덜덜 떨리는 수업시간 몬스터
		monsters[index++] = new SchoolMonster(14, "숙제괴물", 2, 300); // 숙제 공포
		monsters[index++] = new SchoolMonster(15, "시험킹", 1, 300); // 평범한 시험 지배자
		monsters[index++] = new SchoolMonster(16, "문제조련사", 2, 300); // 문제풀기의 장인
		monsters[index++] = new SchoolMonster(17, "교수", 3, 300); // 최강의 시험 내는 자
		monsters[index++] = new SchoolMonster(18, "공부요괴", 3, 300); // 피를 빨아먹는 시험

		return monsters;

	}
}
