// Import Scanner and BigDecimal for scanning user input and performing math operations without floating point issues
import java.util.Scanner; 
import java.math.BigDecimal; 


class Main {
  public static void main(String[] args) {
	  // Variables are defined here outside of the while loop to improve performance
	  Scanner myObj = new Scanner(System.in); 
	  StringBuilder sb = new StringBuilder(); // Used to concatenate char into string
	  BigDecimal firstNumber, secondNumber, result = new BigDecimal("-1"); 
	  char operator;
	  boolean isDividing; // Used to prevent division by zero
	  char goAgain = 'y'; // goAgain is defined as 'y' originally to allow the while loop to run at least once

	  while (goAgain == 'y' || goAgain == 'Y') // While loop will loop as long as user inputs "y" when code ends
	  {
		  // Resets isDividing and string builder at the beginning of every loop
		  sb.setLength(0); 
		  isDividing = false; 

		  // Input is taken by calling methods getIntegerInput and getOperatorInput, saved to variables for later use. isDivison method used to prevent division by zero
		  firstNumber = Input.getNumberInput("Tell me your first number. It can be a whole number, or include a decimal point (2 and 2.5 would both be valid inputs).", myObj, isDividing);
		  operator = Input.getOperatorInput("Now, tell me what operation you want to use. Your options are +, -, *, /, and %.", myObj);
		  isDividing = Input.isDivision(operator); 
		  secondNumber = Input.getNumberInput("Finally, tell me another number.", myObj, isDividing);

		  // Result is calculated by calling each MyMath method, output is saved to result to be printed later. Switch/case is used instead of if/else because of it supposedly being more efficient
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
				  result = BigDecimal.valueOf(-1); // This should never happen since I check for operators in the getOperatorInput method, but I get an error message if I don't set result in every case
				  System.out.println("Invalid operator! This is bad and means either the getOperatorInput isn't catching all non-operators, or the switch statement isn't breaking correctly.");
		  }
		  
		  System.out.println(firstNumber + " " + sb.append(operator) + " " + secondNumber + " = " + result); // Prints the math operation that was performed and the result. sb.append is used to cast the char operator to a string

		  // Code will only repeat if user inputs y (not case sensitive)
		  goAgain = Input.getYesNoInput("Would you like to go again? Type \"y\" for yes, and \"n\" for no.", myObj);
		  if (goAgain == 'n' || goAgain == 'N') 
			  System.out.println("Shutting down...");
	  }	
	}
}