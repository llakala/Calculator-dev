// Import InputMismatchException to catch incorrect input type, Scanner to allow user input, and BigDecimal to perform math without floating-point errors
import java.util.InputMismatchException;
import java.util.Scanner;
import java.math.BigDecimal;


class Input {

	
	public static BigDecimal getNumberInput(String message, Scanner scanner, boolean dividing) {
		BigDecimal input;
		System.out.println(message);
		while (true) // Loops forever unless broken (loop only broken when input is a number)
		{
			try // Tries to assign input to scanner.nextBigDecimal(), but if a number isn't entered, throws an error
			{
				input = scanner.nextBigDecimal();
				if (0 != (input.compareTo(BigDecimal.ZERO)) || !dividing) // If dividing (checked via isDividing method), and input is 0 for second number, make user choose new input
				{
					break;
				}
				else
				{
					System.err.println("You can't divide by zero! Please choose another number.");
					scanner.next();
				}
			}
			catch(InputMismatchException e) // Catches InputMismatchException if user doesn't input a number
			{
				System.err.println("That's not a number! Please try again.");
				scanner.next();
			}
		}
		return input;
	}



	public static Operator getOperatorInput(String message, Scanner scanner) 
	{
		Operator operator;
		char inputChar;
		System.out.println(message);
		while (true) // Loops forever unless broken (loop only broken when input is an operator)
		{
			try { // 
				inputChar = scanner.next().charAt(0);
				operator = Operator.fromChar(inputChar);
				if (operator != null) {
					break; // 
				} else { // If some other character is entered, this makes the user try again until an operator is provided
					System.err.println("That's not a valid operator! Please try again.");
					scanner.next();
				}
			} catch (InputMismatchException e) { // Catches InputMismatchException if user doesn't input a char and makes user try again until an operator is provided
				System.out.println("That's more than one character! Please try again.");
				scanner.next();
			}
		}
		return operator;
	}






	public static boolean getYesNoInput(String message, Scanner scanner) {
		char yesOrNo;
		System.out.println(message);
		while (true) // Loops forever unless broken (loop only broken when input is either y or n)
		{
			try // Tries to assign input to scanner.next().charAt(0), but if a character isn't entered, it throws an error
				{
					yesOrNo = scanner.next().charAt(0);
					if (yesOrNo == 'y'
						|| yesOrNo == 'Y'
						|| yesOrNo == 'n'
						|| yesOrNo == 'N')
					{
						break; // Breaks out of loop to return yn
					}
					else // If some other character is entered, this makes the user try again until y/n is provided
					{
						System.err.println("That's not y or n! Please try again.");
						scanner.next();
					}
				}
			catch (InputMismatchException e) // Catches InputMismatchException if user doesn't input an int, makes the user try again until y/n is provided
				{
					System.out.println("That's more than one character! Please try again.");
					scanner.next();
				}
		}
		return (yesOrNo == 'y'
				|| yesOrNo == 'Y'
				|| yesOrNo == 'n'
				|| yesOrNo == 'N');
	}

}
