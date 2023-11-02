import java.math.BigDecimal; 
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

/**
	* Calculator.java
	* A simple calculator program that takes two number and an operator from the user with the Scanner class, and performs the corresponding arithmetic operation. 
	* The program uses the BigDecimal class to handle decimal numbers and avoid floating-point errors. The program also allows the user to repeat the calculation with new numbers and operators. 
*/
public class Calculator {
	// Class variables are declared here for best performance upon multiple loop iterations.
	private static BigDecimal firstNumber, secondNumber, result;
	private static Operator operator;
	private static boolean goAgain;
	private static final MathContext precision = new MathContext(8, RoundingMode.HALF_UP);

	/**
		* This method resets the operator variable to null for each time the main method loops.
		* This is done to avoid issues where the code loops but the operator still has the value from the previous iteration stored. For more info, see the Input.getNumberInput method. 
	*/
	public static void reset() {
		operator = null;
	}
	
	/**
		* Method used to perform the correct mathematical operation on two numbers based on the inputted operator. 
		* Switch/case is used instead of if/else for improved performance upon multiple loops. MathContext handles precision and roundng for decimal numbers, and is used when dividing. 
		* @param firstNum The first number inputted by the user. 
		* @param operator The operator chosen by the user
		* @param secondNum The second number inputted by the user. 
		* @return The result of the mathematical operation as a BigDecimal number.
	*/
	private static BigDecimal performOperation(BigDecimal firstNum, Operator operator, BigDecimal secondNum) {
		return switch (operator) {
			case ADDITION -> firstNum.add(secondNum);
			case SUBTRACTION -> firstNum.subtract(secondNum);
			case MULTIPLICATION -> firstNum.multiply(secondNum);
			case DIVISION -> firstNum.divide(secondNum, precision); // Precision of 8 digits is used for division, with the last number rounding up if it's >= 5.
			case MODULO -> firstNum.remainder(secondNum);
		};
	}
	

	
/**
	* Getter method used to get operator value from other classes.
	* This is used in the Input class to prevent division by zero when taking number input. 
	* @return The operator variable as an Operator object
*/
	public static Operator getOperator() {
		return operator;
	}


	/**
		* Main method where code starts. 
		* A do/while loop is used to repeat the code for new numbers and a new operator. Helper methods from Input class are used for getting user input. 
	 */
	public static void main (String[] args) {
		Calculator calc = new Calculator();
		Scanner scan = Input.getScanner();
		try (scan) {
			do { 
				// Values are inputted for the first three numbers using helper methods from the Input class. 
				firstNumber = Input.getNumberInput("Tell me your first number.");
				operator = Input.getOperatorInput();
				secondNumber = Input.getNumberInput("Finally, tell me another number.");

				result = performOperation(firstNumber, operator, secondNumber); // Uses a Calculator method to perform the correct operation on the numbers based on which operator is used.
				System.out.println(String.format("%s %s %s = %s", firstNumber, operator.getSymbol(), secondNumber, result));
				reset(); // Resets operator variable to null to prevent using the previous value if the code loops
				
				goAgain = Input.getYesNoInput(); // Asks user whether they want to go again, stored as a boolean
			} while (goAgain); // Will only repeat if goAgain is true.
		}
	}
}
