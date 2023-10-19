import java.util.InputMismatchException; // Import InputMismatchException to catch errors
import java.util.Scanner; // Import scanner for scanning
class Input {


	public static int getIntegerInput(String message, Scanner scanner, boolean dividing) {
		int input;
		System.out.println(message);
		while (true) // Loops forever unless broken (loop only broken when input is an integer)
		{
			try // Tries to assign input to scanner.nextInt(), but an if int isn't entered, throws an error
			{
				input = scanner.nextInt();
				if (input == 0 && dividing) // If dividing (checked via isDividing method), and input is 0 for second number, make user choose new input
				{
					System.err.println("You can't divide by zero! Please choose another number.");
				}
				else
				{
				break; // Breaks out of loop to return input
				}
			}
			catch(InputMismatchException e) // Catches InputMismatchException if user doesn't input an int
			{
				System.err.println("That's not an integer! Please try again.");
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
			try // Tries to assign input to scanner.next().charAt(0), but if a char isn't entered, it throws an error
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



	public static boolean isDivision(char o) 
	{
		if (o == '/') // If operator is /, return true. Else, return false.
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
