import java.math.BigDecimal; 
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class Calculator {
	// Instance variables initialized here
	private static BigDecimal firstNumber, secondNumber, result;
	private static boolean goAgain;
	private static Operator operator;


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
		switch (operator) {
			case ADDITION:
				return numA.add(numB);
			case SUBTRACTION:
				return numA.subtract(numB);
			case MULTIPLICATION:
				return numA.multiply(numB);
			case DIVISION:
				return numA.divide(numB, new MathContext(8, RoundingMode.HALF_UP)); // Precision of 8 digits is used for division, with the last number rounding up if it's >= 5.
			case MODULO:
				return numA.remainder(numB);
			default:
				return BigDecimal.ZERO; // Should never happen since operator can only hold valid elements, but Java complains if there isn't a default case
		}
	}
	
	public static Operator getOperator() {
		return operator;
	}


	
	public static void main (String[] args) {
		try (Scanner scanner = new Scanner(System.in)) { 
			do {
				// Input for first number and operator
				firstNumber = Input.getNumberInput("Tell me your first number.", scanner);
				operator = Input.getOperatorInput("Now, tell me what operation you want to use. Your options are +, -, *, /, and %.", scanner);
				secondNumber = Input.getNumberInput("Finally, tell me another number.", scanner);
				result = performOperation(firstNumber, operator, secondNumber);
				System.out.println(firstNumber + " " + operator.getSymbol() + " " + secondNumber + " = " + result); // Prints full math equation
				// Asks if user wants to go again
				goAgain = Input.getYesNoInput("Would you like to go again? Type \"y\" for yes, and \"n\" for no.", scanner);
				if (!goAgain) {
					System.out.println("Shutting down...");
				}
				operator = null; // Resets operator to null before the loop continues. Not the best fix, but better than the alternatives
			} while (goAgain); // After the do-while loop has gone through once, it will check if goAgain has been set to y before repeating again.
		}
	}
}
