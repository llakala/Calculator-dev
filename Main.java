import java.util.Scanner; 
import java.math.BigDecimal; 


class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) { 
			// Initialized variables outside of the while loop to improve performance
			BigDecimal firstNumber, secondNumber, result;
			Operator operator;
			boolean isDividing = false; 
			boolean goAgain;
			do {
				// Input for first number and operator
				firstNumber = Input.getNumberInput("Tell me your first number.", scanner, isDividing);
				operator = Input.getOperatorInput("Now, tell me what operation you want to use. Your options are +, -, *, /, and %.", scanner);
				
				// Checks if operator is division to prevent division by zero
				isDividing = Calculator.isDivision(operator); 
				
				// Input for second number and result
				secondNumber = Input.getNumberInput("Finally, tell me another number.", scanner, isDividing);
				result = Calculator.performOperation(firstNumber, operator, secondNumber);

				System.out.println(firstNumber + " " + operator.getSymbol() + " " + secondNumber + " = " + result); // Prints full math equation

				// Asks if user wants to go again
				goAgain = Input.getYesNoInput("Would you like to go again? Type \"y\" for yes, and \"n\" for no.", scanner);

				// Resets isDividing to false for the next loop
				isDividing = false;

				if (!goAgain) {
					System.out.println("Shutting down...");
				}
			} while (goAgain); // After the do-while loop has gone through once, it will check if goAgain has been set to y before repeating again.
		}
	}
}
