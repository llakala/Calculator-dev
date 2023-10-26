import java.util.InputMismatchException;
import java.util.Scanner;
import java.math.BigDecimal;


/**
* Input.java
* This class provides helper methods for use in the Calculator.java class, pertaining specifically to user input
*/
class Input {
	// Variables are initialized as static instance variables to keep performance consistent during each loop
	private static BigDecimal inputNum;
	private static boolean isDividing;
	private static char operatorInput;
	private static Operator operator;
	private static char yesOrNoInput;
	private static boolean isInputYes;

/**
	* Method used to accept number input for calculations. The BigDecimal type is used to allow better precision and prevent floating-point errors.
	* Preconditions: 
		* Parameters are not null.
		* Scanner has been initialized.		
		* operator variable is null if this is the first number being inputted, and not null if this is the second number being inputted.
	* Postconditions: 
		* The user has inputted a numerical value.
		* Divison by zero has been prevented.
 */
	public static BigDecimal getNumberInput(String message, Scanner scanner) {
		operator = Calculator.getOperator(); // getOperator method is a getter which returns the operator. If this is the first number being checked for, operator will be null.
		System.out.println(message);
		while (true) // Loop repeats forever until postconditions are passed
		{
			try 
			{
				inputNum = scanner.nextBigDecimal(); 
				isDividing = (operator == operator.DIVISION); 

				if (isDividing && inputNum.compareTo(BigDecimal.ZERO) == 0) // Give error message and restarts loop if dividing by zero
				{ 
					System.err.println("You can't divide by zero! Please choose another number.");
				}
				else 
				{
					return inputNum; // Only returns input if we aren't dividing by zero
				}
			}
			catch(InputMismatchException e) // Catches InputMismatchException if user doesn't input a number
			{
				System.err.println("That's not a number! Please try again.");
				scanner.next(); // scanner.next() is needed when catching errors to prevent an infinite loop, but not needed in if/else cases (for some reason)
			}
		}
	}


	
	/**
		* Method used to accept operators. The enum Operator is used, which only accepts certain characters as input. Documentation on this can be found in Operator.java.
		* Preconditions: 
			* Parameters don't equal null
			* Scanner has been initialized
		* Postconditions: 
			* The user has selected a valid element of the Operator enum.
	 */
	public static Operator getOperatorInput(Scanner scanner) 
	{
		System.out.println("Now, tell me what operation you want to use. Your options are +, -, *, /, and %.");
		while (true) // While loop repeats forever until postconditions are passed
		{
			operatorInput = scanner.next().charAt(0); // These two method calls combined create the equivalent of a scanner.nextChar method. Keep in mind that only the first char of the input is taken.
			operator = Operator.fromChar(operatorInput); // Character input is transferred from character form to written-out form using Operator.fromChar method

			if (operator == null) // Only occurs if invalid char (one that isn't an operator) was inputted
			{ 
				System.err.println("That's not a valid operator! Please try again.");
			}
			else // If operator is NOT null
			{
				return operator;
			}
		}
	}


	
	/**
		* Method used to accept yes/no input on restarting code
		* Preconditions: 
			* Parameters don't equal null
			* Scanner has been initialized
		* Postconditions: 
			* User has inputted yes or no. 
	 */
	public static boolean getYesNoInput(Scanner scanner) {
		System.out.println("Would you like to go again? Type \"y\" for yes, and \"n\" for no.");
		while (true) { // Loops forever until postconditions are passed.
			yesOrNoInput = Character.toLowerCase(scanner.next().charAt(0)); // Takes lowercase scanner input so uppercase doesn't have to be checked for every time
			if (yesOrNoInput != 'y' && yesOrNoInput != 'n')
			{
				System.err.println("That's not y or n! Please try again.");
			}
			else // Only runs if input was either 'y' or 'n'
			{
				isInputYes = (yesOrNoInput == 'y'); 
				if (!isInputYes) {
					System.out.println("Shutting down...");
				}
				return isInputYes; // Returns boolean that checks if the input was 'y'.
			}
		}
	}

}