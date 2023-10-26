import java.math.BigDecimal; 
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

/**
* Calculator.java
* This class holds the main method along with all calculation-based helper methods. If the method isn't based around user input or the Operator enum, it'll be here.
*/
public class Calculator {
	// Instance variables initialized here
	private static BigDecimal firstNumber, secondNumber, result;
	private static boolean goAgain;
	private static Operator operator;
	private static final Scanner scanner = new Scanner (System.in);


	/**
		* Method used to perform math with two numbers using the given operation. Note: See documentation on Operator enum in the Operator.java class.
		* Preconditions: 
			* Parameters have all been chosen based on user input
			* Operator is a valid case
			* Division by zero has been prevented
		* Postconditions: 
			* The correct math has been performed based on the operator input. 
	 */
	private static BigDecimal performOperation(BigDecimal numA, Operator operator, BigDecimal numB) {
		return switch (operator) {
			case ADDITION -> numA.add(numB);
			case SUBTRACTION -> numA.subtract(numB);
			case MULTIPLICATION -> numA.multiply(numB);
			case DIVISION -> numA.divide(numB, new MathContext(8, RoundingMode.HALF_UP)); // Precision of 8 digits is used for division, with the last number rounding up if it's >= 5.
			case MODULO -> numA.remainder(numB);
		};
	}


	
	/**
		* Getter method used to get operator value from other classes.
	 */
	public static Operator getOperator() {
		return operator;
	}


	/**
		* Main method where code starts. 
  		* Preconditions: 
			* Instance variables have all been initialized
		* Postconditions (per loop): 
			* The user's inputted numbers and operator have resulted in the correct answer. If the user inputted yes, the code has repeated. 
	 */
	public static void main (String[] args) {
		try (scanner) { 
			do {
				// Values are inputted for the first three numbers using helper methods from the Input class. 
				firstNumber = Input.getNumberInput("Tell me your first number.", scanner);
				operator = Input.getOperatorInput(scanner);
				secondNumber = Input.getNumberInput("Finally, tell me another number.", scanner);

				result = performOperation(firstNumber, operator, secondNumber); // Uses a Calculator method to perform the correct operation on the numbers based on which operator is used.
				System.out.println(firstNumber + " " + operator.getSymbol() + " " + secondNumber + " = " + result); // Prints full math equation
				operator = null; // Resets operator to null before the loop resets. Not the best fix, but better than the alternatives

				goAgain = Input.getYesNoInput(scanner); // Stores whether user wants to go again as a boolean

			} while (goAgain); // After the do-while loop has gone through once, it will check if goAgain is true before repeating.
		}
	}
}
