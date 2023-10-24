public enum Operator {
	ADDITION('+'),
	SUBTRACTION('-'),
	MULTIPLICATION('*'),
	DIVISION('/'),
	MODULO('%');

	private final char symbol;

	Operator(char symbol) {
		this.symbol = symbol;
	}

	public char getSymbol() {
		return symbol;
	}

	public static Operator fromChar(char c) {
		for (Operator operator : values()) {
			if (operator.symbol == c) {
				return operator;
			}
		}
		return null; // Return null if the character doesn't correspond to a valid operator
	}
}