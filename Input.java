import java.util.InputMismatchException;
import java.util.Scanner;
import java.math.BigDecimal;


/**
	* Input.java
	* This class handles the user input for the Calculator.java class. It also validates the input and prevents errors such as division by zero.
	* The Scanner class is used to read input from the console, and the custom Operator enum is used to represent different arithmetic operators. 
*/
class Input {
	// Variables are declared as class variables to keep performance consistent during each loop
	public static final Scanner scanner = new Scanner (System.in);
	private static String strInput;
	private static BigDecimal numInput;
	private static Operator operator;


	/**
		This method reads a line of input from the user and trims any leading or trailing whitespace. If the input is empty, it prints an error message and prompts the user to enter something. It repeats this process until a non-empty input is received.
		* @return A non-empty string input from the user
	 */
	private static String readInput() {
		do { 
			strInput = scanner.nextLine().trim(); 
			if (strInput.isEmpty()) {
				System.err.println("You didn't enter anything! Please try again.");
			}

		} while (strInput.isEmpty()); // Will now repeat loop until strInput is no longer empty
		return strInput; 
	}

	
	/**
	* This method converts a string input into a BigDecimal object. Before returning the input, the method checks if the input is a valid number, and that the input is not zero when the operator is division.
 	* The Calculator.getOperator method is used to get the current operator, which is null if this is the first number being entered. If the input is invalid, the method prints an error message and the user is prompted to enter a new number.  
	* @param message The message to prompt the user for entering a number. Differs depending on if the number being inputted is the first or second number. 
	* @return A valid BigDecimal object representing the user input, that won't result in division by zero
 */
	public static BigDecimal getNumberInput(String message) {
		operator = Calculator.getOperator(); // This method call returns null if this is the first number being set, and the current operator if this is the second number.  
		System.out.println(message);
		
		while (true) { // Loop runs indefinitely until a valid number is returned
			try {
				numInput = new BigDecimal(readInput()); // Tries to convert the input into a BigDecimal object, and throws an exception if it fails. The readInput() method call ensures the input isn't null. 

				if (operator == operator.DIVISION && BigDecimal.ZERO.equals(numInput)) { // Condition checks if the operator is division and if the input is zero, which would cause an error. 
					System.err.println("You can't divide by zero! Please choose another number.");
				}

				else // Returns input if all validation is passed
					return numInput; 
			}

			catch(NumberFormatException e) { // Block catches NumberFormatException if user doesn't input a number
				System.err.println("That's not a number! Please try again.");
				continue; // Resets to beginning of while loop for new user input
			}
		}
	}



	/**
		* This method converts a String input and converts it into an object of the Operator enum. Before the operator input is returned, the method ensures the input is a valid operator. 
  		* The Operator.fromString method call is used, which will return null if the input isn't a valid operator. If the input is found to be invalid, an error message is printed and the user is then prompted to input a valid operator. 
		* @return A valid Operator object chosen by the user input
	 */
	public static Operator getOperatorInput() {
		System.out.println("Now, tell me what operation you want to use. Your options are +, -, *, /, and %.");

		while (true) { // While loop runs indefinitely until a valid operator is returned
			strInput = readInput();
			operator = Operator.symbolToOperator(strInput); // Method call converts the user's inputted character into an Operator object (or null if the input was invalid)

			if (operator == null) { // Condition checks if the input was invalid
				System.err.println("That's not a valid operator! Please try again.");
			}

			else { // Branch returns operator if it was valid
				return operator;
			}
		}
	}


	
	/**
		This method asks the user if they want to go again or not. 
  		* If the input is "y", the method returns true. If the input is "n", the method returns false and prints a message saying "Shutting down...". If the input is neither "y" nor "n", it prints an error message and asks the user to enter either "y" or "n". It repeats this process until a valid input is received.
		@return A boolean value representing the user's choice to go again or not go again
	 */
	public static boolean getYesNoInput() {
		System.out.println("Would you like to go again? Type \"y\" for yes, and \"n\" for no.");

		while (true) { // Loop runs indefinitely until a valid input is returned
			strInput = readInput(); // Method call prevents a null input

			if (strInput.equalsIgnoreCase("y")) { // Condition checks if input was "y" (case insensitive)
				return true;
			}

			else if (strInput.equalsIgnoreCase("n")) { // Condition checks if input was "y" (case insensitive)
				System.out.println("Shutting down...");
				return false;
			}

			else { // Handles all other input that is neither "y" nor "n". 
				System.err.println("Please enter something!");
			}

		}
	}
	public static Scanner getScanner() {
		return scanner;
	}
}