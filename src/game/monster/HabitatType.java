package game.monster;

public enum HabitatType {
	MOUNTAIN("산"), SEA("바다"), SCHOOL("학교");

	private final String displayName;

	HabitatType(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public static HabitatType fromInput(String input) {
		switch (input) {
		case "1":
			return MOUNTAIN;
		case "2":
			return SEA;
		case "3":
			return SCHOOL;
		default:
			return null;
		}
	}
}
