package valueSolverPack;

public enum Months {
	JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5), JUNE(6), JULY(7), AUGUST(8), SEPTEMBER(9), OCTOBER(10),
	NOVEMBER(11), DECEMBER(12);

	public final int num;

	Months(int num) {
		this.num = num;
	}

	//Method that gets months by modulus 12
	static Months getMonth(int num) {
		return switch (num % 12) {
			case 1 -> JANUARY;
			case 2 -> FEBRUARY;
			case 3 -> MARCH;
			case 4 -> APRIL;
			case 5 -> MAY;
			case 6 -> JUNE;
			case 7 -> JULY;
			case 8 -> AUGUST;
			case 9 -> SEPTEMBER;
			case 10 -> OCTOBER;
			case 11 -> NOVEMBER;
			default -> DECEMBER;
		};
	}
}
