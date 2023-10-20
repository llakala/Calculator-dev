// Import BigDecimal to perform math without floating-point errors, MathContext to specify precision for division, and RoundingMode to round up for precision. 
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
class MyMath {
// Add BigDecimals a and b
	public static BigDecimal add(BigDecimal a, BigDecimal b) { 
		return a.add(b);
	}
// Subtract BigDecimal b from BigDecimal a. 
	public static BigDecimal subtract(BigDecimal a, BigDecimal b) {
		return a.subtract(b);
	}
// Multiply BigDecimals a by  b
	public static BigDecimal multiply(BigDecimal a, BigDecimal b) {
		return a.multiply(b);
	}
// Divide a by b, rounded up to the nearest integer. Precision of 4 (aka 4 digits after decimal point allowed)
	public static BigDecimal divide(BigDecimal a, BigDecimal b) { 
		return a.divide(b, new MathContext(4, RoundingMode.HALF_UP)); 
		
	}
// Find remainder of BigDecimal a divided by BigDecimal b
	public static BigDecimal modulo(BigDecimal a, BigDecimal b) {
		return a.remainder(b);
	}
}
