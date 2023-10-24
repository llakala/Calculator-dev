import java.math.BigDecimal; 
import java.math.MathContext;
import java.math.RoundingMode;

public class Calculator {
	public static BigDecimal performOperation(BigDecimal numA, Operator operator, BigDecimal numB) {
		switch (operator) {
			case ADDITION:
				return numA.add(numB);
			case SUBTRACTION:
				return numA.subtract(numB);
			case MULTIPLICATION:
				return numA.multiply(numB);
			case DIVISION:
				return numA.divide(numB, new MathContext(1000, RoundingMode.HALF_UP)); 
			case MODULO:
				return numA.remainder(numB);
			default:
				System.out.println("Invalid operator! This is bad and means either the getOperatorInput isn't catching all non-operators, or the switch statement isn't breaking correctly.");
				return numA;
		}
	}
	// If operator is /, return true. Else, return false.
	public static boolean isDivision(Operator operator) 
		{
			return (operator == Operator.DIVISION);
		}
}
