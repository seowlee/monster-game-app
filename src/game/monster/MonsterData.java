package game.monster;

public class MonsterData {

	public static Monster[] getInitialMonsters() {

		Monster[] monsters = new Monster[18];
		int idx = 0;

		// 🏔 Mountain Monsters (maxEnergy: 100)
		monsters[idx++] = new MountainMonster(1, "Rockon", 1, 100);
		monsters[idx++] = new MountainMonster(2, "Stonix", 2, 100);
		monsters[idx++] = new MountainMonster(3, "Gravon", 1, 100);
		monsters[idx++] = new MountainMonster(4, "Pebblord", 3, 100);
		monsters[idx++] = new MountainMonster(5, "Terragon", 2, 100);
		monsters[idx++] = new MountainMonster(6, "Granitus", 3, 100);

		// 🌊 Sea Monsters (maxEnergy: 200)
		monsters[idx++] = new SeaMonster(7, "Aquaon", 1, 200);
		monsters[idx++] = new SeaMonster(8, "Wavix", 2, 200);
		monsters[idx++] = new SeaMonster(9, "Seabite", 3, 200);
		monsters[idx++] = new SeaMonster(10, "Corallus", 1, 200);
		monsters[idx++] = new SeaMonster(11, "Kraken Jr", 2, 200);
		monsters[idx++] = new SeaMonster(12, "Finzor", 3, 200);

		// 🏫 School Monsters (maxEnergy: 300)
		monsters[idx++] = new SchoolMonster(13, "Nerdzilla", 1, 300);
		monsters[idx++] = new SchoolMonster(14, "Bookmon", 2, 300);
		monsters[idx++] = new SchoolMonster(15, "Quizter", 1, 300);
		monsters[idx++] = new SchoolMonster(16, "Testachu", 2, 300);
		monsters[idx++] = new SchoolMonster(17, "ProffX", 3, 300);
		monsters[idx++] = new SchoolMonster(18, "Mathmagus", 3, 300);

		return monsters;

	}
}