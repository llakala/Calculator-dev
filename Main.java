import java.util.Scanner; // Import scanner for scanning

class Main {
  public static void main(String[] args) {
	  // Initialize variables here
	  Scanner myObj = new Scanner(System.in); 
	  int firstNumber, secondNumber, result;
	  char operator;
	  char goAgain = 'y';
	  
	  while (goAgain == 'y')
		 {
			  firstNumber = getIntegerInput("Tell me your first number. It has to be an integer.", myObj);
			  secondNumber = getIntegerInput("Now, tell me another integer.", myObj);
			  operator = getOperatorInput("Finally, tell me what operation you want to use. Your options are +, -, *, /, and %.", myObj);
			  
			  switch (operator) {
				  case '+':
					  result = MyMath.add(firstNumber, secondNumber);
					  break;
				  case '-':
					  result = MyMath.subtract(firstNumber, secondNumber);
					  break;
				  case '*':
					  result = MyMath.multiply(firstNumber, secondNumber);
					  break;
				  case '/':
					  result = MyMath.divide(firstNumber, secondNumber);
					  break;
				  case '%':
					  result = MyMath.modulo(firstNumber, secondNumber);
					  break;
				  default:
					  result = -1; // This should never happen
			  }
			  System.out.println("Your answer is " + result);
			  goAgain = getCharInput("Would you like to go again? Type \"y\" for yes, and \"n\" for no.", myObj);
		  }
  }



	public static int getIntegerInput(String message, Scanner scanner) {
		System.out.println(message);
		while (!scanner.hasNextInt()) {
		  System.out.println("That's not an integer! Please try again.");
		  scanner.nextInt();
		}
		return scanner.nextInt();
	  }



	public static char getOperatorInput(String message, Scanner scanner) {
		System.out.println(message);
		char o = scanner.next().charAt(0);
		while (o != '+'
			   && o != '-' 
			   && o != '*'
			   && o != '/' 
			   && o != '%')
		{
			System.out.println("That's not a valid operator! Please try again.");
			o = scanner.nextLine().charAt(0);
		}
		return o;
	  }
	public static char getCharInput(String message, Scanner scanner) {
		System.out.println(message);
		char yn = scanner.next().charAt(0);
		while (yn != 'y'
			   && yn != 'n')
		{
			System.out.println("You didn't say y or n! Please try again.");
			yn = scanner.nextLine().charAt(0);
		}
		return yn;
	  }
}