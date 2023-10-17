import java.util.Scanner; // Import scanner for scanning

class Main {
  public static void main(String[] args) {
	  // Initialize variables here
	  Scanner myObj = new Scanner(System.in); 
	  int firstNumber = getIntegerInput("Tell me your first number. It has to be an integer.", myObj);
	  int secondNumber = getIntegerInput("Now, tell me another integer.", myObj);
	  char operator = getOperatorInput("Finally, tell me what operation you want to use. Your options are +, -, *, /, and %.", myObj);
	  int result; 
	  switch (operator) {
		  case '+':
			  result = MyMath.add(firstNumber, secondNumber);
		  case '-':
			  result = MyMath.subtract(firstNumber, secondNumber);
		  case '*':
			  result = MyMath.multiply(firstNumber, secondNumber);
		  case '/':
			  result = MyMath.divide(firstNumber, secondNumber);
		  case '%':
			  result = MyMath.modulo(firstNumber, secondNumber);
	  }
	  System.out.println("Your answer is " + result);
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
}