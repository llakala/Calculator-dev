// Enum to represent all operators. Held as text unless getSymbol() method is used. 
public enum Operator {
	ADDITION('+'),
	SUBTRACTION('-'),
	MULTIPLICATION('*'),
	DIVISION('/'),
	MODULO('%');

	private final char symbol; // Holds symbol of operator

// Constructor for operators that sets the given parameter to the operator's symbol. 
	Operator(char symbol) {
		this.symbol = symbol;
	}
	
/** Method that returns symbol of an operator. 
	* Preconditions: 
		* Operator is not null
	* Postconditions: 
		* Symbol of operator is returned
 */
	public char getSymbol() {
		return symbol;
	}


// Method that takes a given symbol as a parameter and returns the correct operator
	public static Operator fromChar(char c) {
		for (Operator operator : values()) { // Compares all operator symbols to parameter in a for loop
			if (operator.symbol == c) {
				return operator;
			}
		}
		return null; // Return null if the character doesn't correspond to a valid operator
	}
}