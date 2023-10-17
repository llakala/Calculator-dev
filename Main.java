import java.util.Scanner; // Import scanner for scanning

class Main {
  public static void main(String[] args) {
	  // Initialize variables here
	  Scanner myObj = new Scanner(System.in); 
	  String firstInput = "", secondInput = "", operatorInput = ""; // String variables hold the inputs until they are typecast
	  int firstVar, secondVar, counter, product; // Variables are held as integers, will be BigDecimals for version 1.0
	  char operator; 
	  

	  System.out.println("Tell me your first number. It has to be an integer.");
	  for (counter = 1; counter <= 2; counter++) // Loops twice to scan for two separate variables
		  {
			  while (!myObj.hasNextInt()) // While loop that only occurs if input doesn't contain int. BIGDECIMALIFY FOR 1.0 
			  {
				  System.out.println("That's not an integer! Please try again, you doofus.");
				  if (counter == 1) // Stores to firstInput on the first loop
					  firstInput = myObj.nextLine();
				  else // Stores to secondInput on the second loop
					  secondInput = myObj.nextLine();
			  }
			  if (counter == 1)
			  {
				  firstInput = myObj.nextLine();
				  System.out.println("Now, tell me another integer.");
			  }
			  else
				  secondInput = myObj.nextLine();
		  }
	  firstVar = Methods.parseNum(firstInput); // Parses firstInput into an integer
	  secondVar = Methods.parseNum(secondInput); // Parses secondInput into an integer
	  System.out.println("Finally, tell me what operation you want to use. Your options are +, -, *, /, and %.");
	  operatorInput = myObj.nextLine();
	  while (operatorInput.indexOf("+") != 0
		  && operatorInput.indexOf("-") != 0
		  && operatorInput.indexOf("*") != 0
		  && operatorInput.indexOf("/") != 0
		  && operatorInput.indexOf("%") != 0)
		  {
			  System.out.println("You didn't say any of the operators. Please try again.");
			  operatorInput = myObj.nextLine();
		  }
	  operator = operatorInput.charAt(0);
	  if (operator == '+')
		  product = firstVar + secondVar;
	  else if (operator == '-')
		  product = firstVar - secondVar;
	  else if (operator == '*')
		  product = firstVar * secondVar;
	  else if (operator == '/')
		  product = firstVar / secondVar;
	  else
		  product = firstVar % secondVar;
	  System.out.println("Your answer is " + product);
  }
}