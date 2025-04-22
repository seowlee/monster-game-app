package game.utils;

public class Converter {

	/**
	 * 사용자 입력값(숫자) → 지역명("산", "바다", "학교") 변환
	 *
	 * @param input 사용자 입력값 (예: "1", "2", "3")
	 * @return 지역명 ("산", "바다", "학교") 또는 null
	 */
	public static String convertInputToRegion(String input) {
		switch (input) {
			case "산":
				return "mountain";
			case "바다":
				return "sea";
			case "학교":
				return "school";
			default:
				return null;
		}
	}
}
