// Enum defines the valid mathematical operators that can be used in the Calculator program. It has two fields: symbol and name. The symbol is a string that represents the operator in a mathematical expression, such as "+". The name is an identifier that corresponds to the symbol, such as ADDITION. The name is also the default value returned by the toString() method of the enum. To get the symbol, the getSymbol() method must be used.  
public enum Operator {
	ADDITION("+"),
	SUBTRACTION("-"),
	MULTIPLICATION("*"),
	DIVISION("/"),
	MODULO("%");

	private final String symbol; // Field stores the symbol of each operator as a string. It is final because it cannot be changed after initialization. 

	/** 
		Constructor assigns symbol of an operator object to the given parameter.  
		@param Given symbol by the user
 	*/
	Operator(String symbol) {
		this.symbol = symbol;
	}
	
	/** 
 		* Getter method that returns the symbol of an operator as a string. It is not a static method, so it must be called on an instance of the enum. 
		* @return The symbol of the object's operator. 
 	*/
	public String getSymbol() {
		return symbol;
	}


	/** 
		Method that takes a string as a parameter and tries to match it with the symbol of any operator in the enum. If there is a match, it returns the corresponding operator as an enum instance. If there is no match, it returns null. 
		@param input Inputted symbol to be compared with all valid operator symbols
		@return Operator's name field that matches the input, or null if there is no match.
	*/
	public static Operator symbolToOperator(String input) {
		for (Operator operator : values()) { // Loops iterates over all valid Operator values.
			if ((operator.symbol).equals(input)) { // If given symbol is equal to any operator symbols. 
				return operator;
			}
		}
		return null; // Return null if there are no matching operators
	}
}