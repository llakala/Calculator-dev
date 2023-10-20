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
				if (0 == (input.compareTo(BigDecimal.ZERO)) && dividing) // If dividing (checked via isDividing method), and input is 0 for second number, make user choose new input
				{
					System.err.println("You can't divide by zero! Please choose another number.");
				}
				else
				{
					break; // Breaks out of loop to return input
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



	public static char getOperatorInput(String message, Scanner scanner) 
	{
		char o;
		System.out.println(message);
		while (true) // Loops forever unless broken (loop only broken when input is an operator)
		{
			try // Tries to assign input to scanner.next().charAt(0), but if a char isn't entered,  throws an error
				{
					o = scanner.next().charAt(0);
					if (o == '+' 
						|| o == '-' 
						|| o == '*' 
						|| o == '/' 
						|| o == '%')
					{
						break; // Breaks out of loop to return o
					}
					else // If some other character is entered, this makes the user try again until an operator is provided
					{
						System.err.println("That's not a valid operator! Please try again.");
					}
				}
			catch (InputMismatchException e) // Catches InputMismatchException if user doesn't input a char and makes user try again until an operator is provided
				{
					System.out.println("That's more than one character! Please try again.");
				}
		}
		return o;
	}


// If operator is /, return true. Else, return false.
	public static boolean isDivision(char o) 
	{
		if (o == '/') 
			return true;
		else
			return false;
	}



	public static char getYesNoInput(String message, Scanner scanner) {
		char yn;
		System.out.println(message);
		while (true) // Loops forever unless broken (loop only broken when input is either y or n)
		{
			try // Tries to assign input to scanner.next().charAt(0), but if a character isn't entered, it throws an error
				{
					yn = scanner.next().charAt(0);
					if (yn == 'y'
						|| yn == 'Y'
						|| yn == 'n'
						|| yn == 'N')
					{
						break; // Breaks out of loop to return yn
					}
					else // If some other character is entered, this makes the user try again until y/n is provided
					{
						System.err.println("That's not y or n! Please try again.");
					}
				}
			catch (InputMismatchException e) // Catches InputMismatchException if user doesn't input an int, makes the user try again until y/n is provided
				{
					System.out.println("That's more than one character! Please try again.");
				}
		}
		return yn;
	}

}
